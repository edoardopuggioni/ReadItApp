package com.example.android.readitapp;

public class MultipleChoice extends Question
{
    private String question;
    private String[] answers;
    private int correctAnswerIndex;

    public MultipleChoice(String question, String[] answers, int correctAnswerIndex)
    {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}
