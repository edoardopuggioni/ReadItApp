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

    public Challenge(String title, AgeGroupsEnum ageGroup, Date startDate, Date endDate, ArrayList<Book> books, String challengeInfo) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.startDate = startDate;
        this.endDate = endDate;
        this.books = books;
        this.challengeInfo = challengeInfo;
    }
}
