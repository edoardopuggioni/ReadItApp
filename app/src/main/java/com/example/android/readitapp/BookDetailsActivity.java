package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class BookDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        // creating toolbar
        initToolbar(R.id.toolbar);

        //catching data from previous intent
        Intent CaughtIntent = getIntent();
        int bookNumber = Integer.parseInt(CaughtIntent.getStringExtra(EXTRA_MESSAGE));

        AppManager appManager = AppManager.getInstance();

        //creating handlers
        TextView bookTitleContainer = findViewById(R.id.book_tile_container);
        ImageView bookCoverContainer =  findViewById(R.id.book_cover_container);
        TextView bookIsbnContainer = findViewById(R.id.book_isbn_container);
        TextView bookPlotContainer =  findViewById(R.id.plot_summary_container);

        //fill TextViews with data
        bookTitleContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(bookNumber).getTitle());
        bookCoverContainer.setImageResource(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(bookNumber).getCover());
        bookIsbnContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(bookNumber).getIsbn());
        bookPlotContainer.setText(appManager.getCurrentUser().getChallengesParticipations().get(0).getChallenge().getBooks().get(bookNumber).getSummary());
    }
}
