package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        mListView = findViewById(R.id.listView);
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        final String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                android.R.id.text1,
                items);

        mListView.setAdapter(adapter);

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mListView.setItemChecked(-1, true);

                //int position = mListView.getCheckedItemPosition();
                //Toast.makeText(Activity4.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                //String res = "";
                StringBuilder sb = new StringBuilder();
                SparseBooleanArray positions = mListView.getCheckedItemPositions();
                for(int i=0;i<positions.size();i++){
                    if(positions.get(i)){
                       sb.append(items[i]);
                    }
                }
                Toast.makeText(Activity4.this, sb.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
