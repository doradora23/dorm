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

public class Access_Adapter  extends BaseAdapter {
    private ArrayList<Access_class> access = new ArrayList<>();

    public Access_Adapter(ArrayList<Access_class> accessList) {
        for (Access_class s : accessList) {
            access.add(s);
        }
    }

    @Override
    public int getCount() {
        return access.size();
    }

    @Override
    public Object getItem(int position) {
        return access.get(position);
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
            convertView = inflater.inflate(R.layout.access_view_layout, parent, false);
        }

        Access_class access_ = access.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView access_num = (TextView) convertView.findViewById(R.id.textView44);
        TextView date = (TextView) convertView.findViewById(R.id.textView43);
        TextView num = (TextView) convertView.findViewById(R.id.textView38);
        TextView enter = (TextView) convertView.findViewById(R.id.textView54);

        access_num.setText( "" + access_.getAccess_num());
        date.setText(access_.getDatetime());
        if (access_.isEnter() == false)
            enter.setText("입");
        else if (access_.isEnter() == true)
            enter.setText("출");
        num.setText(access_.getNum());

        return convertView;
    }


}
