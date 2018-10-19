package com.example.android.readitapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ChallengesActivity extends BaseActivity {

    private ListView listView;
    private CustomArrayAdapterChallengesIn challengesAdapter;
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

        challengesAdapter = new CustomArrayAdapterChallengesIn(this ,appManager.getCurrentUser().getChallengesParticipations() );

        //Creating header of listView
        TextView textView = new TextView(getApplicationContext());
        textView.setText("Challenges you're in");
        listView.addHeaderView(textView);

        listView.setAdapter(challengesAdapter);


    }
}
