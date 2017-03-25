package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Check_visitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_visitor);
        setTitle("유효하지 않은 방문자 보기");

        final ArrayList<Visitor> visitors = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "visitor_check.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Visitor temp = new Visitor(arr.getJSONObject(i));
                        visitors.add(temp);
                    }
                    final ListView listView = (ListView)findViewById(R.id.listview);
                    VisitorAdapter adapter = new VisitorAdapter(visitors);
                    listView.setAdapter(adapter);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        connectThread.start();
    }
}
