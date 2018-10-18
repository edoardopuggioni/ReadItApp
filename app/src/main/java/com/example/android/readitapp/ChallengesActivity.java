package com.example.android.readitapp;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ChallengesActivity extends BaseActivity {

    private ListView listView;
    private CustomAdapter challengesAdapter;


    private AppManager appManager;


    //private AppManager appManager;
    //ArrayList<Challenge> dataModels;
   // ListView listView;
    //private static CustomAdapter adapter;

    String[] cheeses = {
            "Parmesan",
            "Ricotta",
            "Fontina",
            "Mozzarella",
            "Cheddar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);
        // creating toolbar
        initToolbar(R.id.toolbar);
        appManager = AppManager.getInstance();


        listView = (ListView) findViewById(R.id.list_view);

        challengesAdapter = new CustomAdapter(this, appManager.getCurrentUser().getChallengesParticipations() );
        listView.setAdapter(challengesAdapter);





        //appManager = AppManager.getInstance();
       // adapter= new CustomAdapter(dataModels,getApplicationContext());

        //listView.setAdapter(adapter);

        // creating ArrayAdapter to display the data
       //ArrayAdapter cheeseAdapter = new ArrayAdapter<String>(this, R.layout.activity_challenges, R.id.cheese_name, cheeses);
      // ListView cheeseList = new ListView(this);
//        setContentView(cheeseList);
     // cheeseList.setAdapter(cheeseAdapter);

    }
}
