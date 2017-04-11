package com.example.raghu_gowda.mvp_practise.Service;

import com.example.raghu_gowda.mvp_practise.Model.Ads;
import com.example.raghu_gowda.mvp_practise.Model.MyPojo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Admin on 4/10/17.
 */

public interface AdService {
    @GET("/getAds/")
    Observable<Ads> getAds(
            @Query("id") String id,
            @Query("password") String password,
            @Query("siteId") String siteId,
            @Query("deviceId") String deviceId,
            @Query("sessionId") String sessionId,
            @Query("totalCampaignsRequested") String totalCampaignsRequested
    );
}
