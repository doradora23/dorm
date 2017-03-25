package com.example.yunk_.gisooksa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;


public class ViewQRcode extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_qrcode);
        setTitle("QR 코드 보기");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        String text = "";
        Intent intent = new Intent();
        intent = getIntent();
        Student student;
        FloorMaster floormaster = new FloorMaster();
        btn = (Button)findViewById(R.id.button13) ;
        String visitor_id = "";
        if (intent.getStringExtra("activity").equals("MenuActivity_Student")) {
            student = (Student) intent.getSerializableExtra("학생");
            text = "s"  +student.getNum();
        } else if (intent.getStringExtra("activity").equals("MenuActivity_FloorMaster")) {
            floormaster = (FloorMaster)intent.getSerializableExtra("층장");
            text = "s" + floormaster.getNum();
        } else if (intent.getStringExtra("activity").equals("MenuActivity_visitor")) {
            visitor_id = (String) intent.getSerializableExtra("방문자");
            text ="v"+ visitor_id;
        } else {
            text = "admin";
        }
        try {
            text = new String(text.getBytes("UTF-8"), "ISO-8859-1");

            MultiFormatWriter gen = new MultiFormatWriter();
            BitMatrix bytemap = gen.encode(text, BarcodeFormat.QR_CODE, 300, 300);

            Bitmap bitmap = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
            for (int i = 0; i < 300; ++i)
                for (int j = 0; j < 300; ++j) {
                    bitmap.setPixel(i, j, bytemap.get(i, j) ? Color.BLACK : Color.WHITE);
                }
            imageView.setImageBitmap(bitmap);
            imageView.invalidate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }
}
