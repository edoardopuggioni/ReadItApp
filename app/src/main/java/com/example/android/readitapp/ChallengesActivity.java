package com.example.android.readitapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChallengesActivity extends AppCompatActivity {

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


        ArrayAdapter cheeseAdapter =
                new ArrayAdapter<String>(
                        this,
                        R.layout.activity_challenges,
                        R.id.cheese_name,
                        cheeses
                );

        ListView cheeseList = new ListView(this);
        setContentView(cheeseList);
        cheeseList.setAdapter(cheeseAdapter);
    }
}
