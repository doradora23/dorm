package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class View_access extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_access);
        setTitle("출입 정보 보기");

        final ArrayList<Access_class> access_list = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_access.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    ListView listView = (ListView)findViewById(R.id.listview4);
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Access_class temp = new Access_class(arr.getJSONObject(i));
                        access_list.add(temp);

                    }
                    Access_Adapter adapter = new Access_Adapter(access_list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();

        final ArrayList<out_class> out_classes = new ArrayList<>();
        ConnectThread connectThread2 = new ConnectThread(this, "view_out.php");
        connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    ListView listView = (ListView)findViewById(R.id.listview2);
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        out_class temp = new out_class(arr.getJSONObject(i));
                        out_classes.add(temp);

                    }
                    Out_Adapter adapter = new Out_Adapter(out_classes);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread2.start();

        Button btn = (Button)findViewById(R.id.button17);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               finish();
            }
        });
    }

}
