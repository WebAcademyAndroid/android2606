package com.example.student.android5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.StudentHolder> {

    private LayoutInflater mInflater;
    private int mResource;
    private ArrayList<Student> mStudents;

    public RecyclerAdapter(Context context, int resource, ArrayList<Student> students) {
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        mStudents = students;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentHolder(mInflater.inflate(mResource, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        final Student student = mStudents.get(position);
        holder.setStudent(student);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener != null){
                    mListener.onClick(student);
                }
            }
        });
    }

    public interface ClickListener{
        void onClick(Student student);
    }

    private ClickListener mListener;

    public void setClickListener(ClickListener listener){
        mListener = listener;
    }


    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewFirstName, mTextViewLastName, mTextViewAge;

        public StudentHolder(View itemView) {
            super(itemView);

            mTextViewFirstName = itemView.findViewById(R.id.textViewFirstName);
            mTextViewLastName = itemView.findViewById(R.id.textViewLastName);
            mTextViewAge = itemView.findViewById(R.id.textViewAge);
        }

        public void setStudent(Student student) {
            mTextViewFirstName.setText(student.FirstName);
            mTextViewLastName.setText(student.LastName);
            mTextViewAge.setText(String.valueOf(student.Age));
        }
    }
}
