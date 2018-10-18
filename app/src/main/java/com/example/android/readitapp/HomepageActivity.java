package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HomepageActivity extends BaseActivity
{
    TextView welcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        initToolbar(R.id.toolbar);

        AppManager appManager = AppManager.getInstance();
        User currentUser = appManager.getCurrentUser();

        welcomeMessage = findViewById(R.id.homepage_welcome);
        ArrayList<Book> borrowedBooks = currentUser.getBorrowedBooks();

        String borrowedBooksString = "";
        for(Book i: borrowedBooks)
            borrowedBooksString += i.getTitle() + "\n";

        welcomeMessage.setText("Welcome " + currentUser.getFirstName() + "!\nYour current books are:\n"+borrowedBooksString );
    }

    public void goToActivity(View view)
    {
        // Do something in response to button

        AppManager appManager = AppManager.getInstance();
        Intent nextActivity;

        switch( view.getId() )
        {
            case R.id.homepage_quiz_button:
                nextActivity = new Intent(this, AvailableQuizzesActivity.class);
                startActivity(nextActivity);
                break;

            case R.id.homepage_achievements_button:
                nextActivity = new Intent(this, AchievementsActivity.class);
                startActivity(nextActivity);
                break;

            case R.id.homepage_challenges_button:
                nextActivity = new Intent(this, ChallengesActivity.class);
                startActivity(nextActivity);
                break;

            case R.id.homepage_logout_button:
                appManager.logout();
                nextActivity = new Intent(this, LoginActivity.class);
                startActivity(nextActivity);
                break;
        }
    }
}
