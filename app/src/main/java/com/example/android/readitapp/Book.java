package com.example.android.readitapp;

public class Book
{
    private String isbn;
    private String title;
    private AgeGroupsEnum ageGroup;
    private String summary;
    private String cover;
    private Quiz quiz;

    public Book (String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }
}
