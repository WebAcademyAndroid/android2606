package com.example.student.android13;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ServerValue;

import java.util.HashMap;
import java.util.Map;

public class Activity2 extends AppCompatActivity {

    private RecyclerView mListView;
    private EditText mEditTextMessage;

    private String mKey;

    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter<Message, MessageViewHolder> mFirebaseAdapter;

    private static final String FIREBASE_CHILD_MESSAGES = "messages";
    private static final String FIREBASE_CHILD_MESSAGE = "message";
    private static final String FIREBASE_CHILD_TIME = "time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mKey = getIntent().getStringExtra(MainActivity.EXTRA_KEY);

        mListView = (RecyclerView) findViewById(R.id.recyclerView);
        mEditTextMessage = (EditText) findViewById(R.id.editTextMessage);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        mListView.setLayoutManager(layoutManager);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> map = new HashMap<>();
                map.put(FIREBASE_CHILD_MESSAGE, mEditTextMessage.getText().toString());
                map.put(FIREBASE_CHILD_TIME, ServerValue.TIMESTAMP);

                mDatabaseReference.child(FIREBASE_CHILD_MESSAGES + "/" + mKey).push().setValue(map);

                mEditTextMessage.setText(null);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mFirebaseAdapter == null) {
            initMessages();
        }

        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mFirebaseAdapter != null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void initMessages() {
        Query query = mDatabaseReference.child(FIREBASE_CHILD_MESSAGES + "/" + mKey).orderByChild(FIREBASE_CHILD_TIME);

        FirebaseRecyclerOptions<Message> options = new FirebaseRecyclerOptions.Builder<Message>()
                .setQuery(query, Message.class).build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {

            @NonNull
            @Override
            public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(Activity2.this).inflate(android.R.layout.simple_list_item_2, parent, false);
                return new MessageViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull MessageViewHolder holder, int position, @NonNull Message message) {
                String time = message.getTime() > 0 ? DateUtils.getRelativeTimeSpanString(
                        message.getTime(),
                        System.currentTimeMillis(),
                        DateUtils.MINUTE_IN_MILLIS).toString() : "";

                holder.mTextViewMessage.setText(message.getMessage());
                holder.mTextViewTime.setText(time);
            }
        };

        mListView.setAdapter(mFirebaseAdapter);
    }
}
