package com.example.raghu_gowda.mvp_practise.Model;

/**
 * Created by Admin on 4/10/17.
 */


public class MyPojo
{
    private Ads ads;

    public Ads getAds ()
    {
        return ads;
    }

    public void setAds (Ads ads)
    {
        this.ads = ads;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ads = "+ads+"]";
    }


}

