package com.example.student.android7;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("FirstName")
    public String FirstName;
    @SerializedName("LastName")
    public String LastName;
    @SerializedName("Age")
    public int Age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, age %d", FirstName, LastName, Age);
    }
}
