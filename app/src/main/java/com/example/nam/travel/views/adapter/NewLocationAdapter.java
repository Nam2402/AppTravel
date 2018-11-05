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
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public class NewLocationAdapter extends RecyclerView.Adapter<NewLocationAdapter.ItemLocationHolder> {
    private List<BaseLocation> baseLocationArrayList;
    private Context mContext;


    public NewLocationAdapter(List<BaseLocation> baseLocationArrayList, Context mContext) {
        this.baseLocationArrayList = baseLocationArrayList;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_new_location, null);
        ItemLocationHolder itemLocationHolder = new ItemLocationHolder(v);
        return itemLocationHolder;
    }

    @Override
    public void onBindViewHolder(ItemLocationHolder holder, int position) {
        BaseLocation itemModel = baseLocationArrayList.get(position);
        holder.tvTitle.setText(itemModel.getName());

        holder.tvCount.setText(itemModel.getNumRating() + " đánh giá");
        float rating = getRating(itemModel.getSumRating(), itemModel.getNumRating());
        holder.ratingBar.setRating(rating);

        String urlImage = "";
        if(itemModel.getPictureList().size() > 0) {
            urlImage = itemModel.getPictureList().get(0).getImage();
            urlImage = ApiClient.BASE_URL + "/downloadFile/" + urlImage;
        } else
        {
            urlImage = ApiImageClient.URL_IMAGE_DEFAULT;
        }

        Picasso.with(mContext).load(urlImage).into(holder.itemImage);
    }

    public float getRating(BigDecimal sumRating, long numRating) {
        if(numRating == 0) return 0f;
        return sumRating.floatValue() / numRating;
    }

    @Override
    public int getItemCount() {
        return (null != baseLocationArrayList ? baseLocationArrayList.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        protected ImageView itemImage;
        protected TextView tvCount;
        protected RatingBar ratingBar;

        public ItemLocationHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.itemImage = itemView.findViewById(R.id.image_location);
            this.ratingBar = itemView.findViewById(R.id.ratingBar);
            this.tvCount = itemView.findViewById(R.id.count);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailLocationActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}