package com.example.yunk_.gisooksa;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yunk_ on 2016-11-29.
 */

public class ConnectThread extends Thread {
    String urlStr;
    OnResultListener listener;
    Activity activity;



    public ConnectThread(Activity act, String inStr) {
        urlStr =  "http://192.168.0.171/dp/" + inStr;
        activity = act;
    }

    public void run() {
        try {
            final String output = request(urlStr);//결과물 표시
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String request(String urlStr) {
        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL(urlStr);//URL 객체 생성

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();//객체 생성
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                int resCode = conn.getResponseCode();//서버에 접속하여 요청
                if (resCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(//스트림 객체 생성
                            new InputStreamReader(conn.getInputStream()));
                    String line = null;
                    while (true) {
                        line = reader.readLine(); // 반복문 안에서 한 줄씩 읽어 결과 문자열에 추가
                        if (line == null) {
                            break;
                        }
                        output.append(line + "\n");
                    }
                    reader.close();
                    conn.disconnect();
                }
                final String result = output                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   .toString();
                if (listener != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onResult(result);
                        }
                    });
            }
        } catch (Exception ex) {
            Log.e("SampleHTTP", "Exception in procesing response", ex);
        }
        return output.toString();
    }

    public void runAfterRequest(OnResultListener l) {
        listener = l;
    }


    public interface OnResultListener {
        void onResult(String result);
    }


}
