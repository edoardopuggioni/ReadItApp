package com.example.android.readitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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

        ListView listView;
        AppManager appManager = AppManager.getInstance();

        ArrayList<Book> borrowedBooks = appManager.getCurrentUser().getBorrowedBooks();

        listView = (ListView) findViewById(R.id.borrowed_books_list_view);

        CustomArrayAdapterBorrowedBooks arrayAdapter = new CustomArrayAdapterBorrowedBooks(
                getApplicationContext(), borrowedBooks );

        listView.setAdapter(arrayAdapter);


       // Button button = (Button) findViewById(R.id.homepage_achievements_button);
       // button.setOnClickListener(new View.OnClickListener() {

       //         public void onClick(View v) {
       //            Intent achieve = new Intent(HomepageActivity.this, AchievementsActivity.class);
       //          startActivity(achieve);
       //
       //          }
       //    });

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
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("logged_user", -1);
                editor.apply();

                nextActivity = new Intent(this, LoginActivity.class);
                startActivity(nextActivity);
                break;
        }
    }
}
