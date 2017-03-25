package com.example.yunk_.gisooksa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunk_ on 2016-12-01.
 */

public class BreakAdapter extends BaseAdapter {

    private ArrayList<break_class> break_ = new ArrayList<>();

    public BreakAdapter(ArrayList<break_class> breakList) {
        for (break_class s : breakList) {
            break_.add(s);
        }
    }

    @Override
    public int getCount() {
        return break_.size();
    }

    @Override
    public Object getItem(int position) {
        return break_.get(position);
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
            convertView = inflater.inflate(R.layout.break_view_layout, parent, false);
        }

        break_class breakss = break_.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView roomnum = (TextView) convertView.findViewById(R.id.textView49);
        TextView content = (TextView) convertView.findViewById(R.id.textView50);
        TextView num = (TextView) convertView.findViewById(R.id.textView51);
        TextView flag = (TextView) convertView.findViewById(R.id.textView64);

        num.setText("" + breakss.getBreaknum());
        roomnum.setText("" + breakss.getRoomnum() + "호");
        content.setText(breakss.getContent());
        String temp = "";
        if (breakss.is_processed())
            temp = "O";
        else
            temp = "X";
        flag.setText(temp);

        return convertView;
    }

}

