package com.example.yunk_.gisooksa;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-24.
 */

public class apply_out_class implements Serializable {//외박신청클래스
    private int apply_outnum;
    private String reason;//신청사유
    private String date_apply;//신청날짜
    private boolean is_accept;//허가여부
    private String num;//학번
    private String date_out;//실제외박날짜

    public apply_out_class() {

    }

    public apply_out_class(JSONObject o) {
        try {
            apply_outnum = o.getInt("apply_outnum");
            reason = o.getString("reason");
            date_apply = o.getString("date_apply");
            num = o.getString("num");
            date_out = o.getString("date_out");
            if (o.isNull("is_accept") == true)
                is_accept = false;
            is_accept = o.getInt("is_accept") == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate_apply() {
        return date_apply;
    }

    public void setDate_apply(String date_apply) {
        this.date_apply = date_apply;
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


    public String getDate_out() {
        return date_out;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public int getApply_outnum() {
        return apply_outnum;
    }

    public void setApply_outnum(int apply_outnum) {
        this.apply_outnum = apply_outnum;
    }

}
