package com.example.android.quiz_app_abnd_project;

import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class MainActivity extends AppCompatActivity {

    String Arrname[] = {"One",
            "Two",
            "Three",
            "Four",
            "Five"
            //"Six"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(getResources().getColor(R.color.Gray), R.drawable.trans, R.drawable.close)
                .addSubMenu(getResources().getColor(R.color.rules), R.drawable.rules)
                .addSubMenu(getResources().getColor(R.color.easy), R.drawable.easy)
                .addSubMenu(getResources().getColor(R.color.hard), R.drawable.hard)
                .addSubMenu(getResources().getColor(R.color.kids), R.drawable.kids)
                .addSubMenu(getResources().getColor(R.color.medium), R.drawable.med)

                //.addSubMenu(Color.parseColor("#FF3D00"),R.drawable.icon)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        if (index == 0) {
                            //Toast.makeText(MainActivity.this,"You selected is one",Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, rules.class);
                            startActivity(intent);

                        } else if (index == 1) {
                            Toast.makeText(MainActivity.this, "You have selected Easy section.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Easy.class);
                            startActivity(intent);
                        } else if (index == 2) {

                            Toast.makeText(MainActivity.this, "You have selected Hard Level.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, hard.class);
                            startActivity(intent);
                        } else if (index == 3) {
                            Toast.makeText(MainActivity.this, "You selected Kids level", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, kids.class);
                            startActivity(intent);
                        } else if (index == 4) {

                            Toast.makeText(MainActivity.this, "You have selected Medium section.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Category1.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "You selected lala level.", Toast.LENGTH_SHORT).show();

                        }

                    }
                });
    }

}
