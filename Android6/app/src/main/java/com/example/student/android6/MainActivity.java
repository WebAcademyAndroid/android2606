package com.example.student.android6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
    }

    private void initList() {
        DataBaseHelper helper = new DataBaseHelper(this);
        ArrayList<Student> students = helper.getStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students);

        ((ListView)findViewById(R.id.listView)).setAdapter(adapter);
    }

    public void OnClick(View v) {
        DataBaseHelper helper = new DataBaseHelper(this);

        switch (v.getId()) {
            case R.id.button: {
                long id = helper.insert(new Student("Ivan", "Ivanov", 22));
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();

                initList();
            }
            break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
        }
    }
}
