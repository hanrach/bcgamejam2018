package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RelationshipQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationship_quiz);
    }

    public void goBack(View view){
        this.finish();
    }
}
