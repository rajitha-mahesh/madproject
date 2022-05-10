package com.example.madprojectuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VedioList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_list);

            VideoView videoView = findViewById(R.id.videoView);
            videoView.setVideoPath("android.resource://"+getPackageName()+"/"+ R.raw.pendiulum_motion);
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
        }

    public void selectVideo(View view) {
        Intent i = new Intent(getApplicationContext(), VideoPlayer.class);
        startActivity(i);
    }
}
