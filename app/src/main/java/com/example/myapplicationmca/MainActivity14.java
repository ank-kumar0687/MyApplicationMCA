package com.example.myapplicationmca;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity14 extends AppCompatActivity {
    EditText editText;
    Button btnSave, btnLoad;
    TextView textView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main14);
        editText = findViewById(R.id.editTextName);
        btnSave  = findViewById(R.id.btnSave);
        btnLoad  = findViewById(R.id.btnLoad);
        textView = findViewById(R.id.textViewResult);


        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", name);
                editor.apply();

                textView.setText("Saved!");
            }
        });


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String savedName = sharedPreferences.getString("username", "No Data");
                textView.setText(savedName);
            }
        });

    }
}