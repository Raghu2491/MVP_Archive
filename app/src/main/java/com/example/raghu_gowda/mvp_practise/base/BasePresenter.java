package com.example.raghu_gowda.mvp_practise.base;


import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
public class BasePresenter implements Presenter {

    private CompositeSubscription compositeSubscription;

    @Override
    public void onCreate() {


    }

    @Override
    public void onResume() {
        resolveSubscription();
    }

    private CompositeSubscription resolveSubscription() {
        if(compositeSubscription==null||compositeSubscription.isUnsubscribed()){
            compositeSubscription=new CompositeSubscription();
        }
        return compositeSubscription;
    }

    @Override
    public void onDestroy() {
        unsubscribeAll();
    }

    @Override
    public void onPause() {

    }

    protected void unsubscribeAll() {
        if(compositeSubscription!=null){
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
    }

    protected  <E> void subscribe(Observable<E> observable, AdPresenter observer){
        Subscription subscription=
                observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .subscribe((Observer<? super E>) observer);

        resolveSubscription().add(subscription);
    }
}
