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

        pswHash = appManager.md5("p1");
        achievements = new Achievements();
        user = new User( 1, pswHash, "Edoardo", AgeGroupsEnum.DRAGONS, achievements );
        users.add(user);

        pswHash = appManager.md5("p2");
        achievements = new Achievements();
        user = new User( 2, pswHash, "Alessandro", AgeGroupsEnum.TIGERS, achievements );
        users.add(user);

        pswHash = appManager.md5("p3");
        achievements = new Achievements();
        user = new User( 3, pswHash, "Alessandro", AgeGroupsEnum.BUNNIES, achievements );
        users.add(user);
    }
}
