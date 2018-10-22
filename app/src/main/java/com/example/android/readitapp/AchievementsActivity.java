package com.example.android.readitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class AchievementsActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        initToolbar(R.id.toolbar);

        GridView gridView;
        AppManager appManager = AppManager.getInstance();

        ArrayList<Badge> badges = appManager.getCurrentUser().getAchievements().getBadges();

        gridView = (GridView) findViewById(R.id.other_badges_grid_view);

        CustomArrayAdapterOtherBadges arrayAdapter = new CustomArrayAdapterOtherBadges(
                this, badges );

        gridView.setAdapter(arrayAdapter);
    }
}
