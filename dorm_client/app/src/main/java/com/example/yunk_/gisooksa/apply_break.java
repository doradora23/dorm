package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;

public class apply_break extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_break);
        setTitle("고장 접수");


        Button apply_btn = (Button) findViewById(R.id.button);
        apply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText roomtx = (EditText) findViewById(R.id.editText14);
                EditText contenttx = (EditText) findViewById(R.id.editText17);
                final String content = contenttx.getText().toString();
                final String room = roomtx.getText().toString();
                final ConnectThread connectThread2 = new ConnectThread(apply_break.this, "apply_break.php?roomnum=" + room + "&content=" + content + "&is_processed=true");
                connectThread2.start();
                Toast.makeText(getApplicationContext(), "고장접수 완료", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
