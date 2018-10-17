package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class HomepageActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initToolbar(R.id.toolbar);
    }

    public void goToActivity(View view)
    {
        // Do something in response to button
        switch (view.getId())
        {
            case R.id.homepage_quiz_button:
                Intent intent = new Intent(this, ChallengesActivity.class);
                startActivity(intent);
                break;

            case R.id.homepage_achievements_button:
                break;

            case R.id.homepage_challenges_button:
                break;
        }
    }
}
