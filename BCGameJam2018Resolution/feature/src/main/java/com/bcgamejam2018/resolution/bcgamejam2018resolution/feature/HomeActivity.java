package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    TextView monthsLeft;
    ImageButton intelButton;
    ImageButton wealthButton;
    ImageButton healthButton;
    ImageButton relButton;
    TextView calendar;
    int month = 12;
    List<String> monthList = new ArrayList<>(Arrays.asList("Jan", "Feb","Mar","Apr","May","June","July","Aug","Sept","Oct","Nov","Dec"));

    public void updateMonth(){
        if (month == 0) {
            ending();
            return;
        }
        monthsLeft.setText("There's "+ month+" months left!!");
        int i = (month*(-1))+12;
        calendar.setText(monthList.get(i));
    }

    /////////////EDIT ENDING!!!!////////
    public void ending(){
        Toast.makeText(getApplicationContext(), "Game OVer",
                Toast.LENGTH_LONG).show();
    }

    // Calls this when miniGame ends
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_CANCELED){
                updateMonth();
        }

    }

    public void intelGame(View view){
        month--;
        // REPLACE WITH CORRESPONDING CLASS LATER/////////////
        Intent intent = new Intent(getApplicationContext(), mathquiz.class);
        startActivityForResult(intent, 100);
        //////////////////////////////////////////////////////
    }

    public void wealthGame(View view){
        month--;
        // REPLACE WITH CORRESPONDING CLASS LATER/////////////
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        startActivityForResult(intent, 100);
        //////////////////////////////////////////////////////
    }

    public void relationshipGame(View view){
        month--;
        // REPLACE WITH CORRESPONDING CLASS LATER/////////////
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        startActivityForResult(intent, 100);
        //////////////////////////////////////////////////////
    }

    public void healthGame(View view){
        month--;
        // REPLACE WITH CORRESPONDING CLASS LATER/////////////
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
        startActivityForResult(intent, 100);
        //////////////////////////////////////////////////////
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        monthsLeft = findViewById(R.id.sentence);
        intelButton = findViewById(R.id.intelButton);
        wealthButton = findViewById(R.id.wealthButton);
        healthButton = findViewById(R.id.healthButton);
        relButton = findViewById(R.id.relButton);
        calendar = findViewById(R.id.month);
    }
}
