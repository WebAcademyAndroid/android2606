package com.example.student.android2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    public static final String EXTRA_TEST = "com.example.student.android2.extra.TEST";
    public static final String EXTRA_STUDENT = "com.example.student.android2.extra.STUDENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView textView = findViewById(R.id.textView);
        //textView.setText("AAAAAAAAAAAAAA");
        //textView.setText(R.string.app_name);
        //textView.setText("123");

        mTextView = findViewById(R.id.textView);

        /*findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });*/
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
            }
            break;
            case R.id.button2: {
                Intent intent = new Intent(this, Activity3.class);
                intent.putExtra(EXTRA_TEST, "Text text");

                startActivity(intent);
            }
            break;
            case R.id.button3: {
                Intent intent = new Intent(this, Activity4.class);
                intent.putExtra(EXTRA_STUDENT, new Student1("Ivan", "Ivanov", 22));

                startActivity(intent);
            }
            break;
            case R.id.button4: {
                Intent intent = new Intent(this, Activity5.class);
                intent.putExtra(EXTRA_STUDENT, new Student2("Ivan", "Ivanov", 22));

                startActivity(intent);
            }
            break;
            case R.id.button5: {
                startActivity(new Intent(this, Activity6.class));
            }
            break;
        }
    }
}
