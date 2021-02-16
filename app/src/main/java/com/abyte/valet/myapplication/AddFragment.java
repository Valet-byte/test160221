package com.abyte.valet.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.abyte.valet.myapplication.model.Student;

import java.util.ArrayList;


public class AddFragment extends Fragment {

    private ArrayList<Student> students;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        students = (ArrayList<Student>) getArguments().getSerializable(MainActivity.MSG_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        view.findViewById(R.id.btn_add).setOnClickListener(v ->{
            Student student = new Student(
            Integer.valueOf(((EditText) view.findViewById(R.id.et_age)).getText().toString()),
                    ((EditText) view.findViewById(R.id.et_name)).getText().toString(),
                    ((EditText) view.findViewById(R.id.et_group)).getText().toString());

            students.add(student);
            ListFragment fragment = new ListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(MainActivity.MSG_NAME, students);
            fragment.setArguments(bundle);

            ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fl_for_fragment, fragment).commit();
        });

        return view;
    }
}