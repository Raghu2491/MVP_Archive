package com.example.raghu_gowda.mvp_practise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Service.CategoryServices;
import com.example.raghu_gowda.mvp_practise.Service.CategoryViewInterface;
import com.example.raghu_gowda.mvp_practise.application.CategoryApplication;
import com.example.raghu_gowda.mvp_practise.base.CategoryPresenter;

import javax.inject.Inject;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements CategoryViewInterface {

    @Inject
    CategoryServices categoryServices;

    private CategoryPresenter categoryPresenter;

    public static final String API_KEY="2f43365b380316d3a234157ae5e31";
    public String group_urlname="ny-tech";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolveDependencies();

        categoryPresenter=new CategoryPresenter(MainActivity.this);
        categoryPresenter.onCreate();
    }

    private void resolveDependencies() {
        ((CategoryApplication) getApplication())
                .getApiComponent()
                .inject(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        categoryPresenter.onResume();
        categoryPresenter.fetchCategories();

    }

    @Override
    public void completed() {
        Log.d("$$$$$","completed#####");

    }

    @Override
    public void onError(String message) {
        Log.d("$$$$$",message);
    }

    @Override
    public void onCategory(Category category) {
        Log.d("$$$$$","#####");
        System.out.println("---->"+category);
    }

    @Override
    public Observable<Category> getCategory() {
        return categoryServices.getCategory(API_KEY,group_urlname);
    }
}
