package com.example.android.quiz_app_abnd_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class scoreScreen extends AppCompatActivity {

    TextView tv;
    public TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        tv = (TextView) findViewById(R.id.scoreView);
        msg = (TextView) findViewById(R.id.tb);

        int intValue = getIntent().getExtras().getInt("intVariableName");
        tv.setText("" + intValue);
        if (intValue == 0) {
            msg.setText("Oops! No Donut for you");
        } else if (intValue == 5) {
            msg.setText("Try hard . Play hard.");
        } else if (intValue == 10) {
            msg.setText("Better Luck Next Time");
        } else if (intValue <= 15) {
            msg.setText("Nice try");
        } else if (intValue == 20) {
            msg.setText("Well played. Cheers");
        } else if (intValue == 25) {
            msg.setText("Impressive.So close to victory.");
        } else if (intValue == 30) {
            msg.setText("Congratulations, Winner. Nailed it.");
        }
    }


}
