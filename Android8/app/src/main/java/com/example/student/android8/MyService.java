package com.example.student.android8;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        PendingIntent pendingIntent = intent.getParcelableExtra(MainActivity.EXTRA_PENDING_INTENT);
        if (pendingIntent != null) {
            Intent result = new Intent();
            result.putExtra(MainActivity.EXTRA_RESULT, "Some result");

            try {
                pendingIntent.send(this, Activity.RESULT_OK, result);
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    public void testBind() {
        Toast.makeText(this, "Service bind", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    public class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}
