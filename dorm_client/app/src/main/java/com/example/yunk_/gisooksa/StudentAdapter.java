package com.example.yunk_.gisooksa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yunk_ on 2016-11-29.
 */

public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> students = new ArrayList<>();

    public StudentAdapter(ArrayList<Student> studentList) {
        for (Student s : studentList) {
            students.add(s);
        }
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
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
            convertView = inflater.inflate(R.layout.student_view_layout, parent, false);
        }
        Student student = students.get(position);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView name = (TextView) convertView.findViewById(R.id.name_textview);
        TextView studentNo = (TextView) convertView.findViewById(R.id.id_tx);
        TextView room = (TextView) convertView.findViewById(R.id.room_textview);
        TextView parent_phone = (TextView) convertView.findViewById(R.id.parent_phone_tx);

        name.setText(student.getName());
        studentNo.setText(student.getNum());
        room.setText("" + student.getRoomnum() + "호");
        parent_phone.setText(student.getParent_phone());

        return convertView;
    }

}
