package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Out_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_view);

        setTitle("신청한 외박정보 보기");
         String num = "";
        Intent intent = getIntent();

        if (intent.getStringExtra("activity").equals("MenuActivity_Student")) {
            num = (String) intent.getSerializableExtra("학생");
        }else if(intent.getStringExtra("activity").equals("MenuActivity_FloorMaster")){
            num = (String) intent.getSerializableExtra("층장");
        }
            final ArrayList<apply_out_class> apply_out_list = new ArrayList<>();
            ConnectThread connectThread = new ConnectThread(this, "view_applystudent.php?num=" + num);
            connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
                @Override
                public void onResult(String result) {
                    try {
                        JSONArray arr = new JSONArray(result);
                        for (int i = 0; i < arr.length(); i++) {
                            apply_out_class temp = new apply_out_class(arr.getJSONObject(i));
                            apply_out_list.add(temp);
                        }

                        final ListView out_listview = (ListView)findViewById(R.id.listview);
                        Out_View_Adapter adapter = new Out_View_Adapter(apply_out_list);
                        out_listview.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            connectThread.start();


    }
}
