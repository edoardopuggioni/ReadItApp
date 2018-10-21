package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.TextView;

public class QuizStartActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_start);

        Intent CaughtIntent = getIntent();
        int bookIndex = Integer.parseInt(CaughtIntent.getStringExtra(AlarmClock.EXTRA_MESSAGE));

        AppManager appManager = AppManager.getInstance();
        Book book = appManager.getCurrentUser().getReturnedBooks().get(bookIndex);
        String title = book.getTitle();

        TextView textView = findViewById(R.id.quiz_start_title);
        textView.setText(title);

        QuizStatus quizStatus = new QuizStatus( book.getQuiz(), 0, 0);
        appManager.setQuizStatus(quizStatus);
    }

    public void startQuiz(View view)
    {
        AppManager appManager = AppManager.getInstance();

        Intent intent = new Intent(  getApplicationContext(), MultipleChoiceActivity.class );
        startActivity(intent);
    }
}
