package com.example.student.android12;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class AppWidget2ConfigureActivity extends Activity {

    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            int pos = mListView.getCheckedItemPosition();
            if(pos >= 0){
                Student student = mStudents.get(pos);

                Widget widget = new Widget(student.id, mAppWidgetId);
                mHelper.insert(widget);

                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(AppWidget2ConfigureActivity.this);
                AppWidget2.updateAppWidget(AppWidget2ConfigureActivity.this, appWidgetManager, mAppWidgetId);

                Intent resultValue = new Intent();
                resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
                setResult(RESULT_OK, resultValue);
                finish();
            }
        }
    };

    private ListView mListView;
    private DataBaseHelper mHelper;
    private ArrayList<Student> mStudents;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setResult(RESULT_CANCELED);
        setContentView(R.layout.app_widget2_configure);

        mListView = findViewById(R.id.listView);
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        findViewById(R.id.add_button).setOnClickListener(mOnClickListener);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
            return;
        }

        mHelper = new DataBaseHelper(this);

        init();
    }

    private void init() {
        mStudents = mHelper.getStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                android.R.id.text1,
                mStudents);

        mListView.setAdapter(adapter);
    }
}

