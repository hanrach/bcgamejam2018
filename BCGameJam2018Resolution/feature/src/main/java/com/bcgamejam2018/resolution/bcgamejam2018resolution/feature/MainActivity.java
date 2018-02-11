package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public static int level = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startImageBtn = findViewById(R.id.gameStartButton);

        if(mediaPlayer != null) {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bgmusic);
            mediaPlayer.start(); // no need to call prepare(); create() does that for you
        }

        startImageBtn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Intro.class);
                startActivity(intent);
            }
        });
    }
}
