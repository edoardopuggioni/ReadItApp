package com.example.android.readitapp;

import java.util.ArrayList;

public class User
{
    private String pswHash;
    private Integer cardID;
    private String firstName;
    private AgeGroupsEnum ageGroup;
    private Achievements achievements;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> returnedBooks;
    private ArrayList<ChallengeParticipation> challengeParticipations;

    // The following field seems unnecessary. Every user with the same age group would have the
    // same list, so it doesn't make sense to have the list here in the user object. We can
    // retrieve this list directly in the activity where we want to diplay the list, simply using
    // the age group to "query the database".
    //private ArrayList<Challenge> challenges; // Available challenges for this age group.
}
