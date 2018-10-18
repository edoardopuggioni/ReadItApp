package com.example.android.readitapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ChallengesActivity extends BaseActivity {

    private ListView listView;
    private CustomAdapter challengesAdapter;
    private AppManager appManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        // creating toolbar
        initToolbar(R.id.toolbar);
        appManager = AppManager.getInstance();





        listView = (ListView) findViewById(R.id.list_view);
        challengesAdapter = new CustomAdapter(this, appManager.getCurrentUser().getChallengesParticipations() );
        listView.setAdapter(challengesAdapter);
        Log.d("mydebug", "msg");
    }
}
