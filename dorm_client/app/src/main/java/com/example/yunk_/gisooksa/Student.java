package com.example.yunk_.gisooksa;

import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by yunk_ on 2016-11-23.
 */


public class Student implements Serializable {
    protected String name;
    protected String num;
    protected int gender;
    protected String pw;
    protected boolean enter;
    protected String parent_phone;
    protected int roomnum;
    protected boolean isfloormaster;

    public Student() {

    }

    public Student(JSONObject o) {
        try {
            name = o.getString("name");
            num = o.getString("num");
            gender = o.getInt("gender");
            pw = o.getString("pw");
            isfloormaster = o.getInt("isfloormaster") == 1;
            enter = o.getInt("enter") == 1;
            parent_phone = o.getString("parent_phone");
            roomnum = o.getInt("roomnum");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public boolean isEnter() {
        return enter;
    }

    public void setEnter(boolean enter) {
        this.enter = enter;
    }

    public String getParent_phone() {
        return parent_phone;
    }

    public void setParent_phone(String parent_phone) {
        this.parent_phone = parent_phone;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }


    public boolean isfloormaster() {
        return isfloormaster;
    }

    public void setIsfloormaster(boolean isfloormaster) {
        this.isfloormaster = isfloormaster;
    }
}

class FloorMaster extends Student implements Serializable {//층장클래스

    private int admin_floor;

    public FloorMaster() {

    }

    public FloorMaster(JSONObject o) {
        try {
            name = o.getString("name");
            num = o.getString("num");
            gender = o.getInt("gender");
            pw = o.getString("pw");
            isfloormaster = o.getInt("isfloormaster") == 1;
            enter = o.getInt("enter") == 1;
            parent_phone = o.getString("parent_phone");
            roomnum = o.getInt("roomnum");
            admin_floor = o.getInt("admin_floor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FloorMaster(JSONObject o, JSONObject o2) {
        try {
            name = o.getString("name");
            num = o.getString("num");
            gender = o.getInt("gender");
            pw = o.getString("pw");
            isfloormaster = o.getInt("isfloormaster") == 1;
            enter = o.getInt("enter") == 1;
            parent_phone = o.getString("parent_phone");
            roomnum = o.getInt("roomnum");
            admin_floor = o2.getInt("admin_floor");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    public ArrayList<Score> getGiven_score() {
        return given_score;
    }

    public void setGiven_score(ArrayList<Score> given_score) {
        this.given_score = given_score;
    }*/

    public int getAdmin_floor() {
        return admin_floor;
    }

    public void setAdmin_floor(int admin_floor) {
        this.admin_floor = admin_floor;
    }

    public boolean getisfoormaster() {
        return true;
    }


}


