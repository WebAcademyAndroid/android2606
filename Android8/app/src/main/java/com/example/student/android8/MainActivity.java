package com.example.student.android8;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.student.android8.extra.TEXT";
    public static final String EXTRA_RESULT = "com.example.student.android8.extra.RESULT";
    public static final String EXTRA_PENDING_INTENT = "com.example.student.android8.extra.PENDING_INTENT";
    public static final int REQUEST_CODE_ACTION_1 = 1;

    private MyService mService;
    private ListView mListView;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);
        //getStudents();
    }

    private void getStudents() {
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Wait...");
        mDialog.setCancelable(false);
        mDialog.show();

        MyIntentService.getStudents(this);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra(EXTRA_TEXT, "Some text");
                startService(intent);
            }
            break;
            case R.id.button2: {
                Intent intent = new Intent(this, MyService.class);
                PendingIntent pendingIntent = createPendingResult(REQUEST_CODE_ACTION_1, intent, 0);
                intent.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
                intent.putExtra(EXTRA_TEXT, "Some text");
                startService(intent);
            }
            break;
            case R.id.button3: {
                ServiceConnection connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        mService = ((MyService.MyBinder) service).getService();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        mService = null;
                    }
                };

                Intent intent = new Intent(this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);

                if (mService != null) {
                    mService.testBind();
                }
            }
            break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                mDialog = new ProgressDialog(this);
                mDialog.setMessage("Wait...");
                mDialog.setCancelable(false);
                mDialog.show();

                MyIntentService.saveStudent(this, new Student("Ivan", "Ivanov", 33));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
        }

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_ACTION_1) {
                String text = data.getStringExtra(EXTRA_RESULT);
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            } else if (requestCode == MyIntentService.REQUEST_CODE_GET_STUDENTS) {
                ArrayList<Student> students = data.getParcelableArrayListExtra(MyIntentService.EXTRA_STUDENTS);
                setAdapter(students);
            } else if (requestCode == MyIntentService.REQUEST_CODE_SAVE_STUDENT) {
                long id = data.getLongExtra(MyIntentService.EXTRA_ID, 0);
                Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();
                //getStudents();
            }
        }
    }

    private void setAdapter(ArrayList<Student> students) {
        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students);
        mListView.setAdapter(adapter);
    }
}
