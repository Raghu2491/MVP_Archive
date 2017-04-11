package com.example.raghu_gowda.mvp_practise.Service;


import com.example.raghu_gowda.mvp_practise.Model.Category;

import dagger.Component;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface CategoryServices {
//id=236&password=OVUJ1DJN&siteId=4288&deviceId=4230&sessionId=techtestsession&totalCampaignsRequested=10
    @GET("/2/categories?&sign=true")
    Observable<Category> getCategory(@Query("key") String api_key, @Query("group_urlname") String url_name);
}