package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class value_passing_2 extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_passing2);

        t1 = findViewById(R.id.text_1);
        t2 = findViewById(R.id.text_2);
        t3 = findViewById(R.id.text_3);
        t4 = findViewById(R.id.text_4);
        t5 = findViewById(R.id.text_5);

        t1.setText(getIntent().getStringExtra("fname"));
        t2.setText(getIntent().getStringExtra("lname"));
        t3.setText(getIntent().getStringExtra("mobile"));
        t4.setText(getIntent().getStringExtra("email"));
        t5.setText(getIntent().getStringExtra("password"));

    }
}