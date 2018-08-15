package com.example.student.android10;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;

public class StudentsLoader extends AsyncTaskLoader<ArrayList<Student>> {
    private DataBaseHelper mHelper;

    public StudentsLoader(Context context) {
        super(context);

        mHelper = new DataBaseHelper(context);
    }

    @Override
    public ArrayList<Student> loadInBackground() {
        Log.d("LOADER","load");
        return mHelper.getStudents();
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
