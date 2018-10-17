package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class HomepageActivity extends BaseActivity
{
    TextView welcomeMessagge;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        AppManager appManager = AppManager.getInstance();
        User currentUser = appManager.getCurrentUser();

        welcomeMessagge = findViewById(R.id.homepage_welcome);
        ArrayList<Book> borrowedBooks = currentUser.getBorrowedBooks();
        String borrowedBooksString = "";
        for(Book i: borrowedBooks){
            borrowedBooksString+=i.getTitle();
        }
        welcomeMessagge.setText("Welcome " + currentUser.getFirstName() + "! \n Your current books are:\n"+borrowedBooksString );
        initToolbar(R.id.toolbar);
    }

    public void goToActivity(View view)
    {
        // Do something in response to button
        switch (view.getId())
        {
            case R.id.homepage_quiz_button:
                Intent intentAchievements = new Intent(this, AchievementsActivity.class);
                startActivity(intentAchievements);
                break;

            case R.id.homepage_achievements_button:
                break;

            case R.id.homepage_challenges_button:
                Intent intentChallenges = new Intent(this, ChallengesActivity.class);
                startActivity(intentChallenges);
                break;

            case R.id.homepage_logout_button:
                Intent intentLogut = new Intent(this, LoginActivity.class);
                startActivity(intentLogut);
                break;
        }
    }
}
