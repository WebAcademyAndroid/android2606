package com.example.student.android5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Activity3 extends AppCompatActivity {

    private ExpandableListView mListView;

    private static final String KEY_GROUP = "Group";
    private static final String KEY_NAME = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        mListView = findViewById(R.id.listView);

        ArrayList<HashMap<String, String>> groups = new ArrayList<>();
        ArrayList<ArrayList<HashMap<String, String>>> groupChildren = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            HashMap<String, String> group = new HashMap<>();
            group.put(KEY_GROUP, "Group " + i);
            groups.add(group);

            ArrayList<HashMap<String, String>> children = new ArrayList<>();
            int count = random.nextInt(10);
            for (int j = 0; j < count; j++) {
                HashMap<String, String> child = new HashMap<>();
                child.put(KEY_NAME, "Ivan " + i + " " + j);
                children.add(child);
            }
            groupChildren.add(children);
        }

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groups,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{KEY_GROUP},
                new int[]{android.R.id.text1},
                groupChildren,
                android.R.layout.simple_list_item_1,
                new String[]{KEY_NAME},
                new int[]{android.R.id.text1});
        mListView.setAdapter(adapter);
    }
}
