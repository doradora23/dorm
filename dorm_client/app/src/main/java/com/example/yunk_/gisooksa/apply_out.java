package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.Date;

public class apply_out extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_out);
        setTitle("외박 신청");
        final Student student;
        final FloorMaster floorMaster;
        Intent intent = getIntent();

        if (intent.getStringExtra("activity").equals("MenuActivity_Student")) {
            student = (Student) intent.getSerializableExtra("학생");

            btn = (Button) findViewById(R.id.button8);

            btn.setOnClickListener(new View.OnClickListener() {//외박신청버튼

                //외박신청버튼누르면 정보보내기
                public void onClick(View v) {

                    // 현재 시간을 msec으로 구한다.
                    long now = System.currentTimeMillis();
                    // 현재 시간을 저장 한다.
                    Date datetemp = new Date(now);
                    // 시간 포맷 지정
                    SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyyMMdd");
                    final String strCurDate = CurDateFormat.format(datetemp);
                    EditText input_date = (EditText) findViewById(R.id.editText4);
                    EditText input_reason = (EditText) findViewById(R.id.editText5);

                    String date = input_date.getText().toString();
                    String reason = input_reason.getText().toString();
                    ConnectThread connectThread2 = new ConnectThread(apply_out.this, "apply_out.php?num=" + student.getNum() + "&date_apply=" + strCurDate + "&reason=" + reason + "&date_out=" + date);
                    connectThread2.start();
                    Toast.makeText(getApplicationContext(), "신청완료", Toast.LENGTH_SHORT).show();


                    finish();
                }
            });

        } else if (intent.getStringExtra("activity").equals("MenuActivity_FloorMaster")) {
            floorMaster = (FloorMaster) intent.getSerializableExtra("층장");

            btn = (Button) findViewById(R.id.button8);

            btn.setOnClickListener(new View.OnClickListener() {//외박신청버튼
                @Override
                public void onClick(View v) {
                    EditText input_date = (EditText) findViewById(R.id.editText4);
                    EditText input_reason = (EditText) findViewById(R.id.editText5);
                    btn = (Button) findViewById(R.id.button8);

                    final String reason = input_reason.getText().toString();
                    final String date = input_date.getText().toString();
                    final apply_out_class temp = new apply_out_class();
                    temp.setNum(floorMaster.getNum());
                    temp.setReason(reason);
                    // 현재 시간을 msec으로 구한다.
                    long now = System.currentTimeMillis();
                    // 현재 시간을 저장 한다.
                    Date datetemp = new Date(now);
                    // 시간 포맷 지정
                    SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyyMMdd");
                    final String strCurDate = CurDateFormat.format(datetemp);
                    temp.setDate_apply(strCurDate);
                    temp.setIs_accept(false);
                    final ConnectThread connectThread2 = new ConnectThread(apply_out.this, "apply_out.php?num=" + floorMaster.getNum() + "&date_apply=" + strCurDate + "&reason=" + reason.toString() + "&is_accept=" + 0 + "&date_out=" + date);
                    connectThread2.start();
                    Toast.makeText(getApplicationContext(), "신청완료", Toast.LENGTH_SHORT).show();

                    finish();
                }
            });
        }


    }
}


