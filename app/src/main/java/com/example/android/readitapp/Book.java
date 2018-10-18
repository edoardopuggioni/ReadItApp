package com.example.android.readitapp;

public class Book
{
    private String isbn;
    private String title;
    private AgeGroupsEnum ageGroup;
    private String summary;
    private String cover;
    // I commented out Quiz for debugging purposes and to create books without quizzes
   // private Quiz quiz;

    public Book (String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }



    // This constructor does not contain quiz object!
    public Book(String isbn, String title, AgeGroupsEnum ageGroup, String summary, String cover) {
        this.isbn = isbn;
        this.title = title;
        this.ageGroup = ageGroup;
        this.summary = summary;
        this.cover = cover;
    }
}
