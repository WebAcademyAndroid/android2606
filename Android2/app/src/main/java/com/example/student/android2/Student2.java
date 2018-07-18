package com.example.student.android2;

import android.os.Parcel;
import android.os.Parcelable;

public class Student2 implements Parcelable {
    public String FirstName;
    public String LastName;
    public int Age;

    public Student2() {
    }

    public Student2(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, age: %d", FirstName, LastName, Age);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.FirstName);
        dest.writeString(this.LastName);
        dest.writeInt(this.Age);
    }

    protected Student2(Parcel in) {
        this.FirstName = in.readString();
        this.LastName = in.readString();
        this.Age = in.readInt();
    }

    public static final Creator<Student2> CREATOR = new Creator<Student2>() {
        @Override
        public Student2 createFromParcel(Parcel source) {
            return new Student2(source);
        }

        @Override
        public Student2[] newArray(int size) {
            return new Student2[size];
        }
    };
}
