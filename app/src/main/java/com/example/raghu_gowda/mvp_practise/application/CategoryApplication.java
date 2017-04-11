package com.example.raghu_gowda.mvp_practise.application;


import android.app.Application;

import com.example.raghu_gowda.mvp_practise.Model.Constant;
import com.example.raghu_gowda.mvp_practise.dependency.Apicomponent;
import com.example.raghu_gowda.mvp_practise.dependency.DaggerApicomponent;
import com.example.raghu_gowda.mvp_practise.dependency.DaggerNetworkComponent;
import com.example.raghu_gowda.mvp_practise.dependency.NetworkComponent;
import com.example.raghu_gowda.mvp_practise.dependency.NetworkModule;

public class CategoryApplication extends Application{

    private Apicomponent apicomponent;
    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {

        apicomponent= DaggerApicomponent.builder()
                .networkComponent(getNetworkComponent())
                .build();

    }

    private NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();
    }

    public Apicomponent getApiComponent() {
        return apicomponent;
    }

}
