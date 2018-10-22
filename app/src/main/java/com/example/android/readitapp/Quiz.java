package com.example.android.readitapp;

import java.util.ArrayList;

public class Quiz
{
    private ArrayList<Question> questions;

    public Quiz(ArrayList<Question> questions) {
        this.questions = questions;
    }

    Question getQuestion( int index )
    {
        return questions.get(index);
    }

    int getNumberOfQuestions()
    {
        return questions.size();
    }
}
