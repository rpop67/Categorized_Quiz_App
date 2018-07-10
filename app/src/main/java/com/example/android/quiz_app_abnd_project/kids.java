package com.example.android.quiz_app_abnd_project;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class kids extends AppCompatActivity {

    TextView minTextView;
    TextView secTextView;
    RadioButton q1_answer;
    RadioButton wrong1_q1;
    RadioButton wrong1_q2;
    RadioButton wrong2_q2;
    RadioButton q2_answer;
    EditText q3_answer;
    CheckBox q4_answer1;
    CheckBox q4_answer2;
    CheckBox q4_answer3;
    CheckBox q4_answer4;
    CheckBox q4_wrong1;
    RadioButton q5_answer;
    RadioButton wrong1_q5;
    RadioButton wrong2_q5;
    RadioButton wrong1_q6;
    RadioButton wrong2_q6;
    RadioButton q6_answer;
    RadioGroup q1_rg;
    RadioGroup q2_rg;
    RadioGroup q3_rg;
    RadioGroup q4_rg;
    int score;
    int add = 5; //score for each correct answer

    private CountDownTimer countDownTimer;
    private long timeLeft = 90000; //2 mins
    boolean timerRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        minTextView = (TextView) findViewById(R.id.min);
        secTextView = (TextView) findViewById(R.id.sec);
        q1_answer = (RadioButton) findViewById(R.id.q1o1);
        wrong1_q1 = (RadioButton) findViewById(R.id.q1o2);
        q2_answer = (RadioButton) findViewById(R.id.q2o2);
        wrong1_q2 = (RadioButton) findViewById(R.id.q2o1);
        wrong2_q2 = (RadioButton) findViewById(R.id.q2o3);
        q3_answer = (EditText) findViewById(R.id.q3o);
        q4_answer1 = (CheckBox) findViewById(R.id.q4o1);
        q4_answer2 = (CheckBox) findViewById(R.id.q4o2);
        q4_answer3 = (CheckBox) findViewById(R.id.q4o4);
        q4_answer4 = (CheckBox) findViewById(R.id.q4o5);
        q4_wrong1 = (CheckBox) findViewById(R.id.q4o3);
        wrong1_q5 = (RadioButton) findViewById(R.id.q5o1);
        wrong2_q5 = (RadioButton) findViewById(R.id.q5o3);
        q5_answer = (RadioButton) findViewById(R.id.q5o2);
        q6_answer = (RadioButton) findViewById(R.id.q6o2);
        wrong1_q6 = (RadioButton) findViewById(R.id.q6o1);
        wrong2_q6 = (RadioButton) findViewById(R.id.q6o3);
        q1_rg = (RadioGroup) findViewById(R.id.rg1);
        q2_rg = (RadioGroup) findViewById(R.id.rg2);
        q3_rg = (RadioGroup) findViewById(R.id.rg3);
        q4_rg = (RadioGroup) findViewById(R.id.rg4);
        //UpdateTimer();
        startStop();

        //To highlight the correct answer
        //Changing the color of correct radio button
        //also,making radio buttons not clickable
        //so that user cannot update its choices on seeing correct answer.

        q1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                q1_answer.setBackgroundColor(getResources().getColor(R.color.Green));
                q1_answer.setClickable(false);
                wrong1_q1.setClickable(false);
            }
        });


        //for question 2, setting
        //radiobuttns unclickabe once user has selected its choice
        //also, highligting the correct answer
        q2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                q2_answer.setBackgroundColor(getResources().getColor(R.color.Green));
                q2_answer.setClickable(false);
                wrong1_q2.setClickable(false);
                wrong2_q2.setClickable(false);
            }
        });

        //for question 5, setting
        //radiobuttns unclickabe once user has selected its choice
        //also, highligting the correct answer
        q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                q5_answer.setBackgroundColor(getResources().getColor(R.color.Green));
                q5_answer.setClickable(false);
                wrong1_q5.setClickable(false);
                wrong2_q5.setClickable(false);
            }
        });

        //for question 6, setting
        //radiobuttns unclickabe once user has selected its choice
        //also, highligting the correct answer
        q4_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                q6_answer.setBackgroundColor(getResources().getColor(R.color.Green));
                q6_answer.setClickable(false);
                wrong1_q6.setClickable(false);
                wrong2_q6.setClickable(false);
            }
        });

    }

    public void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                UpdateTimer();

            }

            @Override
            public void onFinish() {

            }

        }.start();
        timerRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;

    }

    public void UpdateTimer() {
        check();

        int minute = (int) timeLeft / 60000;
        int seconds = (int) timeLeft % 60000 / 1000;

        String minTime = "" + minute;
        String secTime = "";
        if (seconds < 10) secTime += 0;
        secTime += seconds;
        minTextView.setText(minTime);
        secTextView.setText(secTime);
        if (seconds == 1 && minute == 0) {
            Intent myIntent = new Intent(kids.this, scoreScreen.class);
            myIntent.putExtra("intVariableName", score);
            startActivity(myIntent);
        }
    }


    //checks for right opted choice in time intervals
    public void check() {
        score = 0;
        if (q1_answer.isChecked() == true) {
            score += add;
        }
        if (q2_answer.isChecked() == true) {
            score += add;
        }
        if (q3_answer.getText().toString().equalsIgnoreCase("hair")) {
            score += add;
        }
        if (q4_answer4.isChecked() && q4_answer3.isChecked() && q4_answer2.isChecked() && q4_answer1.isChecked() && !(q4_wrong1.isChecked())) {
            score += add;
        }
        if (q5_answer.isChecked() == true) {
            score += add;
        }
        if (q6_answer.isChecked() == true) {
            score += add;
        }

    }

    public void CalcScore(View view) {

        Toast.makeText(kids.this, "You scored " + score + " points.", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(kids.this, scoreScreen.class);
        myIntent.putExtra("intVariableName", score);
        startActivity(myIntent);
    }

}

