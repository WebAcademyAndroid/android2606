package com.example.student.android3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_PARAM);

        mEditText = findViewById(R.id.editText);
        mEditText.setText(text);

        findViewById(R.id.button11).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra(MainActivity.EXTRA_RESULT, mEditText.getText().toString());

                setResult(RESULT_OK, result);
                finish();
            }
        });
    }
}
