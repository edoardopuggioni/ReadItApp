package com.example.android.readitapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class AvailableQuizzesActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_quizzes);

        initToolbar(R.id.toolbar);

        ListView listView;
        AppManager appManager = AppManager.getInstance();

        ArrayList<Book> returnedBooks = appManager.getCurrentUser().getReturnedBooks();

        listView = (ListView) findViewById(R.id.available_quizzes_list_view);

        CustomArrayAdapterAvailableQuizzes arrayAdapter = new CustomArrayAdapterAvailableQuizzes(
                getApplicationContext(), returnedBooks );

        listView.setAdapter(arrayAdapter);
    }

    public class CustomOnItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            // TODO Read below.
            // Here I have to pass the book instead of passing the QuizStatus, because in the
            // QuizStartActivity I want to display a message like "Welcome to the quiz of Harry
            // Potter" with some instructions, so I still need the title of the book.

            AppManager appManager = AppManager.getInstance();
            Quiz quiz = appManager.getCurrentUser().getReturnedBooks().get(position).getQuiz();
            QuizStatus quizStatus = new QuizStatus( quiz, 0, 0 );
            appManager.setQuizStatus(quizStatus);
            Intent intent = new Intent(getApplicationContext(), QuizStartActivity.class );
            startActivity(intent);
        }
    }
}
