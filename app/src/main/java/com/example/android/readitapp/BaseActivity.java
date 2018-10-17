package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initToolbar(int toolbarId)
    {
        //setContentView(R.layout.toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        ActionBar ab = getSupportActionBar();
//        ab.setDisplayHomeAsUpEnabled(true);

        AppManager appManager = AppManager.getInstance();
        if(appManager.getCurrentUser()!=null){
            TextView gemsAmount= (TextView) findViewById(R.id.gemsAmount);
            ImageView ageGroup= (ImageView) findViewById(R.id.ageGroupSymbol);
            gemsAmount.setText(Integer.toString(appManager.getCurrentUser().gems));

            switch(appManager.getCurrentUser().getAgeGroup()){
                case TIGERS:ageGroup.setImageDrawable(this.getResources().getDrawable(R.drawable.lion));
                break;
                case BUNNIES:ageGroup.setImageDrawable(this.getResources().getDrawable(R.drawable.rabbit));
                break;
                case DRAGONS:ageGroup.setImageDrawable(this.getResources().getDrawable(R.drawable.dragon));
                break;
            }


        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, HomepageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menufile, menu);
        return true;
    }
    }
