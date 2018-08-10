package com.example.student.android9;


import android.app.ProgressDialog;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Student>> {

    private SaveTask mSaveTask;
    private SaveManyTask mSaveManyTask;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mSaveTask != null) {
            mSaveTask.cancel(true);
        }
        if (mSaveManyTask != null) {
            mSaveManyTask.cancel(true);
        }
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                mSaveTask = new SaveTask();
                mSaveTask.execute(new Student("Ivan", "Ivanov", 33));
                break;
            case R.id.button2:
                mSaveManyTask = new SaveManyTask();
                mSaveManyTask.execute(new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33),
                        new Student("Ivan", "Ivanov", 33));
                break;
            case R.id.button3:
                getSupportLoaderManager().initLoader(0, null, this);
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


    @NonNull
    @Override
    public Loader<ArrayList<Student>> onCreateLoader(int id, @Nullable Bundle args) {
        return new StudentsLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<Student>> loader, ArrayList<Student> data) {
        Log.d("LOADER","finished");
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                data);
        mListView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<Student>> loader) {

    }


    public class SaveTask extends AsyncTask<Student, Void, Long> {

        private ProgressDialog mDialog;

        @Override
        protected void onPreExecute() {
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setMessage("Wait...");
            mDialog.setCancelable(false);
            mDialog.show();
        }

        @Override
        protected Long doInBackground(Student... students) {
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);
            Student student = students[0];

            return helper.insert(student);
        }

        @Override
        protected void onPostExecute(Long id) {
            //Toast.makeText(MainActivity.this, String.valueOf(id), Toast.LENGTH_SHORT).show();
            if (mDialog != null) {
                mDialog.dismiss();
            }

            ((Button) findViewById(R.id.button)).setText(String.valueOf(id));

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }

    public class SaveManyTask extends AsyncTask<Student, Integer, Boolean> {
        private ProgressDialog mDialog;

        @Override
        protected void onPreExecute() {
            mDialog = new ProgressDialog(MainActivity.this);
            mDialog.setMessage("Wait...");
            mDialog.setCancelable(false);
            mDialog.show();
        }

        @Override
        protected Boolean doInBackground(Student... students) {
            DataBaseHelper helper = new DataBaseHelper(MainActivity.this);

            try {
                int count = 0;
                for (Student s : students) {
                    if (!isCancelled()) {
                        TimeUnit.SECONDS.sleep(2);
                        helper.insert(s);

                        count++;
                        publishProgress(students.length, count);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mDialog.setMessage(String.format("Saved %d from %d", values[1], values[0]));
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (mDialog != null) {
                mDialog.dismiss();
            }

            getSupportLoaderManager().restartLoader(0, null, MainActivity.this);
        }
    }
}
