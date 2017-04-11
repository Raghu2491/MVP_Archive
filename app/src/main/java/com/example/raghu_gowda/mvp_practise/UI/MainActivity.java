package com.example.raghu_gowda.mvp_practise.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raghu_gowda.mvp_practise.Adapter.Ad_Adapter;
import com.example.raghu_gowda.mvp_practise.Model.Ad;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.http.Query;
import rx.Observable;

public class MainActivity extends AppCompatActivity implements CategoryViewInterface,AdsViewInterface, Ad_Adapter.OnEachcardSelected {

    private static final String TAG = MainActivity.class.getSimpleName();
    String id="236";
    String password="OVUJ1DJN";
    String siteId="4288";
    String deviceId="4230";
    String sessionId="techtestsession";
    String totalCampaignsRequested="10";
    private AdPresenter adPresenter;
    private Ad_Adapter mAdapter;
    private ProgressDialog mDialog;


    @Inject
    AdService adService;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;


//    private CategoryPresenter categoryPresenter;
//    public static final String API_KEY="2f43365b380316d3a234157ae5e31";
//    public String group_urlname="ny-tech";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        resolveDependencies();
        configViews();

        adPresenter=new AdPresenter(MainActivity.this);
        adPresenter.onCreate();


    }

    private void configViews() {
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new Ad_Adapter(this,getLayoutInflater());
        recyclerView.setAdapter(mAdapter);

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
        mDialog=new ProgressDialog(MainActivity.this);
        mDialog.setIndeterminate(true);
        mDialog.setProgress(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle("Downloading");
        mDialog.setMessage("Please Wait...");
        mDialog.show();
    }

    @Override
    public void completed() {
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAds(Ads mAds) {
        mAdapter.newAds(mAds);
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

    @Override
    public void onCardClicked(int position,Ad name) {
        Intent intent=new Intent(MainActivity.this,Main3Activity.class);
        intent.putExtra("Ads",name);
        startActivity(intent);
    }
}
