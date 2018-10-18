package com.example.android.readitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    //private Context mContext;
    private ArrayList<ChallengeParticipation> challengeParticipations;
    private LayoutInflater thisInflater;


    private AppManager appManager;


    public CustomAdapter(Context context, ArrayList<ChallengeParticipation> challengeParticipations) {
        super(context, 0, challengeParticipations );
    }
    // Check if an existing view is being reused, otherwise inflate the view
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        ChallengeParticipation part = (ChallengeParticipation) getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_in_custom_item, parent, false);

        //filing the data into activity's ListView
        TextView list_item_challenge_item = (TextView) convertView.findViewById(R.id.challenge_title);
        list_item_challenge_item.setText(part.getGems());
        Log.d("debug1", "entering");


        return convertView;
    }

}
