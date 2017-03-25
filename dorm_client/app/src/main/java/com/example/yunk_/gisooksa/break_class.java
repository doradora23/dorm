package com.example.yunk_.gisooksa;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by yunk_ on 2016-11-24.
 */

public class break_class  implements Serializable {//고장접수클래스
    private int breaknum;
    private int roomnum;//고장 호실
    private String content;//고장 상세내용
    private boolean is_processed;//고장접수 처리여부

    public break_class() {

    }

    public break_class(JSONObject o) {
        try {
            breaknum = o.getInt("breaknum");
            roomnum = o.getInt("roomnum");
            content = o.getString("content");
            is_processed = o.getInt("is_processed") == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean is_processed() {
        return is_processed;
    }

    public void setIs_processed(boolean is_processed) {
        this.is_processed = is_processed;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public int getBreaknum() {
        return breaknum;
    }

    public void setBreaknum(int breaknum) {
        this.breaknum = breaknum;
    }
}
