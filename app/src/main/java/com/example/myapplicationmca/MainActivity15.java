package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity15 extends AppCompatActivity {
    EditText editText;
    Button btnSave, btnLoad;
    TextView textView;

    DBhelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main15);
        editText  = findViewById(R.id.editTextName);
        btnSave   = findViewById(R.id.btnSave);
        btnLoad   = findViewById(R.id.btnLoad);
        textView  = findViewById(R.id.textViewResult);

        dbHelper = new DBhelper(this);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();
                dbHelper.insertData(name);
                textView.setText("Saved to DB!");
            }
        });


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = dbHelper.getData();
                textView.setText(data);
            }
        });
    }
}