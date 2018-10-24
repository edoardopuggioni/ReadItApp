package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ChallengesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        ListView listViewHandleAvailable;
        ListView listViewHandleIn;

        // creating toolbar
        initToolbar(R.id.toolbar);

        AppManager appManager = AppManager.getInstance();

        Database database = new Database();
        ArrayList<Challenge> challenges = database.getChallengesByAgeGroup(appManager.getCurrentUser().getAgeGroup());

        CustomArrayAdapterChallengesIn challengesAdapter = new CustomArrayAdapterChallengesIn(this,  appManager.getCurrentUser().getChallengesParticipations() );
        listViewHandleIn = (ListView) findViewById(R.id.list_view_challenges_in);
        listViewHandleIn.setAdapter(challengesAdapter);

        //Temporary disabled - it's not working with scroll

        //CustomArrayAdapterAvailableChallenges challengesAvailableAdapter = new CustomArrayAdapterAvailableChallenges(this, challenges );
        //listViewHandleAvailable = (ListView) findViewById(R.id.list_view_challenges_available);
        //listViewHandleAvailable.setAdapter(challengesAvailableAdapter);

        //adding header to the ListView
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.activity_challenges_in_list_header,listViewHandleIn,false);
        listViewHandleIn.addHeaderView(header);

        listViewHandleIn.setOnItemClickListener( new CustomOnItemClickListener() );
    }

    public class CustomOnItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Intent intent = new Intent(getApplicationContext(), ChallengesInDetailActivity.class );

            //passing the reference to the challenge
            String message = String.valueOf(position);
            intent.putExtra( EXTRA_MESSAGE, message );
            startActivity(intent);
        }
    }
}
