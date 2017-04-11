package com.example.raghu_gowda.mvp_practise.Model;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Admin on 4/10/17.
 */
@Root(name="ad")
public class Ad implements Parcelable
{
    @Element(name="campaignId")
    private String campaignId;
    @Element(name="appId")
    private String appId;
    @Element(name="campaignTypeId")
    private String campaignTypeId;
    @Element(name="productDescription")
    private String productDescription;
    @Element(name="productId")
    private String productId;
    @Element(name="categoryName")
    private String categoryName;
    @Element(name="callToAction")
    private String callToAction;
    @Element(name="bidRate")
    private String bidRate;
    @Element(name="campaignDisplayOrder")
    private String campaignDisplayOrder;
    @Element(name="averageRatingImageURL")
    private String averageRatingImageURL;
    @Element(name="rating")
    private String rating;
    @Element(name="productName")
    private String productName;
    @Element(name="productThumbnail")
    private String productThumbnail;
    @Element(name="clickProxyURL")
    private String clickProxyURL;
    @Element(name="creativeId")
    private String creativeId;
    @Element(name="homeScreen")
    private String homeScreen;
    @Element(name="impressionTrackingURL")
    private String impressionTrackingURL;
    @Element(name="isRandomPick")
    private String isRandomPick;
    @Element(name="numberOfRatings")
    private String numberOfRatings;
    @Element(name="minOSVersion",required = false)
    private String minOSVersion;

    protected Ad(Parcel in) {
        campaignId = in.readString();
        appId = in.readString();
        campaignTypeId = in.readString();
        productDescription = in.readString();
        productId = in.readString();
        categoryName = in.readString();
        callToAction = in.readString();
        bidRate = in.readString();
        campaignDisplayOrder = in.readString();
        averageRatingImageURL = in.readString();
        rating = in.readString();
        productName = in.readString();
        productThumbnail = in.readString();
        clickProxyURL = in.readString();
        creativeId = in.readString();
        homeScreen = in.readString();
        impressionTrackingURL = in.readString();
        isRandomPick = in.readString();
        numberOfRatings = in.readString();
        minOSVersion = in.readString();
    }

    public static final Creator<Ad> CREATOR = new Creator<Ad>() {
        @Override
        public Ad createFromParcel(Parcel in) {
            return new Ad(in);
        }

        @Override
        public Ad[] newArray(int size) {
            return new Ad[size];
        }
    };

    public String getCampaignId ()
    {
        return campaignId;
    }

    public void setCampaignId (String campaignId)
    {
        this.campaignId = campaignId;
    }

    public String getAppId ()
    {
        return appId;
    }

    public void setAppId (String appId)
    {
        this.appId = appId;
    }

    public String getCampaignTypeId ()
    {
        return campaignTypeId;
    }

    public void setCampaignTypeId (String campaignTypeId)
    {
        this.campaignTypeId = campaignTypeId;
    }

    public String getProductDescription ()
    {
        return productDescription;
    }

    public void setProductDescription (String productDescription)
    {
        this.productDescription = productDescription;
    }

    public String getProductId ()
    {
        return productId;
    }

    public void setProductId (String productId)
    {
        this.productId = productId;
    }

    public String getCategoryName ()
    {
        return categoryName;
    }

    public void setCategoryName (String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getCallToAction ()
    {
        return callToAction;
    }

    public void setCallToAction (String callToAction)
    {
        this.callToAction = callToAction;
    }

    public String getBidRate ()
    {
        return bidRate;
    }

    public void setBidRate (String bidRate)
    {
        this.bidRate = bidRate;
    }

    public String getCampaignDisplayOrder ()
    {
        return campaignDisplayOrder;
    }

    public void setCampaignDisplayOrder (String campaignDisplayOrder)
    {
        this.campaignDisplayOrder = campaignDisplayOrder;
    }

    public String getAverageRatingImageURL ()
    {
        return averageRatingImageURL;
    }

    public void setAverageRatingImageURL (String averageRatingImageURL)
    {
        this.averageRatingImageURL = averageRatingImageURL;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getProductName ()
    {
        return productName;
    }

    public void setProductName (String productName)
    {
        this.productName = productName;
    }

    public String getProductThumbnail ()
    {
        return productThumbnail;
    }

    public void setProductThumbnail (String productThumbnail)
    {
        this.productThumbnail = productThumbnail;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [campaignId = "+campaignId+", appId = "+appId+", campaignTypeId = "+campaignTypeId+", productDescription = "+productDescription+", productId = "+productId+", categoryName = "+categoryName+", callToAction = "+callToAction+", bidRate = "+bidRate+", campaignDisplayOrder = "+campaignDisplayOrder+", averageRatingImageURL = "+averageRatingImageURL+", rating = "+rating+", productName = "+productName+", productThumbnail = "+productThumbnail+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(campaignId);
        dest.writeString(appId);
        dest.writeString(campaignTypeId);
        dest.writeString(productDescription);
        dest.writeString(productId);
        dest.writeString(categoryName);
        dest.writeString(callToAction);
        dest.writeString(bidRate);
        dest.writeString(campaignDisplayOrder);
        dest.writeString(averageRatingImageURL);
        dest.writeString(rating);
        dest.writeString(productName);
        dest.writeString(productThumbnail);
        dest.writeString(clickProxyURL);
        dest.writeString(creativeId);
        dest.writeString(homeScreen);
        dest.writeString(impressionTrackingURL);
        dest.writeString(isRandomPick);
        dest.writeString(numberOfRatings);
        dest.writeString(minOSVersion);
    }

    public Ad(){}
}
