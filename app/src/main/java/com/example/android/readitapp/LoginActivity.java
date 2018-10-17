package com.example.android.readitapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity
{
    private AppManager appManager;
    private EditText editTextCardID = null;
    private EditText editTextPassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initToolbar(R.id.toolbar);


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
            // Here we pass to the Homepage activity. In the Homepage we can retrieve the logged
            // user through the app manager, which has a field for this purpose. Furthermore,
            // every time we open a new activity we have to check if the user actually logged in,
            // and if not we have to start the LoginActivity.
            intent = new Intent(this, HomepageActivity.class);
            startActivity(intent);
        }
        else
        {
            // Login failed. We have to display some kind of message below the fields that says
            // something like "Wrong Card Number or Password". We have to do this without passing
            // to another activity.
        }
    }
}
