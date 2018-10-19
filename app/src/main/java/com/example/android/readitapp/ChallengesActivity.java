package com.example.android.readitapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChallengesActivity extends BaseActivity {

    private ListView listView;
    private CustomAdapter challengesAdapter;
    private AppManager appManager;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        // creating toolbar
        initToolbar(R.id.toolbar);
        appManager = AppManager.getInstance();

        listView = (ListView) findViewById(R.id.list_view);

        challengesAdapter = new CustomAdapter(this ,appManager.getCurrentUser().getChallengesParticipations() );


        //TextView textView = new TextView(getApplicationContext());
        //textView.setText("Hello. I'm a header view");
       // listView.addHeaderView(textView);

        listView.setAdapter(challengesAdapter);


    }
}
