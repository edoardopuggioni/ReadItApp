package com.example.android.readitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AchievementsActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        initToolbar(R.id.toolbar);


    }
}
