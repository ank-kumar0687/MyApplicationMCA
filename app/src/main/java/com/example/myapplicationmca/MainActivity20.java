package com.example.myapplicationmca;

import android.os.Bundle;
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
    EditText editText;
    Button btnSave, btnRead;
    String fileName = "myfile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        requestPermissions(new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
        }, 1);

        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);
        btnRead = findViewById(R.id.btnRead);

        btnSave.setOnClickListener(v -> {
            try {
                FileOutputStream fos = openFileOutput(fileName, MODE_PRIVATE);
                fos.write(editText.getText().toString().getBytes());
                fos.close();
                Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnRead.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                String data = br.readLine();
                editText.setText(data);
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}