package com.example.raghu_gowda.mvp_practise.Service;


import com.example.raghu_gowda.mvp_practise.Model.Category;

import rx.Observable;

public interface CategoryViewInterface {
    void completed();
    void onError(String message);
    void onCategory(Category category);
    Observable<Category> getCategory();
}
