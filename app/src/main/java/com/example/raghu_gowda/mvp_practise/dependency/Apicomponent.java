package com.example.raghu_gowda.mvp_practise.dependency;


import com.example.raghu_gowda.mvp_practise.MainActivity;

import dagger.Component;

@Customscope
@Component(modules = {ApiModule.class}, dependencies = {NetworkComponent.class})
public interface Apicomponent {
    void inject(MainActivity mainActivity);

}
