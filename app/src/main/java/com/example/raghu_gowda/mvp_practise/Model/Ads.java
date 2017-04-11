package com.example.raghu_gowda.mvp_practise.Model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Admin on 4/10/17.
 */
@Root(name="ads")
public class Ads implements Parcelable{
    @ElementList(name="ad",inline = true, required = false)
    private List<Ad> ass;
    @Element(name="responseTime",required = false)
    private String responseTime;
    @Element(name="serverId",required = false)
    private String serverId;
    @Element(name="totalCampaignsRequested",required = false)
    private String totalCampaignsRequested;
    @Element(name="version",required = false)
    private String version;

    public Ads(){}

    protected Ads(Parcel in) {
        responseTime = in.readString();
        serverId = in.readString();
        totalCampaignsRequested = in.readString();
        version = in.readString();
    }

    public static final Creator<Ads> CREATOR = new Creator<Ads>() {
        @Override
        public Ads createFromParcel(Parcel in) {
            return new Ads(in);
        }

        @Override
        public Ads[] newArray(int size) {
            return new Ads[size];
        }
    };

    public List<Ad> getAd ()
    {
        return ass;
    }

    public void setAd (List<Ad> aad)
    {
        this.ass = aad;
    }



    @Override
    public String toString()
    {
        return "ClassPojo [ad = "+ass+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(responseTime);
        dest.writeString(serverId);
        dest.writeString(totalCampaignsRequested);
        dest.writeString(version);
    }
}

