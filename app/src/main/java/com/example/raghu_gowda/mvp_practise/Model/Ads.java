package com.example.raghu_gowda.mvp_practise.Model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Admin on 4/10/17.
 */
@Root(name="ads")
public class Ads {
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
}

