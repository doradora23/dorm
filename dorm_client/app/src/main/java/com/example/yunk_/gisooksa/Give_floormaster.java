package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;

public class Give_floormaster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_floormaster);
        setTitle("층장권한부여");


        final ArrayList<Student> students = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_student.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {


                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Student temp = new Student(arr.getJSONObject(i));
                        students.add(temp);
                    }
                   final EditText numtx = (EditText) findViewById(R.id.editText22);
                    final EditText admin_floortx = (EditText) findViewById(R.id.editText16);



                    final ListView listview = (ListView) findViewById(R.id.listview);
                    StudentAdapter adapter = new StudentAdapter(students);
                    listview.setAdapter(adapter);
                    Button btn = (Button) findViewById(R.id.button9);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            final ConnectThread connectThread2 = new ConnectThread(Give_floormaster.this, "view_student.php");

                            connectThread2.runAfterRequest(new ConnectThread.OnResultListener() {
                                @Override
                                public void onResult(String result) {
                                    try {
                                        JSONArray arr2 = new JSONArray(result);
                                        for (int i = 0; i < arr2.length(); i++) {
                                            Student temp = new Student(arr2.getJSONObject(i));
                                            students.add(temp);
                                        }
                                        final String num = numtx.getText().toString();
                                        final String admin_floor = admin_floortx.getText().toString();
                                        Iterator<Student> it = students.iterator();
                                        Student temp;
                                        temp = students.get(0);
                                        while (it.hasNext()) {
                                            if (temp.getNum().equals(num)) {
                                                break;
                                            }
                                            temp = it.next();
                                        }
                                        if(temp.isfloormaster() == true){
                                            Toast.makeText(getApplicationContext(), "이미 등록된 층장입니다.", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }
                                        final ConnectThread connectThread2 = new ConnectThread(Give_floormaster.this, "register_floormaster.php?num=" + num + "&gender=" + temp.getGender() + "&admin_floor=" + admin_floor);
                                        connectThread2.start();

                                        Toast.makeText(getApplicationContext(), "권한부여완료", Toast.LENGTH_SHORT).show();
                                        finish();

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            connectThread2.start();//db받을때*/
                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();


    }
}
