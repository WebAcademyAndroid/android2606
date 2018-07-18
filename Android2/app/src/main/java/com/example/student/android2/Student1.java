package com.example.student.android2;

import java.io.Serializable;

public class Student1 implements Serializable {
    public String FirstName;
    public String LastName;
    public int Age;

    public Student1() {
    }

    public Student1(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, age: %d", FirstName, LastName, Age);
    }
}
