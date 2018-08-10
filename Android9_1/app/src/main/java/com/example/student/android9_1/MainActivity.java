package com.example.student.android9_1;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private ListView mListView;
    private SaveTask mSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        getSupportLoaderManager().initLoader(0, null, this);

        findViewById(R.id.buttonNew).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSaveTask = new SaveTask();
                mSaveTask.execute(new Student("Petro", "Petrov", 44));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
    }

    @NonNull
    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int id, @Nullable Bundle args) {
        return new StudentsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Student>> loader, ArrayList<Student> data) {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }

    public class SaveTask extends AsyncTask<Student, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Student... students) {
            Uri uri = Uri.parse("content://com.example.student.android9/students");
            ContentValues values = new ContentValues();

            Student student = students[0];
            values.put(Student.COLUMN_FIRST_NAME, student.FirstName);
            values.put(Student.COLUMN_LAST_NAME, student.LastName);
            values.put(Student.COLUMN_AGE, student.Age);

            try {
                Uri result = getContentResolver().insert(uri, values);
                return result != null;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
