package com.example.android.readitapp;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizEndActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end);

        AppManager appManager = AppManager.getInstance();
        QuizStatus quizStatus = appManager.getQuizStatus();

        TextView gemsEarned = findViewById(R.id.quiz_end_you_earned);
        int correctAnswers = quizStatus.getCorrectAnswers();
        if( correctAnswers == 0 || correctAnswers > 1 )
            gemsEarned.setText("You earned " + correctAnswers + " gems");
        else
            gemsEarned.setText("You earned " + correctAnswers + " gem");

        User user = appManager.getCurrentUser();
        user.addGems(correctAnswers);
        user.addGemsForChallenge( quizStatus.getBook(), correctAnswers );

        ImageView gem = findViewById(R.id.quiz_end_gem);
        Animation slideLeft = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
        gem.startAnimation(slideLeft);
        gem.setVisibility(View.VISIBLE);
    }

    public void goToHomepage( View view )
    {
        Intent intent = new Intent(this, HomepageActivity.class);
        startActivity(intent);
        ActivityCompat.finishAffinity(QuizEndActivity.this);
    }
}
