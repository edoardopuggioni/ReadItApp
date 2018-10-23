package com.example.android.readitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AchievementsActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        initToolbar(R.id.toolbar);

        TextView textView;
        GridView gridView;
        AppManager appManager = AppManager.getInstance();
        Achievements achievements = appManager.getCurrentUser().getAchievements();

        textView = (TextView) findViewById(R.id.achievements_gems);
        gridView = (GridView) findViewById(R.id.other_badges_grid_view);

        textView.setText( "You collected " + achievements.getGemsTotal() + " gems" );

        ArrayList<Badge> badges = achievements.getBadges();
        CustomArrayAdapterOtherBadges arrayAdapter = new CustomArrayAdapterOtherBadges(this, badges );

        gridView.setAdapter(arrayAdapter);
    }
}
