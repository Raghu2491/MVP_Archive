package com.example.raghu_gowda.mvp_practise.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.raghu_gowda.mvp_practise.Model.Ads;
import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Model.MyPojo;
import com.example.raghu_gowda.mvp_practise.R;
import com.example.raghu_gowda.mvp_practise.Service.AdService;
import com.example.raghu_gowda.mvp_practise.Service.AdsViewInterface;
import com.example.raghu_gowda.mvp_practise.Service.CategoryServices;
import com.example.raghu_gowda.mvp_practise.Service.CategoryViewInterface;
import com.example.raghu_gowda.mvp_practise.application.CategoryApplication;
import com.example.raghu_gowda.mvp_practise.base.AdPresenter;
import com.example.raghu_gowda.mvp_practise.base.CategoryPresenter;

import javax.inject.Inject;

import retrofit2.http.Query;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements CategoryViewInterface,AdsViewInterface {

    private static final String TAG = MainActivity.class.getSimpleName();
    String id="236";
    String password="OVUJ1DJN";
    String siteId="4288";
    String deviceId="4230";
    String sessionId="techtestsession";
    String totalCampaignsRequested="10";


    @Inject
    AdService adService;

    //private CategoryPresenter categoryPresenter;
    private AdPresenter adPresenter;

    public static final String API_KEY="2f43365b380316d3a234157ae5e31";
    public String group_urlname="ny-tech";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolveDependencies();

        adPresenter=new AdPresenter(MainActivity.this);
        adPresenter.onCreate();


    }

    private void resolveDependencies() {
        ((CategoryApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        categoryPresenter.onResume();
//        categoryPresenter.fetchCategories();
        adPresenter.onResume();
        adPresenter.fetchAds();
    }

    @Override
    public void completed() {

    }

    @Override
    public void onError(String message) {
        Log.e(TAG,message);
    }

    @Override
    public void onAds(Ads mypojo) {
        System.out.println("------->"+mypojo);
    }


    @Override
    public void onCategory(Category category) {

    }

    @Override
    public Observable<Category> getCategory() {
        return null;
        //return categoryServices.getCategory(API_KEY,group_urlname);
    }
    @Override
    public Observable<Ads> getAds() {
        return adService.getAds(id,
                password,
                siteId,
                deviceId,
                sessionId,
                totalCampaignsRequested
                );
    }

}
