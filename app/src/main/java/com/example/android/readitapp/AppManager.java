package com.example.android.readitapp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        currentUser = null;
        quizStatus = null;
    }

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

    public QuizStatus getQuizStatus()
    {
        return quizStatus;
    }

    // If the login process is successful, return true.
    public Boolean loginUser( Integer cardNumber, String passwordHash )
    {
        Database db = Database.getInstance();
        User user;

        user = db.getUserByCardAndPassword( cardNumber, passwordHash );
        if( user != null )
        {
            currentUser = user;
            return true;
        }
        else
            return false;
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

    public String md5(String s)
    {
        try
        {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
