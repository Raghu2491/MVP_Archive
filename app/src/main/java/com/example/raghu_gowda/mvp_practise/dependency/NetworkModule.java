package com.example.raghu_gowda.mvp_practise.dependency;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Singleton
@Module
public class NetworkModule {

    private String BASE_URL;

    public NetworkModule(String BASE_URL) {
        this.BASE_URL = BASE_URL;
    }
    @Provides @Singleton
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }
    @Provides @Singleton
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides @Singleton
    public Retrofit provideRetrofit(RxJavaCallAdapterFactory rxJavaCallAdapterFactory,GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(gsonConverterFactory)
                    .build();
    }
}
