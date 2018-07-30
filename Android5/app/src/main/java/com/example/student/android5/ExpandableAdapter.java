package com.example.student.android5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandableAdapter extends BaseExpandableListAdapter {

    private LayoutInflater mInflater;
    private int mGroupResource, mChildResource;
    private ArrayList<Group> mGroups;

    public ExpandableAdapter(Context context, int groupResource, int childResource, ArrayList<Group> groups) {
        mInflater = LayoutInflater.from(context);
        mGroupResource = groupResource;
        mChildResource = childResource;
        mGroups = groups;
    }

    @Override
    public int getGroupCount() {
        return mGroups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroups.get(groupPosition).Students.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroups.get(groupPosition).Students[childPosition];
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mGroupResource, null);

        Group group = (Group) getGroup(groupPosition);
        ((TextView) convertView.findViewById(R.id.textViewGroup)).setText(group.GroupName);

        View indicator = convertView.findViewById(R.id.indicator);
        if(isExpanded){
            indicator.setBackgroundColor(Color.GREEN);
        }else{
            indicator.setBackgroundColor(Color.RED);
        }

        if(group.Students.length == 0){
            indicator.setVisibility(View.GONE);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mChildResource, null);

        Student student = (Student) getChild(groupPosition, childPosition);
        ((TextView) convertView.findViewById(R.id.textViewFirstName)).setText(student.FirstName);
        ((TextView) convertView.findViewById(R.id.textViewLastName)).setText(student.LastName);
        ((TextView) convertView.findViewById(R.id.textViewAge)).setText(String.valueOf(student.Age));

        return convertView;
    }


    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
