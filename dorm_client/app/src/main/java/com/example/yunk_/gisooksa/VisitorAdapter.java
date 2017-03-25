package com.example.yunk_.gisooksa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by yunk_ on 2016-12-01.
 */

public class VisitorAdapter extends BaseAdapter {
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public VisitorAdapter(ArrayList<Visitor> visitorList) {
        for (Visitor s : visitorList) {
            visitors.add(s);
        }
    }

    @Override
    public int getCount() {
        return visitors.size();
    }

    @Override
    public Object getItem(int position) {
        return visitors.get(position);
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
            convertView = inflater.inflate(R.layout.visitor_view_layout, parent, false);
        }

        Visitor visitor = visitors.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView name = (TextView) convertView.findViewById(R.id.textView39);
        TextView gender = (TextView) convertView.findViewById(R.id.textView42);
        TextView phone = (TextView) convertView.findViewById(R.id.textView41);
        TextView room = (TextView) convertView.findViewById(R.id.textView40);
        TextView reason = (TextView) convertView.findViewById(R.id.textView37);

        name.setText(visitor.getName());
        if (visitor.getGender() == 0)
            gender.setText("남성");
        else if (visitor.getGender() == 1)
            gender.setText("여성");
        phone.setText(visitor.getPhone());
        room.setText("" + visitor.getRoomnum() + "호");
        reason.setText(visitor.getReason());


        return convertView;
    }


}
