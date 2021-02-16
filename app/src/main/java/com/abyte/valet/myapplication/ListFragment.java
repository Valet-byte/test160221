package com.abyte.valet.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abyte.valet.myapplication.adapter.StudentAdapter;
import com.abyte.valet.myapplication.model.SetScoreFragment;
import com.abyte.valet.myapplication.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private ListView listView;
    private ArrayList<Student> students;
    private StudentAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        students = (ArrayList<Student>) getArguments().getSerializable(MainActivity.MSG_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);


        listView = view.findViewById(R.id.lv_students);
        adapter = new StudentAdapter(getContext(), students);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SetScoreFragment fragment = new SetScoreFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(MainActivity.MSG_NAME, students);
                bundle.putInt("pos", position);
                fragment.setArguments(bundle);
                ((AppCompatActivity) getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.fl_for_fragment, fragment).commit();
            }
        });

        return view;
    }
}