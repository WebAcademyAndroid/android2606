package com.example.student.android5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Random;

public class Activity4 extends AppCompatActivity {

    private ExpandableListView mListView;
    private ArrayList<Group> mGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mListView = findViewById(R.id.listView);
        mGroups = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            Student[] items = new Student[random.nextInt(10)];

            for (int j = 0; j < items.length; j++) {
                items[j] = new Student("Ivan " + j, "Ivanov" + j, j);
            }

            mGroups.add(new Group("Group " + i, items));
        }

        ExpandableAdapter adapter = new ExpandableAdapter(this, R.layout.group, R.layout.student, mGroups);
        mListView.setAdapter(adapter);

        mListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
        mListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if(mListView.isGroupExpanded(groupPosition)){
                    mListView.collapseGroup(groupPosition);
                }else {
                    mListView.expandGroup(groupPosition);
                }
                return true;
            }
        });
    }
}
