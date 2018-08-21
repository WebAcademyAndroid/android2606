package com.example.student.android12;

import android.appwidget.AppWidgetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    private Student mStudent;
    private DataBaseHelper mHelper;

    private StudentView mStudentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mStudentView = findViewById(R.id.studentView);

        mHelper = new DataBaseHelper(this);
        long id = getIntent().getExtras().getLong("id");

        mStudent = mHelper.getStudent(id);
        mStudentView.setStudent(mStudent);

        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(mStudentView.validate()){
                   mStudent = mStudentView.getStudent();

                   mHelper.save(mStudent);

                   ArrayList<Widget> widgets = mHelper.getWidgets(mStudent.id);
                   AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(Activity2.this);

                   for(Widget w: widgets){
                       AppWidget2.updateAppWidget(Activity2.this, appWidgetManager, w.idWidget);
                   }

                   finish();
               }
            }
        });
    }
}
