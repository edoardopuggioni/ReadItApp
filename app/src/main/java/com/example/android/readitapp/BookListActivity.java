package com.example.android.readitapp;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BookListActivity extends BaseActivity {

    int challengeNumber;
    private AppManager appManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        initToolbar(R.id.toolbar);
        Intent CaughtIntent = getIntent();
        challengeNumber = Integer.parseInt(CaughtIntent.getStringExtra(AlarmClock.EXTRA_MESSAGE));

        appManager = AppManager.getInstance();
        final ListView listViewHandle = (ListView) findViewById(R.id.list_view_for_book);


        ArrayList<Book> books = appManager.getCurrentUser().getChallengesParticipations().get(challengeNumber).getChallenge().getBooks();

        CustomArrayAdapterBooks bookListAdapter = new CustomArrayAdapterBooks(getApplicationContext() ,books);

        listViewHandle.setAdapter(bookListAdapter);

    }
}
