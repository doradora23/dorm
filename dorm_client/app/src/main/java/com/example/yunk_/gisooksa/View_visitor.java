



package com.example.yunk_.gisooksa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;

import java.util.ArrayList;

public class View_visitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_visitor);
        setTitle("방문객 보기");

        final ArrayList<Visitor> visitors = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_visitor.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        Visitor temp = new Visitor(arr.getJSONObject(i));
                        visitors.add(temp);
                    }
                    final ListView listView = (ListView)findViewById(R.id.listview11);
                    VisitorAdapter adapter = new VisitorAdapter(visitors);
                    listView.setAdapter(adapter);

                    Button btn = (Button)findViewById(R.id.button19);
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
