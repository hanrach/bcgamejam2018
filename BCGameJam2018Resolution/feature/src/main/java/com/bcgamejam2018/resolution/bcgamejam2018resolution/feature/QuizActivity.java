package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    int score = 0;
    TextView scoreTextView;
    List<Quiz> quizzes;
    int currentQuizIndex = 0;
    int currentCorrectIndex;

    TextView titleTextView;
    Button choice1Button;
    Button choice2Button;
    Button choice3Button;
    Button choice4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreTextView = findViewById(R.id.scoreTextView);
        titleTextView = findViewById(R.id.questionTextView);
        choice1Button = findViewById(R.id.choice1Button);
        choice1Button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chooseAnswer(0);
            }
        });
        choice2Button = findViewById(R.id.choice2Button);
        choice2Button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chooseAnswer(1);
            }
        });
        choice3Button = findViewById(R.id.choice3Button);
        choice3Button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chooseAnswer(2);
            }
        });
        choice4Button = findViewById(R.id.choice4Button);
        choice4Button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                chooseAnswer(3);
            }
        });

        // 1. Get type of the quiz
        // 2. Get topic of the quiz
        // 3. Get level of the quiz
        Intent intent = getIntent();
        String quizType = intent.getStringExtra("quiztype"); quizType  = quizType == null ? "relationship" : quizType;
        String quizTopic = intent.getStringExtra("quiztopic");quizTopic  = quizTopic == null ? "discovery" : quizTopic;
        Integer quizLevel = intent.getIntExtra("quizlevel", 0);

        // 4. Load json and parse it into quiz features/src/main/assets/quiz.json
        String quizJSONString = Util.loadJSONFromAsset(this.getApplicationContext(), "quiz.json");
        JSONObject quizObj = Util.parseJSONString(quizJSONString);

        try {

            JSONObject quizTypeObj = quizObj.getJSONObject(quizType);
            JSONArray quizzes = null;
            switch(quizType) {
                case "relationship":
                    JSONObject quizTopicObj = quizTypeObj.getJSONObject(quizTopic);
                    quizzes = quizTopicObj.getJSONArray("quizzes");
                    break;
                default:
                    break;
            }

            this.quizzes = new GsonBuilder().create().fromJson(quizzes.toString(), new TypeToken<ArrayList<Quiz>>(){}.getType());
            generateQuiz(this.quizzes, 0);
            // 4. Based on these values, create a quiz and calculate the score.


        } catch(Exception e) {
            Log.e("QuizActivity", e.getMessage());
        }
    }

    private void generateQuiz(List<Quiz> quizzes, int quizIndex) {
        if(quizIndex >= quizzes.size()) {
            // No more quizes, go back to the main
            Util.showToast(getApplicationContext(), "Done!! you got " + this.score);
        } else {
            Quiz quiz = quizzes.get(quizIndex);
            titleTextView.setText(quiz.information);
            currentCorrectIndex = quiz.correctIndex;
            choice1Button.setText(quiz.options[0]);
            choice2Button.setText(quiz.options[1]);
            choice3Button.setText(quiz.options[2]);
            choice4Button.setText(quiz.options[3]);
        }
    }

    private void chooseAnswer(int chosenIndex) {
        if(chosenIndex == currentCorrectIndex) {
            setScore(this.score + 1);
        }
        generateQuiz(this.quizzes, ++this.currentQuizIndex);
    }

    private void setScore(int score) {
        this.score = score;
        scoreTextView.setText("Score: " + score);
    }
}
