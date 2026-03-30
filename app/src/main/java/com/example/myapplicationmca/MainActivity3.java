package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    Spinner sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        sp = findViewById(R.id.spi);


        String[] fruits = {"Apple", "Banana", "Mango", "Orange", "Grapes"};


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.activity_list_item,
                fruits
        );


        sp.setAdapter(adapter);
    }
}