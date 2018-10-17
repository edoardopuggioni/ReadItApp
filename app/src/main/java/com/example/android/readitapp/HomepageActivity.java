package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomepageActivity extends AppCompatActivity
{
    TextView welcomeMessagge;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        AppManager appManager = AppManager.getInstance();
        User currentUser = appManager.getCurrentUser();

        welcomeMessagge = findViewById(R.id.homepage_welcome);
        welcomeMessagge.setText("Welcome " + currentUser.getFirstName() + "!");
    }

    public void goToActivity(View view)
    {
        // Do something in response to button
        switch (view.getId())
        {
            case R.id.homepage_quiz_button:
                Intent intentAchievements = new Intent(this, AchievementsActivity.class);
                startActivity(intentAchievements);
                break;

            case R.id.homepage_achievements_button:
                break;

            case R.id.homepage_challenges_button:
                Intent intentChallenges = new Intent(this, ChallengesActivity.class);
                startActivity(intentChallenges);
                break;
        }
    }
}
