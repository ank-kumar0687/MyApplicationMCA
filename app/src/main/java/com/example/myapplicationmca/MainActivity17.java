package com.example.myapplicationmca;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity17 extends AppCompatActivity {
    Button btnAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main17);
        btnAlert = findViewById(R.id.btnAlert);

        btnAlert.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity17.this);

            builder.setTitle("Confirmation")
                    .setMessage("Do you want to exit?")

                    .setPositiveButton("Yes", (dialog, which) -> {
                        Toast.makeText(MainActivity17.this, "Exiting...", Toast.LENGTH_SHORT).show();
                        finish();
                    })

                    .setNegativeButton("No", (dialog, which) -> {
                        Toast.makeText(MainActivity17.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    })

                    .setNeutralButton("Cancel", (dialog, which) -> {
                        Toast.makeText(MainActivity17.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    });

            builder.show();
        });

    }
}