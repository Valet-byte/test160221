package com.abyte.valet.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.abyte.valet.myapplication.R;
import com.abyte.valet.myapplication.model.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private LayoutInflater inflater;
    private List<Student> students;

    public StudentAdapter(@NonNull Context context, List<Student> students) {
        super(context, R.layout.item, students);
        inflater = LayoutInflater.from(context);
        this.students = students;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = students.get(position);
        if (convertView == null) convertView = inflater.inflate(R.layout.item, parent);
            ((TextView) convertView.findViewById(R.id.tv_name)).setText(student.getName());
            ((TextView) convertView.findViewById(R.id.tv_group)).setText(student.getGroup());
            ((TextView) convertView.findViewById(R.id.tv_age)).setText(student.getAge());
            ((TextView) convertView.findViewById(R.id.tv_pos)).setText(String.valueOf(position));
            ((TextView) convertView.findViewById(R.id.tv_score)).setText(student.getScore());

        return convertView;
    }
}
