package com.example.yunk_.gisooksa;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-24.
 */

public class Score implements Serializable{
    private int score;//점수
    private String date;//부여 날짜
    private String reason;//사유
    private String student_num;//학생 학번
    private String floormaster_num;//층장 학번

    public Score(){

    }

    public Score(JSONObject o) {
        try {
            score = o.getInt("score");
            date = o.getString("date");
            reason = o.getString("reason");
            student_num = o.getString("student_num");
            floormaster_num = o.getString("floormaster_num");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStudent_num() {
        return student_num;
    }

    public void setStudent_num(String student_num) {
        this.student_num = student_num;
    }

    public String getFloormaster_num() {
        return floormaster_num;
    }

    public void setFloormaster_num(String floormaster_num) {
        this.floormaster_num = floormaster_num;
    }
}

