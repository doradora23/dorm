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

public class Give_score extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_score);
        setTitle("상벌점 부여");

        final Intent intent = getIntent();
        btn = (Button) findViewById(R.id.button16);
        final ArrayList<Student> students = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_student.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Student temp = new Student(arr.getJSONObject(i));
                        students.add(temp);
                    }

                    final ListView listview = (ListView) findViewById(R.id.listview3);
                    StudentAdapter adapter = new StudentAdapter(students);
                    listview.setAdapter(adapter);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final String floorm_num = (String) intent.getSerializableExtra("층장학번");
                            final EditText scoretx = (EditText) findViewById(R.id.editText9);
                            final EditText numtx = (EditText) findViewById(R.id.editText10);
                            final EditText reasontx = (EditText) findViewById(R.id.editText11);
                            // 현재 시간을 msec으로 구한다.
                            long now = System.currentTimeMillis();
                            // 현재 시간을 저장 한다.
                            Date datetemp = new Date(now);
                            // 시간 포맷 지정
                            SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyyMMdd");
                            final String strCurDate = CurDateFormat.format(datetemp);
                            final String score = scoretx.getText().toString();
                            final String num = numtx.getText().toString();
                            final String reason = reasontx.getText().toString();

                            final ConnectThread connectThread2 = new ConnectThread(Give_score.this, "add_score.php?student_num=" + num + "&reason=" + reason + "&score=" + score + "&date=" + strCurDate + "&floormaster_num=" + floorm_num);
                            connectThread2.start();

                            Toast.makeText(getApplicationContext(), "상벌점부여 완료", Toast.LENGTH_SHORT).show();
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
