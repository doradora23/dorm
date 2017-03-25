package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

public class View_student extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        setTitle("학생 정보 보기");


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

                    final  ListView listView = (ListView)findViewById(R.id.listview2);
                    StudentAdapter adapter = new StudentAdapter(students);
                    listView.setAdapter(adapter);

                    Button btn = (Button)findViewById(R.id.button15);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
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
