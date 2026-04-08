package com.example.myapplicationmca;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity20 extends AppCompatActivity {
    EditText editText1,editText2;
    Button btnSave, btnRead;
    String fileName = "myfile.txt";
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        requestPermissions(new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
        }, 1);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        btnSave.setOnClickListener(v -> {
            try {
                String name = editText1.getText().toString();
                String email = editText2.getText().toString();

                SQLiteDatabase dbWrite = db.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("email", email);

                long result = dbWrite.insert("users", null, values);

                if (result == -1) {
                    Toast.makeText(MainActivity20.this, "Data Insert Failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity20.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String data = br.readLine();
                editText1.setText(data);
                editText2.setText(data);
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}