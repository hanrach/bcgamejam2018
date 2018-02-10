package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton startImageBtn = findViewById(R.id.gameStartButton);

        startImageBtn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v){
//                Toast.makeText(getApplicationContext(), "Game Start Button Pressed!",
//                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
//                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }
}
