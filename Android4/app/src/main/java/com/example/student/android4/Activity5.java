package com.example.student.android4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity5 extends AppCompatActivity {

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        mSpinner = findViewById(R.id.spinner);

        String[] items = new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.student,
                R.id.textViewFirstName,
                items);

        //adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);

        mSpinner.setAdapter(adapter);
    }
}
