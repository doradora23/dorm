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

public class Applybreak_Adapter extends BaseAdapter {
    private ArrayList<break_class> breaks = new ArrayList<>();

    public Applybreak_Adapter(ArrayList<break_class> applybreak_List) {
        for (break_class s : applybreak_List) {
            breaks.add(s);
        }
    }

    @Override
    public int getCount() {
        return breaks.size();
    }

    @Override
    public Object getItem(int position) {
        return breaks.get(position);
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
            convertView = inflater.inflate(R.layout.applybreak_view_layout, parent, false);
        }

        break_class break_ = breaks.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView room = (TextView) convertView.findViewById(R.id.textView28);
        TextView content = (TextView) convertView.findViewById(R.id.textView31);

        room.setText("" + break_.getRoomnum() + "호");
        content.setText(break_.getContent());

        return convertView;
    }

}
