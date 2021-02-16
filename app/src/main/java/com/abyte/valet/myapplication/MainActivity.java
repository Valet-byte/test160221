package com.abyte.valet.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.abyte.valet.myapplication.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String MSG_NAME = "Msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Student> students = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putSerializable(MSG_NAME, students);

        ListFragment fragment = new ListFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_for_fragment, fragment).commit();

        findViewById(R.id.btn_add).setOnClickListener(view ->{
            AddFragment addFragment = new AddFragment();
            Bundle bund = new Bundle();
            bund.putSerializable(MSG_NAME, students);
            addFragment.setArguments(bund);
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_for_fragment, addFragment).commit();
        });
    }
}