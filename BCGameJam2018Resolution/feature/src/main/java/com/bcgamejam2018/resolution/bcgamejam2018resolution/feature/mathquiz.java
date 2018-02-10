package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.graphics.Color;
import android.content.Intent;

public class mathquiz extends AppCompatActivity {

    private int mathquestionlevel = 1;
    private int score = 0;
    private int attempts = 0;
    private int answer;
    private int response1;
    private int response2;
    private int response3;
    private int response4;
    private int response5;
    private int response6;

    public int getMathQuestionLevel(){
        return mathquestionlevel;
    }

    public void setMathQuestionLevel(int level){
        this.mathquestionlevel = level;
    }

    public String generateMathQuestion(){
        String mathQuestion = "Something went wrong...";
        Random rand = new Random();
        int correctResponse = rand.nextInt(5) + 1;
        switch (this.mathquestionlevel){
            case 1 :
                //Note! It's possible for the answer to appear twice through randomness
                //Either answer will be evaluated as correct
                int first = rand.nextInt(11) + 1;
                int second = rand.nextInt(11) + 1;
                this.response1 = rand.nextInt(143) + 1;
                this.response2 = rand.nextInt(143) + 1;
                this.response3 = rand.nextInt(143) + 1;
                this.response4 = rand.nextInt(143) + 1;
                this.response5 = rand.nextInt(143) + 1;
                this.response6 = rand.nextInt(143) + 1;
                answer = first * second;
                switch (correctResponse){
                    case 1 : this.response1 = answer;
                        break;
                    case 2 : this.response2 = answer;
                        break;
                    case 3 : this.response3 = answer;
                        break;
                    case 4 : this.response4 = answer;
                        break;
                    case 5 : this.response5 = answer;
                        break;
                    case 6 : this.response6 = answer;
                        break;
                }
                mathQuestion = Integer.toString(first) + " x " + Integer.toString(second) + " = ?";
                return mathQuestion;
            case 2 :

                return mathQuestion;
            case 3 :
                return mathQuestion;
            case 4 :
                return mathQuestion;
            default:
                return mathQuestion;
        }
    }

    public void chooseAnswer(View v){
        this.attempts++;
        TextView mathQuestionTextView = findViewById(R.id.mathquestion);
        TextView confirmationTextView = findViewById(R.id.confirmation);
        Button b = (Button)v;
        int response = Integer.parseInt(b.getText().toString());
        if (response == answer){
            confirmationTextView.setText("You are correct!");
            confirmationTextView.setTextColor(Color.GREEN);
            this.score++;
            TextView scoreView = findViewById(R.id.scorecounter);
            scoreView.setText("Score: " + Integer.toString(this.score));
        }else{
            confirmationTextView.setText("You are incorrect!");
            confirmationTextView.setTextColor(Color.RED);
        }

        if (this.attempts > 5){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }else{
            mathQuestionTextView.setText(generateMathQuestion());
            generateResponses();
        }
    }

    public void generateResponses(){
        Button button1 = findViewById(R.id.mathresponse1);
        button1.setText(Integer.toString(this.response1));
        Button button2 = findViewById(R.id.mathresponse2);
        button2.setText(Integer.toString(this.response2));
        Button button3 = findViewById(R.id.mathresponse3);
        button3.setText(Integer.toString(this.response3));
        Button button4 = findViewById(R.id.mathresponse4);
        button4.setText(Integer.toString(this.response4));
        Button button5 = findViewById(R.id.mathresponse5);
        button5.setText(Integer.toString(this.response5));
        Button button6 = findViewById(R.id.mathresponse6);
        button6.setText(Integer.toString(this.response6));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathquiz);
        TextView mathQuestionTextView = findViewById(R.id.mathquestion);
        mathQuestionTextView.setText(generateMathQuestion());
        generateResponses();
    }
}
