package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
    // STATS
    static int intelligence = 5;
    static int wealth = 5;
    static int relationship= 5;
    static int health = 5;
    ImageView i;
    ImageView w;
    ImageView r;
    ImageView h;

    static void setIntStat(int i){
        intelligence += i;
    }
    static void setHealthStat(int i){
        health += i;
    }
    static void setRelStat(int i){
        relationship += i;
    }
    static void setWealthStat(int i){
        wealth += i;
    }

    public void updateMonth(){
        if (month == 0) {
            ending();
            return;
        }
        monthsLeft.setText("There's "+ month+" months left!!");
        int i = (month*(-1))+12;
        calendar.setText(monthList.get(i));

        android.view.ViewGroup.LayoutParams layoutParams = h.getLayoutParams();
        layoutParams.width = health;
        layoutParams.height = (int) (10 * Resources.getSystem().getDisplayMetrics().density);
        h.setLayoutParams(layoutParams);

        layoutParams = r.getLayoutParams();
        layoutParams.width = relationship;
        layoutParams.height = (int) (10 * Resources.getSystem().getDisplayMetrics().density);
        r.setLayoutParams(layoutParams);

        layoutParams = w.getLayoutParams();
        layoutParams.width = wealth;
        layoutParams.height = (int) (10 * Resources.getSystem().getDisplayMetrics().density);
        w.setLayoutParams(layoutParams);

        layoutParams = this.i.getLayoutParams();
        layoutParams.width = intelligence;
        layoutParams.height = (int) (10 * Resources.getSystem().getDisplayMetrics().density);
        this.i.setLayoutParams(layoutParams);
//<<<<<<< HEAD
//        w.setMaxWidth(wealth);
//        this.i.setMaxWidth(intelligence);
//        r.setMaxWidth(relationship);
//        h.setMaxWidth(health);
//        this.i.setLayoutParams(new ActionBar.LayoutParams(intelligence, 10));
//        this.w.setLayoutParams(new ActionBar.LayoutParams(wealth, 10));
//        this.r.setLayoutParams(new ActionBar.LayoutParams(relationship, 10));
//        this.h.setLayoutParams(new ActionBar.LayoutParams(health, 10));
//=======
//        this.i.setLayoutParams(new ActionBar.LayoutParams(intelligence, 10));
//        this.w.setLayoutParams(new ActionBar.LayoutParams(wealth, 10));
//        this.r.setLayoutParams(new ActionBar.LayoutParams(relationship, 10));
//        this.h.setLayoutParams(new ActionBar.LayoutParams(health, 10));
//>>>>>>> cff0a36689b8d2cba2f23a546e70da6adce5914c
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
        Intent intent = new Intent(getApplicationContext(), TestActivity.class);
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
        Intent intent = new Intent(getApplicationContext(), ExerciseActivity.class);
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
//<<<<<<< HEAD
//        View temp = findViewById(R.id.lin);
        i = findViewById(R.id.intelStat2);
        w = findViewById(R.id.wealthStat2);
        r = findViewById(R.id.relStat2);
        h = findViewById(R.id.healthStat2);
//=======
//        i = findViewById(R.id.intelStat);
//        w = findViewById(R.id.wealthStat);
//        r = findViewById(R.id.relStat);
//        h = findViewById(R.id.healthStat);
//>>>>>>> cff0a36689b8d2cba2f23a546e70da6adce5914c
    }
}
