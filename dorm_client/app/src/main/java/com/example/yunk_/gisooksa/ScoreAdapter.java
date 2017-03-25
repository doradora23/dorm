package com.example.yunk_.gisooksa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunk_ on 2016-11-30.
 */

public class ScoreAdapter extends BaseAdapter {

    private ArrayList<Score> scores = new ArrayList<>();

    public ScoreAdapter(ArrayList<Score> scoreList) {
        for (Score s : scoreList) {
            scores.add(s);
        }
    }

    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int position) {
        return scores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_score_layout, parent, false);
        }

        Score score = scores.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView num = (TextView) convertView.findViewById(R.id.text_id);
        TextView reason = (TextView) convertView.findViewById(R.id.textView36);
        TextView score_ = (TextView) convertView.findViewById(R.id.textView35);
        TextView givenid = (TextView) convertView.findViewById(R.id.text_givenid);

        num.setText(score.getStudent_num());
        reason.setText(score.getReason());
        score_.setText("" + score.getScore() + "점");
        givenid.setText(score.getFloormaster_num());

        return convertView;
    }

}
