package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.student.android4.adapters.StudentAdapter;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mListView = findViewById(R.id.listView);

        students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            students.add(new Student("Ivan " + i, "Ivanov " + i, i));
        }

        /*ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students);*/
        final StudentAdapter adapter = new StudentAdapter(this, R.layout.student, students);

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = students.get(position);
                Toast.makeText(Activity3.this, student.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                students.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
