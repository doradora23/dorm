package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

public class MenuActivity_visitor extends AppCompatActivity {
    Button qrbtn, logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_visitor);
        setTitle("방문자 메뉴");
        Intent intent = getIntent();

        final Visitor visitor = (Visitor) intent.getSerializableExtra("방문자");
        final Intent intent_01 = new Intent(getApplicationContext(), ViewQRcode.class);

        final TextView textView = (TextView) findViewById(R.id.textView2);
        final TextView present = (TextView) findViewById(R.id.textView59);
        textView.setText("" + visitor.getName() + " 방문자");
        if (visitor.getisout())
            present.setText("현재상태 : 기숙사내부");
        else
            present.setText("현재상태 : 기숙사외부");

        qrbtn = (Button) findViewById(R.id.button5);
        qrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_01.putExtra("activity", "MenuActivity_visitor");
                intent_01.putExtra("방문자",visitor.getName());
                startActivity(intent_01);
            }
        });
        logoutbtn = (Button) findViewById(R.id.button4);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
