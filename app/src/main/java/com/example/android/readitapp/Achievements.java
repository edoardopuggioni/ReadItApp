package com.example.android.readitapp;

import java.util.ArrayList;

public class Achievements
{
    private Integer gemsTotal;
    private ArrayList<Badge> badges;

    public Achievements(Integer gemsTotal, ArrayList<Badge> badges)
    {
        this.gemsTotal = gemsTotal;
        this.badges = badges;
    }

    public Integer getGemsTotal()
    {
        return gemsTotal;
    }

    public void setGemsTotal(Integer gemsTotal)
    {
        this.gemsTotal = gemsTotal;
    }

    public ArrayList<Badge> getBadges()
    {
        return badges;
    }
}
