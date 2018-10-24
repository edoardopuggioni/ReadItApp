package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.ImageView;
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
        int imageResource = book.getCover();

        TextView textView = findViewById(R.id.quiz_start_title);
        textView.setText(title);

        ImageView imageView = findViewById(R.id.quiz_start_cover);
        imageView.setImageResource(imageResource);

        QuizStatus quizStatus = new QuizStatus( book, 0, 0);
        appManager.setQuizStatus(quizStatus);
    }

    public void startQuiz(View view)
    {
        AppManager appManager = AppManager.getInstance();

        Intent intent = new Intent(  getApplicationContext(), MultipleChoiceActivity.class );
        startActivity(intent);
        ActivityCompat.finishAffinity(QuizStartActivity.this);
    }
}
