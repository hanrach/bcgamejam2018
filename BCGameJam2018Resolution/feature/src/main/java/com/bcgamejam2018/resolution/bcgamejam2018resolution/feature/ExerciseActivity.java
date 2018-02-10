package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.HashMap;

import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
public class ExerciseActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView stepstext;
    TextView goalstepstext;
    int goalsteps = MainActivity.level + 9;
    float steps = 0;
    TextView level;
    boolean activityRunning = false;
    Button home;
//    Button pause;
    //  need to get level from the main,
    //



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        stepstext = (TextView) findViewById(R.id.stepstext);
        goalstepstext = (TextView) findViewById(R.id.goalstepstext);
        level = (TextView) findViewById(R.id.level);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        goalstepstext.setText(String.valueOf(goalsteps)+"steps");
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        steps = 0;
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (activityRunning) {
            steps = sensorEvent.values[0];
            stepstext.setText(String.valueOf(sensorEvent.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    public void endGame(SensorEvent sensorEvent) {
        // if steps == goal step, display "Congratulations!" and add go back to home button
        float stepsnum = sensorEvent.values[0];
        if (stepsnum == goalsteps) {
            Toast.makeText(this, "Goal accomplished!", Toast.LENGTH_SHORT).show();
        }
    }

    ///// all minigames should call this function upon finish //////
    public void finish(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }
}