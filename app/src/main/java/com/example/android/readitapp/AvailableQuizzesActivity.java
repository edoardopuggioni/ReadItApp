package com.example.android.readitapp;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

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
    }
}
