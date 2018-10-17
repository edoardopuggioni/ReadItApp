package com.example.android.readitapp;

import java.util.ArrayList;

public class Database
{
    private static final Database ourInstance = new Database();

    public static Database getInstance()
    {
        return ourInstance;
    }

    private Database()
    {
    }

    public User getUserByCardAndPassword( Integer cardNumber, String passwordHash )
    {
        FakeData fakeData = FakeData.getInstance();
        User user = null;
        ArrayList<User> users = fakeData.users;

        for( User u: users )
        {
            if( u.getCardNumber() == cardNumber )
            {
                user = u;
                break;
            }
        }

        if( user == null )
            return null;

        if( !user.getPasswordHash().equals(passwordHash) )
            return null;

        return user;
    }
}
