package com.example.raghu_gowda.mvp_practise.Service;

import com.example.raghu_gowda.mvp_practise.Model.Ads;
import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Model.MyPojo;

import rx.Observable;

/**
 * Created by Admin on 4/10/17.
 */

public interface AdsViewInterface {
    void completed();
    void onError(String message);
    void onAds(Ads category);
    Observable<Ads> getAds();
}
