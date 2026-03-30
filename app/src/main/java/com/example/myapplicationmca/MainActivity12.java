package com.example.myapplicationmca;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity12 extends AppCompatActivity {
    VideoView videoView;
    Button buttonPlayUrl, buttonPlayLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main12);

        videoView = findViewById(R.id.videoView);
        buttonPlayUrl = findViewById(R.id.buttonPlayUrl);
        buttonPlayLocal = findViewById(R.id.buttonPlayLocal);

        buttonPlayUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri videoUri = Uri.parse("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        });

        buttonPlayLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fun);
                videoView.setVideoURI(localUri);
                videoView.start();
            }
        });

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}