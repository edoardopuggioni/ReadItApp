package com.example.android.readitapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database
{
    private static final Database ourInstance = new Database();

    public static Database getInstance()
    {
        return ourInstance;
    }

    public Database()
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

    public ArrayList<Challenge> getChallengesByAgeGroup( AgeGroupsEnum ageGroup )
    {
        FakeData fakeData = FakeData.getInstance();
        ArrayList<Challenge> challenges = fakeData.challenges;
        ArrayList<Challenge> challengesForAgeGroup = new ArrayList<>();

        for( Challenge c : challenges )
        {
            if( c.getAgeGroup().equals(ageGroup) )
                challengesForAgeGroup.add(c);
        }

        return challengesForAgeGroup;
    }
}
