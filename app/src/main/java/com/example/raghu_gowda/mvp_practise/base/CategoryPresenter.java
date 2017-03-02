package com.example.raghu_gowda.mvp_practise.base;


import android.util.Log;

import com.example.raghu_gowda.mvp_practise.Model.Category;
import com.example.raghu_gowda.mvp_practise.Service.CategoryViewInterface;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CategoryPresenter extends BasePresenter implements Observer<Category> {

    private CategoryViewInterface categoryViewInterface;

    public CategoryPresenter(CategoryViewInterface categoryViewInterface) {
        this.categoryViewInterface = categoryViewInterface;
    }



    @Override
    public void onError(Throwable e) {
        categoryViewInterface.onError(e.getMessage());
    }

    @Override
    public void onComplete() {
        categoryViewInterface.completed();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Category category) {
        categoryViewInterface.onCategory(category);
    }

    public void fetchCategories(){
        unsubscribeAll();
        subscribe(categoryViewInterface.getCategory(),CategoryPresenter.this);
    }


}
