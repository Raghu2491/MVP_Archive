package com.example.raghu_gowda.mvp_practise.dependency;


import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Service.AdService;
import com.example.raghu_gowda.mvp_practise.Service.CategoryServices;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {


    @Provides
    @Customscope
    AdService provideAdService(Retrofit retrofit){
        return retrofit.create(AdService.class);
    }
}
