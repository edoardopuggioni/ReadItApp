package com.example.android.readitapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MultipleChoiceActivity extends AppCompatActivity
{
    MultipleChoice multipleChoice;
    int correctIndex;
    Boolean answered = false;
    ProgressBar progressBar;
    QuizStatus quizStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        AppManager appManager = AppManager.getInstance();
        quizStatus = appManager.getQuizStatus();

        int currentQuestion = quizStatus.getCurrentQuestion();

        multipleChoice = (MultipleChoice) quizStatus.getQuiz().getQuestion(currentQuestion);
        correctIndex = multipleChoice.getCorrectAnswerIndex();

        progressBar = findViewById(R.id.quiz_progressBar);
        int progress = (int) ( (float) currentQuestion  / quizStatus.getQuiz().getNumberOfQuestions() * 100 );
        progressBar.setProgress(progress);

        TextView textViewQuestion = findViewById(R.id.multiple_choice_question);
        textViewQuestion.setText(multipleChoice.getQuestion());

        String[] answers = multipleChoice.getAnswers();

        TextView textViewAnswer;
        textViewAnswer = findViewById(R.id.multiple_choice_answer1);
        textViewAnswer.setText(answers[0]);
        textViewAnswer = findViewById(R.id.multiple_choice_answer2);
        textViewAnswer.setText(answers[1]);
        textViewAnswer = findViewById(R.id.multiple_choice_answer3);
        textViewAnswer.setText(answers[2]);
        textViewAnswer = findViewById(R.id.multiple_choice_answer4);
        textViewAnswer.setText(answers[3]);
    }

    private void highlightCorrectAnswer()
    {
        Button button = null;
        answered = true;

        switch (correctIndex)
        {
            case 0:
                button = findViewById(R.id.multiple_choice_answer1);
                break;

            case 1:
                button = findViewById(R.id.multiple_choice_answer2);
                break;

            case 3:
                button = findViewById(R.id.multiple_choice_answer3);
                break;

            case 4:
                button = findViewById(R.id.multiple_choice_answer4);
                break;
        }

        if( button != null )
            button.getBackground().setColorFilter(Color.GREEN,PorterDuff.Mode.MULTIPLY);
    }

    public void showNextButton()
    {
        Button button = findViewById(R.id.multiple_choice_next);
        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        button.startAnimation(slideUp);
        button.setVisibility(View.VISIBLE);
    }

    public void clickAnswer1(View view)
    {
        Button button = findViewById(R.id.multiple_choice_answer1);

        if( !answered )
        {
            highlightCorrectAnswer();
            showNextButton();

            if(correctIndex != 0)
                button.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY);
        }
    }

    public void clickAnswer2(View view)
    {
        Button button = findViewById(R.id.multiple_choice_answer2);

        if( !answered )
        {
            highlightCorrectAnswer();
            showNextButton();

            if(correctIndex != 1)
                button.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY);
        }
    }

    public void clickAnswer3(View view)
    {
        Button button = findViewById(R.id.multiple_choice_answer3);

        if( !answered )
        {
            highlightCorrectAnswer();
            showNextButton();

            if(correctIndex != 2)
                button.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY);
        }
    }

    public void clickAnswer4(View view)
    {
        Button button = findViewById(R.id.multiple_choice_answer4);

        if( !answered )
        {
            highlightCorrectAnswer();
            showNextButton();

            if(correctIndex != 3)
                button.getBackground().setColorFilter(Color.RED,PorterDuff.Mode.MULTIPLY);
        }
    }

    public void nextQuestion(View view)
    {
        if( quizStatus.quizIsFinished() )
        {
            // TODO Create EndQuizActivity and start it from here.
        }
        else
        {
            quizStatus.setNextQuestion();
            Intent intent = new Intent(this, MultipleChoiceActivity.class);
            startActivity(intent);
            ActivityCompat.finishAffinity(MultipleChoiceActivity.this);
        }
    }
}
