package com.example.android.readitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapterAvailableChallenges extends ArrayAdapter
{

    private AppManager appManager;

    public CustomArrayAdapterAvailableChallenges(Context context, ArrayList<Challenge> availableChallenges)
    {
        super(context, 0, availableChallenges );
    }

    // Check if an existing view is being reused, otherwise inflate the view
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        appManager = AppManager.getInstance();


        //challengeParticipation challengeParticipation = (ChallengeParticipation) getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_available_custom_item,
                    parent, false);

        //handlers to the elements in activity .xml
         TextView list_item_challenge_available_title = (TextView) convertView.findViewById(R.id.challenge_title_available);
        //TextView list_item_challenge_days_to_end_ = (TextView) convertView.findViewById(R.id.challenge_days_to_end_value);

        list_item_challenge_available_title.setText("abc");
        //list_item_challenge_days_to_end_.setText("" +appManager.getCurrentUser().getChallengesParticipations().get(position).getGems());


        return convertView;
    }

}



