package com.example.student.android6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Student.TABLE_NAME + " ("
                + Student.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Student.COLUMN_FIRST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_LAST_NAME + " TEXT NOT NULL,"
                + Student.COLUMN_AGE + " INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("ALTER TABLE Students RENAME TO Students_OLD");

        db.execSQL("CREATE TABLE Students ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "FirstName TEXT NOT NULL,"
                + "LastName TEXT NOT NULL,"
                + "INN TEXT NOT NULL,"
                + "Age INTEGER NOT NULL);");

        db.execSQL("INSERT INTO Students (_id, FirstName, LastName, Age, INN)"
                + "SELECT _id, FirstName, LastName, Age, '000000' FROM Students_OLD");

        db.execSQL("DROP TABLE Students_OLD");
    }

    public long insert(Student student) {
        long id = 0;
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(Student.COLUMN_FIRST_NAME, student.FirstName);
            values.put(Student.COLUMN_LAST_NAME, student.LastName);
            values.put(Student.COLUMN_AGE, student.Age);

            id = db.insert(Student.TABLE_NAME, null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query(Student.TABLE_NAME, null, null, null,
                    null, null, null);
            if (cursor.moveToFirst()) {
                while (!cursor.isAfterLast()) {
                    Student student = new Student();
                    student.id = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_ID));
                    student.FirstName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_FIRST_NAME));
                    student.LastName = cursor.getString(cursor.getColumnIndex(Student.COLUMN_LAST_NAME));
                    student.Age = cursor.getLong(cursor.getColumnIndex(Student.COLUMN_AGE));

                    students.add(student);
                    cursor.moveToNext();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return students;
    }
}
