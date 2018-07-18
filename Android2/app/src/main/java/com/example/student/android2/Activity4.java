package com.example.student.android2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent intent = getIntent();
        Student1 student1 = (Student1) intent.getSerializableExtra(MainActivity.EXTRA_STUDENT);

        TextView textView = findViewById(R.id.textView3);
        textView.setText(student1.toString());

        //((TextView)findViewById(R.id.textView3)).setText(student1.FirstName + " " + student1.LastName + " " + student1.Age);
    }
}
