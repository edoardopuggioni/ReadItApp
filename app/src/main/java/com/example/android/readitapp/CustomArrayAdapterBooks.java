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

private final int challengeParticipationNumber;

    public CustomArrayAdapterBooks (Context context, ArrayList<Book> books, int challengeParticipationNumber) {

        super(context, 0 , books);
        this.challengeParticipationNumber = challengeParticipationNumber;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        Book book;

        //challengeParticipation challengeParticipation = (ChallengeParticipation) getItem(position);
         AppManager appManager = AppManager.getInstance();

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_challenges_custom_book_item,
                    parent, false);

        //handlers to the elements in activity .xml
        TextView list_item_book_title = (TextView) convertView.findViewById(R.id.book_title);
        ImageView list_item_challenge_book_cover_ = (ImageView) convertView.findViewById(R.id.bookCover);
        book = appManager.getCurrentUser().getChallengesParticipations()
                .get(challengeParticipationNumber).getChallenge().getBooks().get(position);
        list_item_book_title.setText(book.getTitle());
        list_item_challenge_book_cover_.setImageResource(book.getCover());

        return convertView;
    }
}
