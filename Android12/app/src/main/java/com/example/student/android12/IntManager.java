package com.example.student.android12;

import android.content.Context;
import android.content.SharedPreferences;

public class IntManager {
    public static int nextInt(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        int count = preferences.getInt("count", 1);
        count++;
        if (count > 999999) {
            count = 1;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("count", count);
        editor.commit();

        return count;
    }
}
