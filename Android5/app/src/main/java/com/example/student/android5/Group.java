package com.example.student.android5;

public class Group {
    public String GroupName;
    public Student[] Students;

    public Group() {
    }

    public Group(String groupName, Student[] students) {
        GroupName = groupName;
        Students = students;
    }
}
