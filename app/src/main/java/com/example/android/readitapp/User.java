package com.example.android.readitapp;

import java.util.ArrayList;

public class User
{
    private Integer cardNumber;
    private String passwordHash;
    private String firstName;
    private AgeGroupsEnum ageGroup;
    private Achievements achievements;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> returnedBooks;
    private ArrayList<ChallengeParticipation> challengesParticipations;
    int gems;


    // The following field seems unnecessary. Every user with the same age group would have the
    // same list, so it doesn't make sense to have the list here in the user object. We can
    // retrieve this list directly in the activity where we want to diplay the list, simply using
    // the age group to "query the database".
    //private ArrayList<Challenge> challenges; // Available challenges for this age group.


    public User( Integer cardNumber, String passwordHash, String firstName, AgeGroupsEnum ageGroup,
                 Achievements achievements, int gems , ArrayList<Book> borrowedBooks,
                 ArrayList<Book> returnedBooks, ArrayList<ChallengeParticipation> challengesParticipations )
    {
        this.cardNumber = cardNumber;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.ageGroup = ageGroup;
        this.achievements = achievements;
        this.gems=gems;
        this.borrowedBooks = borrowedBooks;
        this.returnedBooks = returnedBooks;
        this.challengesParticipations = challengesParticipations;
        returnedBooks = new ArrayList<>();

    }

    public Integer getCardNumber()
    {
        return cardNumber;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public AgeGroupsEnum getAgeGroup()
    {
        return ageGroup;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public ArrayList<Book> getReturnedBooks()
    {
        return returnedBooks;
    }

    public ArrayList<ChallengeParticipation> getChallengesParticipations() { return challengesParticipations; }
}
