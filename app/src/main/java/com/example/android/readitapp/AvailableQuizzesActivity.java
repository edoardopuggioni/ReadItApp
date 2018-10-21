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
                this, returnedBooks );

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener( new AvailableQuizzesActivity.CustomOnItemClickListener() );
    }

    public class CustomOnItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Intent intent = new Intent(  getApplicationContext(), QuizStartActivity.class );

            // Passing the reference to the selected book (the user actually selected a quiz).
            String message = String.valueOf(position);
            intent.putExtra( EXTRA_MESSAGE, message );

            startActivity(intent);
        }
    }
}
