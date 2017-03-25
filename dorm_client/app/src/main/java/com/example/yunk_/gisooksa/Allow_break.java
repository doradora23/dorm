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

import java.util.ArrayList;
import java.util.List;

public class Allow_break extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allow_break);
        setTitle("고장접수확인");


        final ArrayList<break_class> break_list = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_break.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        break_class temp = new break_class(arr.getJSONObject(i));
                        break_list.add(temp);
                    }
                    final ListView break_listview = (ListView)findViewById(R.id.break_listview);
                    BreakAdapter adapter = new BreakAdapter(break_list);
                    break_listview.setAdapter(adapter);
                    Button apply_btn = (Button)findViewById(R.id.button18);
                    apply_btn.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            final EditText allow_num = (EditText)findViewById(R.id.editText12);
                            String flag = allow_num.getText().toString();
                            ConnectThread connectThread2 = new ConnectThread(Allow_break.this, "process_break.php?breaknum=" + flag + "&is_processed=1");
                            connectThread2.start();
                            Toast.makeText(getApplicationContext(), "고장접수처리 완료", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MenuActivity_Admin.class);
                            startActivity(intent);

                            finish();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();






    }
}
