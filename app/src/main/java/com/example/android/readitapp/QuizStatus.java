package com.example.android.readitapp;

public class QuizStatus
{
    private Quiz quiz;
    private int currentQuestion;
    private int correctAnswers;

    public QuizStatus(Quiz quiz, int currentQuestion, int correctAnswers)
    {
        this.quiz = quiz;
        this.currentQuestion = currentQuestion;
        this.correctAnswers = correctAnswers;
    }

    public Quiz getQuiz()
    {
        return quiz;
    }

    public int getCurrentQuestion()
    {
        return currentQuestion;
    }

    public int getCorrectAnswers()
    {
        return correctAnswers;
    }
}
