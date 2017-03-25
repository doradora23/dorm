package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;

public class MenuActivity_Student extends AppCompatActivity {
    Button qrbtn, outbtn, scorebtn, modibtn, logoutbtn, apply_out_viewbtn;
    String db_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__student);
        setTitle("학생 메뉴");

        qrbtn = (Button) findViewById(R.id.qr_btn);
        outbtn = (Button) findViewById(R.id.out_btn);
        scorebtn = (Button) findViewById(R.id.view_student_btn);
        modibtn = (Button) findViewById(R.id.access_btn);
        logoutbtn = (Button) findViewById(R.id.resign_btn);
        apply_out_viewbtn = (Button)findViewById(R.id.button26);

        TextView present = (TextView) findViewById(R.id.textView58);

        final Intent intent = getIntent();
        final Student student = (Student) intent.getSerializableExtra("학생");
        if (student.isEnter()) {
            present.setText("현재상태 : 기숙사외부");
        } else {
            present.setText("현재상태 : 기숙사내부");
        }

        String temp_gender = "";
        if (student.getGender() == 0)
            temp_gender = "B";//남성
        else if (student.getGender() == 1)
            temp_gender = "A";//여성
        else
            temp_gender = " ";

        db_info = student.getName() + " 학생 (" + temp_gender + "동 " + Integer.toString(student.getRoomnum()) + "호)";

        TextView info_text = (TextView) findViewById(R.id.textView);
        info_text.setText(db_info);

        qrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), ViewQRcode.class);
                intent_01.putExtra("학생", student);
                intent_01.putExtra("activity", "MenuActivity_Student");
                startActivity(intent_01);
            }
        });

        outbtn.setOnClickListener(new View.OnClickListener() {////////////////
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), apply_out.class);
                intent_01.putExtra("학생", student);
                intent_01.putExtra("activity", "MenuActivity_Student");
                startActivityForResult(intent_01, 100);

                startActivity(intent_01);
            }
        });

        scorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), ViewScore.class);
                intent_01.putExtra("activity", "MenuActivity_Student");
                intent_01.putExtra("학생", student);
                startActivity(intent_01);

            }
        });

        modibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Modi_info.class);
                intent_01.putExtra("activity", "MenuActivity_Student");
                intent_01.putExtra("학생", student.getNum());
                startActivity(intent_01);
            }
        });
        apply_out_viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Out_view.class);
                intent_01.putExtra("activity", "MenuActivity_Student");
                intent_01.putExtra("학생", student.getNum());
                startActivity(intent_01);
            }
        });
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
