package com.example.yunk_.gisooksa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunk_ on 2016-12-08.
 */

public class Out_Adapter  extends BaseAdapter {
    private ArrayList<out_class> applyouts = new ArrayList<>();

    public Out_Adapter(ArrayList<out_class> out_list) {
        for (out_class s : out_list) {
            applyouts.add(s);
        }
    }

    @Override
    public int getCount() {
        return applyouts.size();
    }

    @Override
    public Object getItem(int position) {
        return applyouts.get(position);
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
            convertView = inflater.inflate(R.layout.out_layout, parent, false);
        }

        out_class applyout_ = applyouts.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView num = (TextView) convertView.findViewById(R.id.textView67);
        TextView outdate = (TextView) convertView.findViewById(R.id.textView68);
        TextView isaccept= (TextView) convertView.findViewById(R.id.textView69);

        num.setText("" + applyout_.getNum());
        outdate.setText(applyout_.getOut_date());
        String flag = "";
        if(applyout_.is_accept())
            flag = "허가";
        else if(!applyout_.is_accept())
            flag = "미허가";

        isaccept.setText(flag);

        return convertView;
    }

}