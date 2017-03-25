package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Input_visit extends AppCompatActivity {
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_visit);
        setTitle("방문정보 입력");

        login = (Button) findViewById(R.id.button7);


        final RadioButton radio_male = (RadioButton) findViewById(R.id.radio_male);
        final RadioButton radio_female = (RadioButton) findViewById(R.id.radio_female);


        // 현재 시간을 msec으로 구한다.
        long now = System.currentTimeMillis();
        // 현재 시간을 저장 한다.
        Date date = new Date(now);
        // 시간 포맷 지정
        SimpleDateFormat CurDateFormat = new SimpleDateFormat("yyyyMMdd");
        final String strCurDate = CurDateFormat.format(date);


        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity_visitor.class);

                final EditText name_input_text = (EditText) findViewById(R.id.editText);
                final EditText pw_input_text = (EditText) findViewById(R.id.editText2);
                final EditText phone_input_text = (EditText) findViewById(R.id.editText3);
                final EditText room_input_text = (EditText) findViewById(R.id.editText6);
                final EditText reason_input_text = (EditText) findViewById(R.id.editText7);
                final EditText outtime_input_text = (EditText) findViewById(R.id.editText8);

                final String name = name_input_text.getText().toString();
                final String pw = pw_input_text.getText().toString();
                final String phone = phone_input_text.getText().toString();
                final String strroom = room_input_text.getText().toString();
                final String reason = reason_input_text.getText().toString();
                final String outtime = outtime_input_text.getText().toString();
                intent.putExtra("이름",name);

                int gender = -1;
                if (radio_male.isChecked()) {
                    gender = 0;
                } else if (radio_female.isChecked()) {
                    gender = 1;
                }
                Visitor visitor = new Visitor();
                visitor.setName(name);
                visitor.setGender(gender);
                visitor.setPw(pw);
                visitor.setPhone(phone);
                visitor.setRoomnum(Integer.parseInt(strroom));
                visitor.setReason(reason);
                visitor.setDate(strCurDate);
                visitor.setOut_time(outtime);
                intent.putExtra("방문자",visitor);
                final ConnectThread connectThread2 = new ConnectThread(Input_visit.this, "add_visitor.php?name=" + name + "&gender=" + Integer.toString(gender) + "&pw=" + pw
                        + "&phone=" + phone + "&roomnum=" + strroom + "&reason=" + reason + "&date=" + strCurDate + "&out_time=" + outtime);
                connectThread2.start();

                startActivity(intent);
                finish();
            }
        });
    }
}
