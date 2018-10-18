package com.example.android.readitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ChallengeParticipation> {

    private Context mContext;
    private List<ChallengeParticipation> ChallengesParticipaationList= new ArrayList<>();
    private AppManager appManager;

    public CustomAdapter(Context context, ArrayList<ChallengeParticipation> list) {
        super(context, 0, list );
        mContext = context;
        ChallengesParticipaationList = list;
    }
    // Check if an existing view is being reused, otherwise inflate the view
    public View getView (int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_challenges_in_custom_item,parent,false);

        appManager = AppManager.getInstance();


        //filing the data into activity's ListView
        TextView list_item_challenge_item = (TextView) convertView.findViewById(R.id.challenge_title);
        list_item_challenge_item.setText("test text");
        Log.d("debug1", "entering");


        return convertView;
    }

}
