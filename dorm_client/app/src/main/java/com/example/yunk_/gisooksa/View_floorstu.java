package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;

import java.util.ArrayList;

public class View_floorstu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_floorstu);
        setTitle("관리층 학생보기");
        Intent intent = getIntent();
        int admin_num = (int) intent.getSerializableExtra("관리층");//관리층
        int gender = (int)intent.getSerializableExtra("성별");
        TextView textView = (TextView)findViewById(R.id.textView52);
        textView.setText("" + Integer.toString(admin_num) + "층 학생리스트");

        final ArrayList<Student> student_list = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_floorstudent.php?floor=" + admin_num + "&gender=" + gender);
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Student temp = new Student(arr.getJSONObject(i));
                        student_list.add(temp);
                    }

                    final ListView listView = (ListView) findViewById(R.id.listview);
                    StudentAdapter adapter = new StudentAdapter(student_list);
                    listView.setAdapter(adapter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();
    }

}
