package com.example.android.readitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomArrayAdapterBooks extends ArrayAdapter {



    public CustomArrayAdapterBooks (Context context, ArrayList<Book> books) {

        super(context, 0 , books);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {


        //challengeParticipation challengeParticipation = (ChallengeParticipation) getItem(position);
         AppManager appManager = AppManager.getInstance();

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_custom_book_item,
                    parent, false);

        //handlers to the elements in activity .xml
        TextView list_item_book_title = (TextView) convertView.findViewById(R.id.book_title);
        ImageView list_item_challenge_book_cover_ = (ImageView) convertView.findViewById(R.id.bookCover);

        list_item_book_title.setText(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(position).getTitle());
        list_item_challenge_book_cover_.setImageResource(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(position).getCover());

        return convertView;
    }
}
