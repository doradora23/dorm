package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

public class Modi_info extends AppCompatActivity {
    TextView txname, txnum;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modi_info);
        setTitle("회원정보 수정");
        final Intent intent = getIntent();


        if (intent.getStringExtra("activity").equals("MenuActivity_Student")) {
            final String num = (String) intent.getSerializableExtra("학생");
            ConnectThread connectThread = new ConnectThread(this, "view_student.php");
            connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
                @Override
                public void onResult(String result) {
                    try {
                        JSONArray arr = new JSONArray(result);

                        for (int i = 0; i < arr.length(); i++) {
                            Student temp = new Student(arr.getJSONObject(i));
                            if (temp.getNum().equals(num)) {
                                txnum = (TextView) findViewById(R.id.textView17);
                                txname = (TextView) findViewById(R.id.textView18);
                                txnum.setText(temp.getNum());
                                txname.setText(temp.getName());

                                final EditText input_paphone = (EditText) findViewById(R.id.editText20);
                                final EditText input_pw = (EditText) findViewById(R.id.editText19);

                                input_paphone.setText(temp.getParent_phone());


                                btn = (Button) findViewById(R.id.button12);
                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        final EditText input_paphone1 = (EditText) findViewById(R.id.editText20);
                                        final EditText input_pw1 = (EditText) findViewById(R.id.editText19);
                                        String phone, pw;
                                        phone = input_paphone1.getText().toString();
                                        pw = input_pw1.getText().toString();
                                        final String num2 = (String) intent.getSerializableExtra("학생");
                                        final ConnectThread connectThread2 = new ConnectThread(Modi_info.this, "update_student.php?num=" + num2 + "&pw=" + pw + "&parent_phone=" + phone);
                                        connectThread2.start();

                                        Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_SHORT).show();

                                        finish();
                                    }
                                });

                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            connectThread.start();

        } else if (intent.getStringExtra("activity").equals("MenuActivity_FloorMaster")) {
            final String num = (String) intent.getSerializableExtra("층장");

            ConnectThread connectThread = new ConnectThread(this, "view_student.php");
            connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
                @Override
                public void onResult(String result) {
                    try {
                        JSONArray arr = new JSONArray(result);
                        for (int i = 0; i < arr.length(); i++) {
                            Student temp = new FloorMaster(arr.getJSONObject(i));

                            if (temp.getNum().equals(num)) {
                                txnum = (TextView) findViewById(R.id.textView17);
                                txname = (TextView) findViewById(R.id.textView18);
                                txnum.setText(temp.getNum());
                                txname.setText(temp.getName());


                                final EditText input_paphone = (EditText) findViewById(R.id.editText20);
                                final EditText input_pw = (EditText) findViewById(R.id.editText19);
                                input_paphone.setText(temp.getParent_phone());


                                btn = (Button) findViewById(R.id.button12);
                                btn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        final EditText input_paphone1 = (EditText) findViewById(R.id.editText20);
                                        final EditText input_pw1 = (EditText) findViewById(R.id.editText19);
                                        String phone, pw;
                                        phone = input_paphone1.getText().toString();
                                        pw = input_pw1.getText().toString();
                                        String num2 = (String) intent.getSerializableExtra("층장");

                                        final ConnectThread connectThread2 = new ConnectThread(Modi_info.this, "update_student.php?num=" + num2 + "&pw=" + pw + "&parent_phone=" + phone);
                                        connectThread2.start();
                                        Toast.makeText(getApplicationContext(), "수정완료", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                });
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            connectThread.start();


        }
    }
}
