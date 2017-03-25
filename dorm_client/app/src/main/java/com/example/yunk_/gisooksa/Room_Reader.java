package com.example.yunk_.gisooksa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.w3c.dom.Text;

public class Room_Reader extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room__reader);

        btn = (Button) findViewById(R.id.button24);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new IntentIntegrator(Room_Reader.this).initiateScan();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // QR코드/바코드를 스캔한 결과 값을 가져옵니다.
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        // 결과값 출력

        EditText roomnum = (EditText) findViewById(R.id.editText26);
        EditText gendertx = (EditText) findViewById(R.id.editText27);
        final String str_roomnum = roomnum.getText().toString();
        final String str_gender = gendertx.getText().toString();
        int gender = -1;
        if (str_gender.equals("m")) {
            gender = 0;
        } else if (str_gender.equals("f")) {
            gender = 1;
        }

        if (result.getContents().equals("admin")) {
            Toast.makeText(getApplicationContext(), "문이 열렸습니다.", Toast.LENGTH_SHORT).show();
            finish();
        }
        String num = (result.getContents()).substring(1);

        final ConnectThread connectThread2 = new ConnectThread(Room_Reader.this, "room_pass.php?roomnum=" + str_roomnum + "&gender=" + gender + "&num=" + num);

        connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
            //  @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    if (arr.getString(0).equals("P")) {
                        Toast.makeText(getApplicationContext(), "문이 열렸습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "출입이 불가능한 호실입니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread2.start();//db받을때*/
    }
}
