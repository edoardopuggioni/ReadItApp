package com.example.android.readitapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.AlarmClock;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ChallengesInDetailActivity extends BaseActivity {

    int challengeNumber;
    private AppManager appManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges_in_detail);
        initToolbar(R.id.toolbar);
        Intent CaughtIntent = getIntent();
        challengeNumber = Integer.parseInt(CaughtIntent.getStringExtra(AlarmClock.EXTRA_MESSAGE))-1;

        appManager = AppManager.getInstance();



        TextView challengeNameContainer = findViewById(R.id.challenge_name_container);
        ImageView challengeCoverContainer =  findViewById(R.id.challenge_cover_container);
        TextView challengeDescriptionContainer = findViewById(R.id.challenge_description_container);
        TextView challengeEndContainer =  findViewById(R.id.challenge_end_container);
        Button challengeRelatedBooksButton =   findViewById(R.id.related_books_button);

        //fill TextViews with data
        challengeNameContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getTitle());
        challengeCoverContainer.setImageResource(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getChallengeCover());
        challengeDescriptionContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getChallengeInfo());

        // TODO: 19/10/2018 Fix date, not showing properly date from challenge

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String date = dateFormat.format(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getStartDate());
        challengeEndContainer.setText("" + appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getStartDate());

        //challengeRelatedBooksButton.setText("" + sbm.getBook(Integer.parseInt(BookNumber)).getPrice());
    }
}
