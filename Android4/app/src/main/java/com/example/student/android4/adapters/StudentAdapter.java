package com.example.student.android4.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.android4.R;
import com.example.student.android4.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    private int mResource;
    private ArrayList<Student> mStudents;
    private LayoutInflater mInflater;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Student> objects) {
        super(context, resource, objects);

        mResource = resource;
        mStudents = objects;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = mInflater.inflate(mResource, null);

        Student student = mStudents.get(position);

        ((TextView) convertView.findViewById(R.id.textViewFirstName)).setText(student.FirstName);
        ((TextView) convertView.findViewById(R.id.textViewLastName)).setText(student.LastName);
        ((TextView) convertView.findViewById(R.id.textViewAge)).setText(String.valueOf(student.Age));

        return convertView;
    }
}
