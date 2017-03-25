package com.example.yunk_.gisooksa;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-29.
 */

public class Access_class  implements Serializable {
    private int access_num;
    private String num;
    private boolean enter;
    private String datetime;

    public Access_class(){

    }
    public Access_class(JSONObject o) {
        try {
            access_num = o.getInt("num");
            num = o.getString("student_num");
            enter = o.getInt("enter") == 1;
            datetime = o.getString("datetime");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getAccess_num() {
        return access_num;
    }

    public void setAccess_num(int access_num) {
        this.access_num = access_num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
