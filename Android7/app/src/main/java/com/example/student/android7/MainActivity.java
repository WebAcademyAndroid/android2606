package com.example.student.android7;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button: {
                SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("Text", "Hello preference");
                editor.apply();//.commit();
            }
            break;
            case R.id.button2: {
                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("Text", "Hello preference");
                editor.commit();
            }
            break;
            case R.id.button3: {
                SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                String text = preferences.getString("Text", "");

                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.button4:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.button5: {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                String text = preferences.getString("edit_text_preference_1", "");

                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.button6:
                saveInternalFile("MyFile.txt", "Some data");
                break;
            case R.id.button7:
                Toast.makeText(this, readInternalFile("MyFile.txt"), Toast.LENGTH_SHORT).show();
                break;
            case R.id.button8:
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        File folder =
                                new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder");

                        saveExternalFile(folder, "MyFile.txt", "Some data");
                    }
                } else {
                    requestPermissions();
                }
                break;
            case R.id.button9:
                if (hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    File folder =
                            new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder");

                    String text = readExternalFile(folder, "MyFile.txt");
                    if (text != null) {
                        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    requestPermissions();
                }
                break;
            case R.id.button10:
                Student student = new Student("Ivan", "Ivanov", 33);
                Gson gson = new GsonBuilder().setDateFormat("dd.MM.yyyy HH:mm:ss").create();
                String json = gson.toJson(student);

                saveInternalFile("Student.json", json);
                break;
        }
    }

    private void saveInternalFile(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, MODE_PRIVATE)));

            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readInternalFile(String fileName) {
        try {
            StringBuilder builder = new StringBuilder();
            String line = "";

            BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

            requestPermissions(permissions, 0);
        }
    }

    private boolean hasPermission(String permission) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
        }

        return true;
    }

    private void saveExternalFile(File folder, String fileName, String data) {
        try {
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File file = new File(folder, fileName);

            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));

            writer.write(data);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readExternalFile(File folder, String fileName) {
        try {
            File file = new File(folder, fileName);

            if (file.exists()) {
                StringBuilder builder = new StringBuilder();
                String line = "";

                BufferedReader reader = new BufferedReader(new FileReader(file));
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                reader.close();
                return builder.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
