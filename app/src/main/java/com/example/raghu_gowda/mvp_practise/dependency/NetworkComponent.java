package com.example.raghu_gowda.mvp_practise.dependency;


import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    Retrofit retrofit();
}
