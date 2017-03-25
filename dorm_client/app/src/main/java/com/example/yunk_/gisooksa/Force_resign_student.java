package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

public class Force_resign_student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_resign_student);
        setTitle("학생 퇴사");

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
                    final EditText id = (EditText) findViewById(R.id.editText21);
                    final ListView listView = (ListView) findViewById(R.id.stu_listview);

                    StudentAdapter adapter = new StudentAdapter(students);
                    listView.setAdapter(adapter);
                    Button btn = (Button) findViewById(R.id.button10);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {//학생퇴사

                            ConnectThread connectThread2 = new ConnectThread(Force_resign_student.this, "delete_student.php?num=" + id.getText().toString());
                            connectThread2.start();

                            Toast.makeText(getApplicationContext(), "퇴사완료", Toast.LENGTH_SHORT).show();
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
