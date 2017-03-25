package com.example.yunk_.gisooksa;

import org.json.JSONObject;

/**
 * Created by yunk_ on 2016-12-08.
 */

public class out_class {
    private boolean is_accept;
    private String num;
    private String out_date;
    public out_class() {

    }

    public out_class(JSONObject o) {
        try {
            num = o.getString("num");
            out_date = o.getString("date_out");
            if (o.isNull("is_accept") == true)
                is_accept = false;
            is_accept = o.getInt("is_accept") == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public boolean is_accept() {
        return is_accept;
    }

    public void setIs_accept(boolean is_accept) {
        this.is_accept = is_accept;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOut_date() {
        return out_date;
    }

    public void setOut_date(String out_date) {
        this.out_date = out_date;
    }
}
