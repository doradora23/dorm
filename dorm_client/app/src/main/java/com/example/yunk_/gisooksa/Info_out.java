package com.example.yunk_.gisooksa;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-26.
 */

public class Info_out  implements Serializable {//외박정보 클래스
    private boolean is_allow;//허가여부
    private String date;//외박날짜
    private String num;//학번
public Info_out(){

}

    public Info_out(JSONObject o) {
        try {
            is_allow = o.getBoolean("is_allow");
            date = o.getString("date");
            num = o.getString("num");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean is_allow() {
        return is_allow;
    }

    public void setIs_allow(boolean is_allow) {
        this.is_allow = is_allow;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
