package com.example.android.readitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

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
        ChallengeParticipation challengeParticipationReference = appManager.getCurrentUser().getChallengesParticipations().get(position);

        //challengeParticipation challengeParticipation = (ChallengeParticipation) getItem(position);
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_in_custom_item,
                    parent, false);

        Date currentDate = new Date();
        //get

        //handlers to the elements in activity .xml

        TextView list_item_challenge_title = (TextView) convertView.findViewById(R.id.challenge_title);
        TextView list_item_challenge_gems_ = (TextView) convertView.findViewById(R.id.challenge_gems);
        TextView list_item_challenge_days_to_end = (TextView) convertView.findViewById(R.id.days_to_end_value);

        list_item_challenge_title.setText(challengeParticipationReference.getChallenge().getTitle());
        list_item_challenge_gems_.setText("" + challengeParticipationReference.getGems());
        //list_item_challenge_days_to_end.setText("" + challengeParticipationReference.getGems());

        return convertView;
    }
}
