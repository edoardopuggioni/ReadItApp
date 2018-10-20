package com.example.android.readitapp;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizStartActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        initToolbar(R.id.toolbar);

//        Intent CaughtIntent = getIntent();
//        int bookIndex = Integer.parseInt(CaughtIntent.getStringExtra(AlarmClock.EXTRA_MESSAGE))-1;

//        AppManager appManager = AppManager.getInstance();
//        String title = appManager.getCurrentUser().getReturnedBooks().get(bookIndex).getTitle();

//        TextView textView = findViewById(R.id.textView);
//        textView.setText("You are about to start the quiz on " + title + "!\n");
    }
}
