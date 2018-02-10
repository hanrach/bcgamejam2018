package com.bcgamejam2018.resolution.bcgamejam2018resolution.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.TextView;

public class mathquiz extends AppCompatActivity {

    private int mathquestionlevel = 1;
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
        int randomResponse = rand.nextInt(5) + 1;
        switch (this.mathquestionlevel){
            case 1 :
                int first = rand.nextInt(11) + 1;
                int second = rand.nextInt(11) + 1;
                this.response1 = rand.nextInt(143) + 1;
                this.response2 = rand.nextInt(143) + 1;
                this.response3 = rand.nextInt(143) + 1;
                this.response4 = rand.nextInt(143) + 1;
                this.response5 = rand.nextInt(143) + 1;
                this.response6 = rand.nextInt(143) + 1;
                answer = first * second;
                switch (randomResponse){
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathquiz);
        TextView mathQuestionTextView;
        mathQuestionTextView  = (TextView)findViewById(R.id.mathquestion);
        mathQuestionTextView.setText(generateMathQuestion());
    }
}
