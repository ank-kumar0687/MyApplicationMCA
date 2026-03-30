package com.example.myapplicationmca;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity7 extends AppCompatActivity {
    TextView tvResult,tvResult1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        tvResult = findViewById(R.id.tvResult);
        tvResult1 = findViewById(R.id.tvResult1);


        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");




    }
}