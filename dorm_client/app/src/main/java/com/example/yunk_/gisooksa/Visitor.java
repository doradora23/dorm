package com.example.yunk_.gisooksa;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-23.
 */

public class Visitor implements Serializable {
    private String num = "";
    private String name = "";
    private int gender = -1;
    private String pw = "";
    private String phone = "";
    private int roomnum = -1;
    private String reason = "";
    private String date = "";
    private String out_time = "";
    private boolean isout;


    public Visitor(){

    }
    public Visitor(JSONObject o) {
        try {
            name = o.getString("name");
            num = o.getString("num");
            gender = o.getInt("gender");
            pw = o.getString("pw");
            phone = o.getString("phone");
            roomnum = o.getInt("roomnum");
            reason = o.getString("reason");
            date = o.getString("date");
            out_time = o.getString("out_time");
            isout = o.getInt("isout") == 1;
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOut_time() {
        return out_time;
    }

    public void setOut_time(String out_time) {
        this.out_time = out_time;
    }

    public boolean getisout() {
        return isout;
    }

    public void setIsout(boolean isout) {
        this.isout = isout;
    }

}
