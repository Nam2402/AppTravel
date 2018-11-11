package com.example.nam.travel.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.models.location.Picture;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nam on 11/5/2018.
 */

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ItemLocationHolder> {
    private List<Picture> listPicture;
    private Context mContext;


    public PictureAdapter(List<Picture> listPicture, Context mContext) {
        this.listPicture = listPicture;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_picture, null);
        ItemLocationHolder itemLocationHolder = new ItemLocationHolder(v);
        return itemLocationHolder;
    }

    @Override
    public void onBindViewHolder(ItemLocationHolder holder, int position) {
        Picture picture = listPicture.get(position);
        String urlImage = "";

        urlImage = picture.getImage();
        urlImage = ApiClient.BASE_URL + "/downloadFile/" + urlImage;

        Picasso.with(mContext).load(urlImage).into(holder.itemImage);
    }

    public float getRating(BigDecimal sumRating, long numRating) {
        if(numRating == 0) return 0f;
        return sumRating.floatValue() / numRating;
    }

    @Override
    public int getItemCount() {
        return (null != listPicture ? listPicture.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder {
        protected ImageView itemImage;

        public ItemLocationHolder(View itemView) {
            super(itemView);
            this.itemImage = itemView.findViewById(R.id.image_location);
        }
    }
}
