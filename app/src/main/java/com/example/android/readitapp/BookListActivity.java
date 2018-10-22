package com.example.android.readitapp;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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

        listViewHandle.setOnItemClickListener( new BookListActivity.CustomOnItemClickListener() );
        }

    public class CustomOnItemClickListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Intent intent = new Intent(getApplicationContext(), HomepageActivity.class );
            //passing the reference to the challenge
           // String message = String.valueOf(position);
            //intent.putExtra( EXTRA_MESSAGE, message );
            startActivity(intent);
        }
    }
}
