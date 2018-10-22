package com.example.android.readitapp;

import java.util.Date;

public class Badge
{
    private String title;
    private int icon;
    private Date earningDate;

    public Badge(String title, int icon, Date earningDate)
    {
        this.title = title;
        this.icon = icon;
        this.earningDate = earningDate;
    }

    public String getTitle()
    {
        return title;
    }

    public int getIcon()
    {
        return icon;
    }

    public Date getEarningDate()
    {
        return earningDate;
    }
}
