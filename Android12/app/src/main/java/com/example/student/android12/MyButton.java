package com.example.student.android12;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyButton extends RelativeLayout {
    public MyButton(Context context) {
        super(context);
        init(context, null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_button, this);

        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyButton, 0, 0);

            String text = typedArray.getString(R.styleable.MyButton_text);
            if (text != null) {
                textView.setText(text);
            }

            int src = typedArray.getResourceId(R.styleable.MyButton_src, 0);
            if (src != 0) {
                imageView.setImageResource(src);
            }

            typedArray.recycle();
        }
    }
}
