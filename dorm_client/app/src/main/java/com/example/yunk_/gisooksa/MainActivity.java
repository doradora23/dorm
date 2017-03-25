package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button2, button6;
    Button room_reader, gate_reader;
    Student student = new Student();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("로그인");


        button2 = (Button) findViewById(R.id.button2);
        button6 = (Button) findViewById(R.id.button6);
        room_reader = (Button) findViewById(R.id.button20);
        gate_reader = (Button) findViewById(R.id.button21);

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent01 = new Intent(getApplicationContext(), Input_visit.class);
                startActivity(intent01);
            }
        });
        final EditText id_input_text = (EditText) findViewById(R.id.editText13);
        final EditText pw_input_text = (EditText) findViewById(R.id.editText25);


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String strid = id_input_text.getText().toString();
                final String strpw = pw_input_text.getText().toString();
                if (strid.equals("admin") && strpw.equals("admin")) {
                    Intent intent_03 = new Intent(getApplicationContext(), MenuActivity_Admin.class);
                    Toast.makeText(getApplicationContext(), "관리자로 접속합니다~~", Toast.LENGTH_SHORT).show();
                    startActivity(intent_03);
                }
                ConnectThread connectThread2 = new ConnectThread(MainActivity.this, "login.php?num=" + strid + "&pw=" + strpw);

                connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {

                    @Override
                    public void onResult(String result) {

                        try {
                            JSONArray arr = new JSONArray(result);
                            if (arr.getString(0).equals("L")) {

                                Boolean flag = false;
                                Student temp_stu = new Student(arr.getJSONObject(1));
                                if (!temp_stu.isfloormaster()) {
                                    Intent intent_01 = new Intent(getApplicationContext(), MenuActivity_Student.class);
                                    intent_01.putExtra("학생", temp_stu);
                                    flag = true;
                                    Toast.makeText(getApplicationContext(), "학생으로 접속합니다~~", Toast.LENGTH_SHORT).show();
                                    startActivityForResult(intent_01, 100);
                                } else if (temp_stu.isfloormaster()) {
                                    FloorMaster temp_floor = new FloorMaster(arr.getJSONObject(1),arr.getJSONObject(2));
                                    Intent intent_01 = new Intent(getApplicationContext(), MenuActivity_FloorMaster.class);
                                    intent_01.putExtra("층장", temp_floor);
                                    Toast.makeText(getApplicationContext(), " " +  Integer.toString(temp_floor.getAdmin_floor()), Toast.LENGTH_SHORT).show();
                                    flag = true;
                                    Toast.makeText(getApplicationContext(), "층장으로 접속합니다~~", Toast.LENGTH_SHORT).show();
                                    startActivityForResult(intent_01, 100);
                                }

                                if (!flag) {
                                    Toast.makeText(getApplicationContext(), "ID PW를 확인하세요.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "서버접속실패", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                });
                connectThread2.start();//db받을때*/

            }
        });

        room_reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent__ = new Intent(getApplicationContext(), Room_Reader.class);
                startActivityForResult(intent__, 100);

            }
        });

        gate_reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent__ = new Intent(getApplicationContext(), Gate_Reader.class);
                startActivityForResult(intent__, 100);

            }
        });


    }

}