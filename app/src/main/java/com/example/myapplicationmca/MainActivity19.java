package com.example.myapplicationmca;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity19 extends AppCompatActivity {

    EditText editText;
    Button btnSave, btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);

        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        // Save Data
        btnSave.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("MyData", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString("name", editText.getText().toString());
            editor.apply();

            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
        });

        // Load Data
        btnLoad.setOnClickListener(v -> {
            SharedPreferences sp = getSharedPreferences("MyData", MODE_PRIVATE);

            String name = sp.getString("name", "No Data");
            editText.setText(name);

            Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show();
        });
    }
}