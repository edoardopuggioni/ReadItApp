package com.example.android.readitapp;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class AchievementsActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        initToolbar(R.id.toolbar);

        TextView textView;
        GridView gridView;
        NestedScrollView nestedScrollView;
        AppManager appManager = AppManager.getInstance();
        Achievements achievements = appManager.getCurrentUser().getAchievements();

        textView = (TextView) findViewById(R.id.achievements_gems);

        ArrayList<Badge> badges = new ArrayList<>( achievements.getBadges() );

        ImageView imageViewBadge;
        TextView textViewBadgeTitle;
        TextView textViewBadgeDate;

        Badge badge;
        Date date;

        imageViewBadge = findViewById(R.id.achievements_badge1_image);
        textViewBadgeTitle = findViewById(R.id.achievements_badge1_title);
        textViewBadgeDate = findViewById(R.id.achievements_badge1_date);
        badge = badges.get(0);
        imageViewBadge.setImageResource(badge.getIcon());
        textViewBadgeTitle.setText(badge.getTitle());
        date = badge.getEarningDate();
        textViewBadgeDate.setText( "Earned on " + date.getDate() + "/" + date.getMonth() + "/" + date.getYear() );

        imageViewBadge = findViewById(R.id.achievements_badge2_image);
        textViewBadgeTitle = findViewById(R.id.achievements_badge2_title);
        textViewBadgeDate = findViewById(R.id.achievements_badge2_date);
        badge = badges.get(1);
        imageViewBadge.setImageResource(badge.getIcon());
        textViewBadgeTitle.setText(badge.getTitle());
        date = badge.getEarningDate();
        textViewBadgeDate.setText( "Earned on " + date.getDate() + "/" + date.getMonth() + "/" + date.getYear() );

        badges.remove(1);
        badges.remove(0);

        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScroll1);
        gridView = (GridView) findViewById(R.id.other_badges_grid_view);

        textView.setText( "You collected " + achievements.getGemsTotal() + " gems" );

        CustomArrayAdapterOtherBadges arrayAdapter = new CustomArrayAdapterOtherBadges(this, badges );

        gridView.setAdapter(arrayAdapter);
    }
}
