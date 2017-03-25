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

public class Out_View_Adapter  extends BaseAdapter {
    private ArrayList<apply_out_class> applyouts = new ArrayList<>();

    public Out_View_Adapter(ArrayList<apply_out_class> applyout_List) {
        for (apply_out_class s : applyout_List) {
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
            convertView = inflater.inflate(R.layout.out_view_layout, parent, false);
        }

        apply_out_class applyout_ = applyouts.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView date = (TextView) convertView.findViewById(R.id.textView60);
        TextView reason = (TextView) convertView.findViewById(R.id.textView61);
        TextView isaccept= (TextView) convertView.findViewById(R.id.textView62);

        date.setText(applyout_.getDate_out());
        reason.setText(applyout_.getReason());
        String flag = "";
        if(applyout_.is_accept())
            flag = "허가";
        else if(!applyout_.is_accept())
            flag = "미허가";

        isaccept.setText(flag);

        return convertView;
    }

}