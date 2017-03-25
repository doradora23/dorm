package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuActivity_Admin extends AppCompatActivity {
    Button qrbtn, allowout_btn, viewstu_btn, viewaccess_btn, viewbreak_btn, resign_btn, viewvisitor_btn, logout_btn;
    Button givefm_btn, checkvisitor_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__admin);
        setTitle("관리자 메뉴");
        qrbtn = (Button) findViewById(R.id.qr_btn);
        allowout_btn = (Button) findViewById(R.id.out_btn);
        viewstu_btn = (Button) findViewById(R.id.view_student_btn);
        viewaccess_btn = (Button) findViewById(R.id.access_btn);
        viewbreak_btn = (Button) findViewById(R.id.break_view_btn);
        givefm_btn = (Button) findViewById(R.id.giveflooerm_btn);
        resign_btn = (Button) findViewById(R.id.resign_btn);
        viewvisitor_btn = (Button) findViewById(R.id.view_visitor_btn);
        logout_btn = (Button) findViewById(R.id.logout_btn);
        checkvisitor_btn = (Button)findViewById(R.id.button25);

        qrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), ViewQRcode.class);
                intent_01.putExtra("activity", "main");
                startActivity(intent_01);
            }
        });
        allowout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Allow_out.class);//외박신청허용
                startActivity(intent_01);
            }
        });
        viewstu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), View_student.class);//학생정보보기
                startActivity(intent_01);
            }
        });
        viewaccess_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), View_access.class);//출입정보보기
                startActivity(intent_01);
            }
        });


        viewbreak_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Allow_break.class);//고장접수확인
                startActivity(intent_01);
            }
        });

        resign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Force_resign_student.class);//학생퇴사
                startActivity(intent_01);
            }
        });
        givefm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Give_floormaster.class);//층장권한부여
                startActivity(intent_01);
            }
        });


        resign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Force_resign_student.class);//학생퇴사
                startActivity(intent_01);
            }
        });

        viewvisitor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), View_visitor.class);//방문객정보보기
                startActivity(intent_01);
            }
        });
        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        checkvisitor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_01 = new Intent(getApplicationContext(), Check_visitor.class);//유효하지않은 방문객정보보기
                startActivity(intent_01);
            }
        });

    }

}


