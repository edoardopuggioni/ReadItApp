package com.example.android.readitapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.AlarmClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class ChallengesInDetailActivity extends BaseActivity {

    int challengeNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppManager appManager;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges_in_detail);
        initToolbar(R.id.toolbar);
        Intent CaughtIntent = getIntent();
        challengeNumber = Integer.parseInt(CaughtIntent.getStringExtra(AlarmClock.EXTRA_MESSAGE)) -1;

        appManager = AppManager.getInstance();

        TextView challengeNameContainer = findViewById(R.id.challenge_name_container);
        ImageView challengeCoverContainer =  findViewById(R.id.challenge_cover_container);
        TextView challengeDescriptionContainer = findViewById(R.id.challenge_description_container);
        TextView challengeEndContainer =  findViewById(R.id.challenge_end_container);
        Button challengeRelatedBooksButton = findViewById(R.id.related_books_button);

        //fill TextViews with data
        challengeNameContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getTitle());
        challengeCoverContainer.setImageResource(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getChallengeCover());
        challengeDescriptionContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getChallengeInfo());

        //displaying challenge's end date
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        String date = dateFormat.format(appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getStartDate());
        challengeEndContainer.setText("Challenge ends at: " + date);

        // button listener
        challengeRelatedBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BookListActivity.class );
                //passing the reference to the challenge
                intent.putExtra( EXTRA_MESSAGE, ""+challengeNumber );
                startActivity(intent);
            }
        });
    }
}
