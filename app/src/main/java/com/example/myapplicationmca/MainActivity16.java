package com.example.myapplicationmca;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity16 extends AppCompatActivity {
    ImageView imageView;
    Button btnCamera;


    ActivityResultLauncher cameraLauncher;


    ActivityResultLauncher permissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main16);
        imageView = findViewById(R.id.imageView);
        btnCamera = findViewById(R.id.btnCamera);


        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicturePreview(),
                bitmap -> {
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    }
                }
        );


        permissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(),
                isGranted -> {
                    if (isGranted) {
                        cameraLauncher.launch(null); // open camera
                    } else {
                        Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
                    }
                }
        );


        btnCamera.setOnClickListener(view -> {
            permissionLauncher.launch(Manifest.permission.CAMERA);
        });

    }
}