package com.example.student.android2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        Intent intent = getIntent();
        Student2 student2 = intent.getParcelableExtra(MainActivity.EXTRA_STUDENT);

        TextView textView = findViewById(R.id.textView4);
        textView.setText(student2.toString());
    }
}
