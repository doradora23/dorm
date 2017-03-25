package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;

public class Gate_Reader extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate__reader);
        btn = (Button) findViewById(R.id.button23);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new IntentIntegrator(Gate_Reader.this).initiateScan();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // QR코드/바코드를 스캔한 결과 값을 가져옵니다.
        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        // 결과값 출력
        final EditText gendertx = (EditText) findViewById(R.id.editText24);
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

        String flag = (result.getContents()).substring(0, 1);
        String num = (result.getContents()).substring(1);
        if (flag.equals("s")) {
            final ConnectThread connectThread2 = new ConnectThread(Gate_Reader.this, "gate_pass.php?gender=" + gender + "&num=" + num);

            connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
                //  @Override
                public void onResult(String result) {
                    try {

                        JSONArray arr = new JSONArray(result);//p pass  f//성별이틀린것
                        if (arr.getString(0).equals("P")) {
                            Toast.makeText(getApplicationContext(), "문이 열렸습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else if (arr.getString(0).equals("F")) {
                            Toast.makeText(getApplicationContext(), "출입이 불가능합니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            connectThread2.start();//db받을때*/
        } else if (flag.equals("v")) {

            final ConnectThread connectThread2 = new ConnectThread(Gate_Reader.this, "gate_passvisitor.php?gender=" + gender + "&num=" + num);

            connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
                //  @Override
                public void onResult(String result) {
                    try {
                        JSONArray arr = new JSONArray(result);//p pass f//성별이틀린것 t//성별이맞는데 시간이지난것(방문자한테만)
                        if (arr.getString(0).equals("P")) {
                            Toast.makeText(getApplicationContext(), "문이 열렸습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else if (arr.getString(0).equals("F")) {
                            Toast.makeText(getApplicationContext(), "출입이 불가능합니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else if (arr.getString(0).equals("T")) {
                            Toast.makeText(getApplicationContext(), "가능한 방문시간이 지났습니다.", Toast.LENGTH_SHORT).show();
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
}
