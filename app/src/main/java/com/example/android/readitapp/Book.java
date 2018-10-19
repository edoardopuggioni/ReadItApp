package com.example.android.readitapp;

public class Book
{
    private String isbn;
    private String title;
    private AgeGroupsEnum ageGroup;
    private String summary;
    private int cover;
    private Quiz quiz;

    public Book( String isbn, String title, AgeGroupsEnum ageGroup, String summary, int cover )
    {
        this.isbn = isbn;
        this.title = title;
        this.ageGroup = ageGroup;
        this.summary = summary;
        this.cover = cover;
    }

    public String getTitle()
    {
        return title;
    }

}
