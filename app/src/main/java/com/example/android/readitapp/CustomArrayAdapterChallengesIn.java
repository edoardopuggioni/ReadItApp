package com.example.android.readitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapterChallengesIn extends ArrayAdapter
{
    private ArrayList<ChallengeParticipation> challengeParticipations;
    private LayoutInflater thisInflater;


    private AppManager appManager;


    public CustomArrayAdapterChallengesIn(Context context, ArrayList<ChallengeParticipation> challengeParticipations)
    {
        super(context, 0, challengeParticipations );
    }

    // Check if an existing view is being reused, otherwise inflate the view
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        appManager = AppManager.getInstance();


        //challengeParticipation challengeParticipation = (ChallengeParticipation) getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_in_custom_item,
                    parent, false);

        //handlers to the elements in activity .xml
        TextView list_item_challenge_title = (TextView) convertView.findViewById(R.id.challenge_title);
        TextView list_item_challenge_days_to_end_ = (TextView) convertView.findViewById(R.id.challenge_days_to_end);

        list_item_challenge_title.setText(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getTitle());
        list_item_challenge_days_to_end_.setText("" +appManager.getCurrentUser().getChallengesParticipations().get(0).getGems());

        Log.d("MyTag", "" + appManager.getCurrentUser().getChallengesParticipations().size());

        return convertView;
    }

}
