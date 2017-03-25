package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity_FloorMaster extends AppCompatActivity {
    Button qrbtn, outbtn, scorebtn, modibtn, logoutbtn, givescorebtn, applybreakbtn, viewfloorstu_btn,apply_out_viewbtn;
    String db_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__floor_master);
        setTitle("층장 메뉴");

        qrbtn = (Button) findViewById(R.id.qr_btn);//qr코드보기
        outbtn = (Button) findViewById(R.id.out_btn);//외박신청
        scorebtn = (Button) findViewById(R.id.view_student_btn);//상벌점확인
        modibtn = (Button) findViewById(R.id.access_btn);//회원정보수정
        logoutbtn = (Button) findViewById(R.id.resign_btn);//로그아웃
        givescorebtn = (Button) findViewById(R.id.allow_visitor_btn);//상벌점부여
        applybreakbtn = (Button) findViewById(R.id.break_view_btn);//고장접수
        viewfloorstu_btn = (Button) findViewById(R.id.button22);//관리층 학생보기
        apply_out_viewbtn = (Button)findViewById(R.id.button27);//
        final Intent intent = getIntent();
        final FloorMaster floormaster = (FloorMaster) intent.getSerializableExtra("층장");
        TextView present = (TextView)findViewById(R.id.textView55);
        if (floormaster.isEnter()) {
            present.setText("현재상태 : 기숙사외부");
        } else {
            present.setText("현재상태 : 기숙사내부");
        }

        String temp = "";
        if (floormaster.getGender() == 0)
            temp = "B";//남성
        else if (floormaster.getGender() == 1)
            temp = "A";//여성


        db_info = floormaster.getName() + " 학생 (" + temp + "동 " + Integer.toString(floormaster.getAdmin_floor()) + "층장)";
        TextView info_text = (TextView) findViewById(R.id.textView);
        info_text.setText(db_info);

        qrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), ViewQRcode.class);
                intent_01.putExtra("층장", floormaster);
                intent_01.putExtra("activity", "MenuActivity_FloorMaster");
                startActivity(intent_01);
            }
        });

        outbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), apply_out.class);
                intent_01.putExtra("층장", floormaster);
                intent_01.putExtra("activity", "MenuActivity_FloorMaster");
                startActivity(intent_01);
            }
        });

        scorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), ViewScore.class);
                intent_01.putExtra("activity", "MenuActivity_FloorMaster");
                intent_01.putExtra("층장", floormaster);
                startActivity(intent_01);
            }
        });

        modibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Modi_info.class);
                intent_01.putExtra("activity", "MenuActivity_FloorMaster");
                intent_01.putExtra("층장", floormaster.getNum());
                startActivity(intent_01);
            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        givescorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Give_score.class);
                intent_01.putExtra("층장학번", floormaster.getNum());
                startActivity(intent_01);
            }
        });
        applybreakbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), apply_break.class);
                startActivity(intent_01);
            }
        });
        viewfloorstu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), View_floorstu.class);
                intent_01.putExtra("관리층", floormaster.getAdmin_floor());
                intent_01.putExtra("성별", floormaster.getGender());
                startActivity(intent_01);
            }
        });
        apply_out_viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Out_view.class);
                intent_01.putExtra("activity", "MenuActivity_FloorMaster");
                intent_01.putExtra("층장", floormaster.getNum());
                startActivity(intent_01);
            }
        });


    }
}
