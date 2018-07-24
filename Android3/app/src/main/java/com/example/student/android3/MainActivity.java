package com.example.student.android3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_PARAM = "com.example.student.android3.extra.PARAM";
    public static final String EXTRA_RESULT = "com.example.student.android3.extra.RESULT";
    public static final int REQUEST_CODE_ACTIVITY_2 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action1:
                Toast.makeText(this, "Action 1 click",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action2:
                Toast.makeText(this, "Action 2 click",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action3:
                Toast.makeText(this, "Action 3 click",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    public void OnClick(View v) {
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, Activity2.class);
                intent.putExtra(EXTRA_PARAM, "Some text");

                startActivityForResult(intent, REQUEST_CODE_ACTIVITY_2);
            }
            break;
            case R.id.button2:
                Toast.makeText(this, "Hello toast",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.button3: {
                Toast toast = Toast.makeText(this, "Hello Toast",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);

                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.ic_launcher);

                LinearLayout linearLayout = (LinearLayout) toast.getView();
                linearLayout.addView(imageView, 0);

                toast.show();
            }
            break;
            case R.id.button4: {
                Toast toast = new Toast(this);
                toast.setDuration(Toast.LENGTH_SHORT);

                View view = getLayoutInflater().inflate(R.layout.toast, null);
                TextView textView = view.findViewById(R.id.textView2);
                textView.setText("Custom toast");

                toast.setView(view);
                toast.show();
            }
            break;
            case R.id.button5: {
                Intent intent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(this, 0, intent, 0);

                Notification notification = new NotificationCompat.Builder(this)
                        .setAutoCancel(true)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setDefaults(Notification.DEFAULT_ALL)
                        .setTicker("Ticker")
                        .setContentTitle("Title")
                        .setContentText("Text")
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .build();

                notificationManager.notify(1, notification);
            }
            break;
            case R.id.button6:
                PopupMenu popupMenu = new PopupMenu(this, findViewById(R.id.textView));
                popupMenu.inflate(R.menu.main);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_ACTIVITY_2) {
            if (resultCode == RESULT_OK) {
                String text = data.getStringExtra(EXTRA_RESULT);

                TextView textView = findViewById(R.id.textView);
                textView.setText(text);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action1:
                Toast.makeText(this, "Action 1 click",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action2:
                Toast.makeText(this, "Action 2 click",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action3:
                Toast.makeText(this, "Action 3 click",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
