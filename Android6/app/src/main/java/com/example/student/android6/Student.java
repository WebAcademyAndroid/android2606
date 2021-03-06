package com.example.student.android6;

import java.util.ArrayList;

public class Student {
    public static final String TABLE_NAME = "Students";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_AGE = "Age";

    public long id;
    public String FirstName;
    public String LastName;
    public long Age;

    public Student() {
    }

    public Student(String firstName, String lastName, long age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %d", id, FirstName, LastName, Age);
    }
}
