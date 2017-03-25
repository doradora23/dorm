package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewScore extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_score);
        setTitle("상벌점 확인");


        Intent intent = getIntent();
        Student student;
        Student floorMaster;
        String num = "";
        if (intent.getStringExtra("activity").equals("MenuActivity_Student")) {
            student = (Student) intent.getSerializableExtra("학생");
            num = student.getNum();
        } else if (intent.getStringExtra("activity").equals("MenuActivity_FloorMaster")) {
            floorMaster = (FloorMaster) intent.getSerializableExtra("층장");
            num = floorMaster.getNum();
        }

        final ArrayList<Score> score_list = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_score.php?num=" + num);
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Score temp = new Score(arr.getJSONObject(i));
                        score_list.add(temp);
                    }

                    final ListView listView = (ListView) findViewById(R.id.listview);
                    ScoreAdapter adapter = new ScoreAdapter(score_list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();


        ConnectThread connectThread2 = new ConnectThread(this, "total_score.php?num=" + num);
        connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    TextView textView = (TextView) findViewById(R.id.textView10);
                     JSONArray arr = new JSONArray(result);
                      textView.setText("총 " +  arr.getString(0) + "점");
                    btn = (Button) findViewById(R.id.button14);
                    btn.setOnClickListener(new View.OnClickListener() {//이전메뉴로버튼
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread2.start();//db받을때*/
        btn = (Button) findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {//이전메뉴로버튼
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
