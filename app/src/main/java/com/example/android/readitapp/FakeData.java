package com.example.android.readitapp;

// In the constructor of this object we create all the hardcoded data. Later on, if we decide to
// implement a real database, we can simply discard this object and change the methods in the
// Database singleton.

import java.util.ArrayList;
import java.util.Collections;

public class FakeData
{
    ArrayList<User> users;
    ArrayList<Challenge> challanges;

    private static final FakeData ourInstance = new FakeData();

    public static FakeData getInstance()
    {
        return ourInstance;
    }


    private FakeData()
    {
        // Here we create all the hardcoded data.
        AppManager appManager = AppManager.getInstance();
        String pswHash;
        Achievements achievements;
        User user;
        ChallengeParticipation challengeParticipation;
        int gems;
        ArrayList<Book> borrowedBooks;




        users = new ArrayList<>();

        pswHash = appManager.md5("p1");
        achievements = new Achievements();
        challengeParticipation = new ChallengeParticipation();
        borrowedBooks = new ArrayList<Book>(Collections.singleton(new Book("Harry Potter1")));
        user = new User( 1, pswHash, "Edoardo", AgeGroupsEnum.DRAGONS, achievements, 50, borrowedBooks );
        users.add(user);

        pswHash = appManager.md5("p2");
        achievements = new Achievements();
        challengeParticipation = new ChallengeParticipation();
        borrowedBooks = new ArrayList<Book>(Collections.singleton(new Book("Harry Potter2")));
        user = new User( 2, pswHash, "Alessandro", AgeGroupsEnum.TIGERS, achievements, 173, borrowedBooks );
        users.add(user);

        pswHash = appManager.md5("p3");
        achievements = new Achievements();
        challengeParticipation = new ChallengeParticipation();
        borrowedBooks = new ArrayList<Book>(Collections.singleton(new Book("Harry Potter3")));
        user = new User( 3, pswHash, "Andreas", AgeGroupsEnum.BUNNIES, achievements, 4, borrowedBooks);
        users.add(user);




    }


}
