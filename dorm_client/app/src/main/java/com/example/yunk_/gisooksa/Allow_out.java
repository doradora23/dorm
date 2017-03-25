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

public class Allow_out extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allow_out);
        setTitle("외박신청 허용");


//apply_out 리스트 받기
        final ArrayList<apply_out_class> apply_out_list = new ArrayList<>();
        ConnectThread connectThread = new ConnectThread(this, "view_apply.php");
        connectThread.runAfterRequest(new ConnectThread.OnResultListener() {
            @Override
            public void onResult(String result) {
                try {
                    JSONArray arr = new JSONArray(result);
                    for (int i = 0; i < arr.length(); i++) {
                        apply_out_class temp = new apply_out_class(arr.getJSONObject(i));
                        apply_out_list.add(temp);

                    }
                    EditText idtx = (EditText)findViewById(R.id.editText15);
                    final  String id = idtx.getText().toString();
                    final ListView out_listview = (ListView)findViewById(R.id.out_listview);
                    Applyout_Adapter adapter = new Applyout_Adapter(apply_out_list);
                    out_listview.setAdapter(adapter);
                    Button apply_btn = (Button)findViewById(R.id.button3);
                    apply_btn.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v){
                            EditText idtx = (EditText)findViewById(R.id.editText15);
                            final  String id = idtx.getText().toString();
                            Iterator<apply_out_class> it = apply_out_list.iterator();
                            apply_out_class temp;
                            temp = apply_out_list.get(0);
                            while(it.hasNext()){
                                if(Integer.toString(temp.getApply_outnum()).equals(id)){
                                    break;
                                }
                                temp = it.next();
                            }
                            ConnectThread connectThread2 = new ConnectThread(Allow_out.this, "allow_out.php?apply_outnum=" + temp.getApply_outnum()+ "&is_accept=1");
                            connectThread2.start();
                            Toast.makeText(getApplicationContext(), "외박신청허용 완료", Toast.LENGTH_SHORT).show();
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
