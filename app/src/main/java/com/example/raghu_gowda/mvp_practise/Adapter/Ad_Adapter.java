package com.example.raghu_gowda.mvp_practise.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.raghu_gowda.mvp_practise.Model.Ad;
import com.example.raghu_gowda.mvp_practise.Model.Ads;
import com.example.raghu_gowda.mvp_practise.R;
import com.example.raghu_gowda.mvp_practise.UI.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 4/10/17.
 */

public class Ad_Adapter extends RecyclerView.Adapter<Ad_Adapter.ViewHolder> {

    private final LayoutInflater inflator;
    private List<Ad> ads;
    OnEachcardSelected mlistener;


    public Ad_Adapter(OnEachcardSelected listener,LayoutInflater inflater){
        this.inflator=inflater;
        this.ads=new ArrayList<>();
        mlistener=listener;
    }

    @Override
    public Ad_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Ad_Adapter.ViewHolder(inflator.inflate(R.layout.item_ad,parent,false));
    }

    @Override
    public void onBindViewHolder(final Ad_Adapter.ViewHolder holder, int position) {
        Ad _ad=ads.get(position);
        holder.mText.setText(_ad.getProductName());
        Double rates= Double.valueOf(_ad.getRating());
        holder.vRatingbar.setRating(rates.floatValue() / 2);
        Glide.with(holder.itemView.getContext())
                .load(_ad.getProductThumbnail())
                .into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return ads.size();
    }

    public void newAds(Ads mAds) {
        //ads= mAds.getAd();
        ads.addAll(mAds.getAd());
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mText;
        public RatingBar vRatingbar;
        public ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            mText=(TextView)itemView.findViewById(R.id.description);
            vRatingbar= (RatingBar) itemView.findViewById(R.id.cardmovierating);
            icon= (ImageView) itemView.findViewById(R.id.moviecard);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mlistener.onCardClicked(getLayoutPosition(),ads.get(getAdapterPosition()));
        }


    }

    public interface OnEachcardSelected{
        void onCardClicked(int position,Ad _ad);
    }
}
