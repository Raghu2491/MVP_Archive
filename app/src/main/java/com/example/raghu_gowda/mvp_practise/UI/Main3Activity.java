package com.example.raghu_gowda.mvp_practise.UI;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.raghu_gowda.mvp_practise.Model.Ad;
import com.example.raghu_gowda.mvp_practise.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main3Activity extends AppCompatActivity {
    Ad _ad;

    @Bind(R.id.img)
    ImageView poster;
    @Bind(R.id.moviename)
    TextView name;
    @Bind(R.id.descrip)
    TextView descrip;
    @Bind(R.id.ratingText)
    TextView ratingText;
    @Bind(R.id.movierating)
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);

        _ad=getIntent().getParcelableExtra("Ads");
        Glide.with(Main3Activity.this)
                .load(_ad.getProductThumbnail())
                .into(poster);
        name.setText(_ad.getProductName());
        descrip.setText(_ad.getProductDescription());
        ratingText.setText(_ad.getRating());

        Double rates= Double.valueOf(_ad.getRating());
        ratingBar.setRating(rates.floatValue() / 2);

    }

}
