package com.example.android.readitapp;

import java.util.ArrayList;
import java.util.Date;

// maybe we should add status od the chellange to

public class Challenge
{
    private String title;
    private AgeGroupsEnum ageGroup;
    private Date startDate;
    private Date endDate;
    private ArrayList<Book> books;
    private String challengeInfo;
    private int challengeCover;

    public Challenge(String title, AgeGroupsEnum ageGroup, Date startDate, Date endDate, ArrayList<Book> books, String challengeInfo, int challengeCover) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.books = books;
        this.challengeInfo = challengeInfo;
        this.challengeCover = challengeCover;
    }

    public String getTitle() {
        return title;
    }

    public AgeGroupsEnum getAgeGroup() {
        return ageGroup;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String getChallengeInfo() {
        return challengeInfo;
    }

    public int getChallengeCover() { return challengeCover; }
}
