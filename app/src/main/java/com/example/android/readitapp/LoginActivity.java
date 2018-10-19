package com.example.android.readitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoginActivity extends BaseActivity
{
    private AppManager appManager;
    private EditText editTextCardID = null;
    private EditText editTextPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        FakeData fakeData = FakeData.getInstance();

        // First I check the SharedPreferences, a kind of offline local memory in the phone memory.
        // If there is already something, I have to load instead of create new.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Gson gson = new Gson();
        String json = prefs.getString("users_list", null);
        Type type = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<User> users = (ArrayList<User>) gson.fromJson(json, type);

        // REMEMBER every time we change some data in some user, we have to update the saved user
        // list in the prefs.
        if( users != null )
            fakeData.users = users;

        // REMEMBER
        // Every time we login a user, we have to update the index of the logged user in the prefs.
        // Every time we logout a user, we have to change the index in the prefs to -1.
        int loggedUserIndex = prefs.getInt("logged_user", -1 );
        if( loggedUserIndex != -1 )
        {
            AppManager appManager = AppManager.getInstance();
            appManager.setCurrentUser(fakeData.users.get(loggedUserIndex));
            Intent intent = new Intent(this, HomepageActivity.class);
            startActivity(intent);
            ActivityCompat.finishAffinity(LoginActivity.this);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        appManager = AppManager.getInstance();

        editTextCardID = (EditText)  findViewById(R.id.editTextCardID);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    private Boolean validateFields ( String cardNumberString, String password )
    {
        Toast toast;
        Integer cardNumber;

        if( cardNumberString.matches("") )
        {
            toast = Toast.makeText( getApplicationContext(),"CardID missing", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        try
        {
            cardNumber = Integer.parseInt( cardNumberString );
        }
        catch(Exception e)
        {
            toast = Toast.makeText( getApplicationContext(),"Price format error", Toast.LENGTH_SHORT );
            toast.show();
            return false;
        }

        if( password.matches("") )
        {
            toast = Toast.makeText( getApplicationContext(),"Title missing", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        return true;
    }

    public void loginUser( View view )
    {
        String cardNumberString;
        String password;
        Integer cardNumber;
        String passwordHash;
        Intent intent;

//        intent = new Intent(this, HomepageActivity.class);
//        startActivity(intent);
//        return;

        cardNumberString = editTextCardID.getText().toString();
        password = editTextPassword.getText().toString();

        if( !validateFields( cardNumberString, password ) )
            return;

        cardNumber = Integer.parseInt(cardNumberString);
        passwordHash = appManager.md5(password);

        if( appManager.loginUser( cardNumber, passwordHash ) )
        {
            // Now we have to update the loggedUserIndex in the SharedPreferences.

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();

            AppManager appManager = AppManager.getInstance();
            FakeData fakeData = FakeData.getInstance();
            int loggedUserIndex = fakeData.users.indexOf(appManager.getCurrentUser());

            editor.putInt("logged_user", loggedUserIndex);
            editor.apply();


            // Now we pass to the Homepage activity. In the Homepage we can retrieve the logged
            // user through the AppManager currentUser.
            intent = new Intent(this, HomepageActivity.class);
            startActivity(intent);
            ActivityCompat.finishAffinity(LoginActivity.this);
        }
        else
        {
            // Login failed. We have to display some kind of message below the fields that says
            // something like "Wrong Card Number or Password". We have to do this without passing
            // to another activity.
        }
    }
}
