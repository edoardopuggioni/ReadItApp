package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MultipleChoiceActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        AppManager appManager = AppManager.getInstance();
        QuizStatus quizStatus = appManager.getQuizStatus();

        int currentQuestion = quizStatus.getCurrentQuestion();

        MultipleChoice multipleChoice = (MultipleChoice) quizStatus.getQuiz().getQuestion(currentQuestion);

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

    public void clickAnswer1(View view)
    {

    }

    public void clickAnswer2(View view)
    {

    }

    public void clickAnswer3(View view)
    {

    }

    public void clickAnswer4(View view)
    {

    }
}
