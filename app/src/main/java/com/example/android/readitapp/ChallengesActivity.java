package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ChallengesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        final ListView listViewHandle = (ListView) findViewById(R.id.list_view);

        // creating toolbar
        initToolbar(R.id.toolbar);

        AppManager appManager = AppManager.getInstance();

        CustomArrayAdapterChallengesIn challengesAdapter = new CustomArrayAdapterChallengesIn(this ,appManager.getCurrentUser().getChallengesParticipations() );

        //adding header to the ListView
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.activity_challenges_in_list_header,listViewHandle,false);
        listViewHandle.addHeaderView(header);

        listViewHandle.setAdapter(challengesAdapter);

        listViewHandle.setOnItemClickListener( new CustomOnItemClickListener() );
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
