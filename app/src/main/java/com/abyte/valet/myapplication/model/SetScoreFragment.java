package com.abyte.valet.myapplication.model;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.abyte.valet.myapplication.ListFragment;
import com.abyte.valet.myapplication.MainActivity;
import com.abyte.valet.myapplication.R;

import java.util.ArrayList;


public class SetScoreFragment extends Fragment {
    private ArrayList<Student> students;
    private int position;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        students = (ArrayList<Student>) getArguments().getSerializable(MainActivity.MSG_NAME);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_set_score, container, false);

       view.findViewById(R.id.btn_set).setOnClickListener(v ->{
           students.get(position).setScore(Integer.valueOf(((EditText) view.findViewById(R.id.et_score)).getText().toString()));
           ListFragment fragment = new ListFragment();
           Bundle bundle = new Bundle();
           bundle.putSerializable(MainActivity.MSG_NAME, students);
           fragment.setArguments(bundle);
           ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fl_for_fragment, fragment).commit();
       });
        return view;
    }
}