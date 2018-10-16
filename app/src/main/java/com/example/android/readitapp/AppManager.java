package com.example.android.readitapp;

public class AppManager
{
    private User currentUser;
    private QuizStatus quizStatus;

    private static final AppManager ourInstance = new AppManager();

    public static AppManager getInstance()
    {
        return ourInstance;
    }

    private AppManager()
    {
    }

    // If the login process is successful, return true.
    public Boolean loginUser( Integer cardID, String pswHash )
    {
        return true;
    }

    // Returns true if the user is currently logged in the system.
    public Boolean userLoggedIn()
    {
        if( currentUser != null )
            return true;
        else
            return false;
    }

    public void logout()
    {
        currentUser = null;
    }
}
