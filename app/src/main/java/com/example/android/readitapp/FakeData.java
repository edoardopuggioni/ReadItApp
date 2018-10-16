package com.example.android.readitapp;

// In the constructor of this object we create all the hardcoded data. Later on, if we decide to
// implement a real database, we can simply discard this object and change the methods in the
// Database singleton.

import java.util.ArrayList;

public class FakeData
{
    ArrayList<User> users;
    AppManager appManager = AppManager.getInstance();

    private static final FakeData ourInstance = new FakeData();

    public static FakeData getInstance()
    {
        return ourInstance;
    }

    private FakeData()
    {
        // Here we create all the hardcoded data.
        String pswHash;
        Achievements achievements;
        User user;

        users = new ArrayList<>();

        pswHash = appManager.md5("password1");
        achievements = new Achievements();
        user = new User( 00001, pswHash, "Edoardo", AgeGroupsEnum.DRAGONS, achievements );
        users.add(user);

        pswHash = appManager.md5("password2");
        achievements = new Achievements();
        user = new User( 00002, pswHash, "Alessandro", AgeGroupsEnum.DRAGONS, achievements );
        users.add(user);

        pswHash = appManager.md5("password3");
        achievements = new Achievements();
        user = new User( 00003, pswHash, "Alessandro", AgeGroupsEnum.DRAGONS, achievements );
        users.add(user);
    }
}
