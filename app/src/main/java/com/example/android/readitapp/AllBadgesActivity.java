package com.example.android.readitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class AllBadgesActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_badges);

        initToolbar(R.id.toolbar);

        GridView gridView = (GridView) findViewById(R.id.other_badges_grid_view);

    }
}
