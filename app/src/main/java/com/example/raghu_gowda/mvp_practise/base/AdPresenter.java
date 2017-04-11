package com.example.raghu_gowda.mvp_practise.base;

import com.example.raghu_gowda.mvp_practise.Model.Ads;
import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Model.MyPojo;
import com.example.raghu_gowda.mvp_practise.Service.AdsViewInterface;

import rx.Observer;

/**
 * Created by Admin on 4/10/17.
 */

public class AdPresenter extends BasePresenter implements Observer<Ads> {
    private AdsViewInterface adsViewInterface;

    public AdPresenter(AdsViewInterface adsViewInterface){
        this.adsViewInterface=adsViewInterface;
    }

    @Override
    public void onCompleted() {
        adsViewInterface.completed();
    }

    @Override
    public void onError(Throwable e) {
        adsViewInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(Ads myPojo) {
        adsViewInterface.onAds(myPojo);
    }
    public void fetchAds(){
        unsubscribeAll();
        subscribe(adsViewInterface.getAds(),AdPresenter.this);
    }
}
