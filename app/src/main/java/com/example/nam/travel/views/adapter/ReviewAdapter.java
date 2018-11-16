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
import com.example.nam.travel.models.location.Picture;
import com.example.nam.travel.models.review.OnLoadMoreListener;
import com.example.nam.travel.models.review.Review;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Nam on 11/5/2018.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ItemLocationHolder> {
    private List<Review> listReview;
    private Context mContext;
//    private OnLoadMoreListener mOnLoadMoreListener;
//
//    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
//        this.mOnLoadMoreListener = mOnLoadMoreListener;
//    }

    public ReviewAdapter(List<Review> listReview, Context mContext) {
        this.listReview = listReview;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, null);
        ItemLocationHolder itemLocationHolder = new ItemLocationHolder(v);
        return itemLocationHolder;
    }

    @Override
    public void onBindViewHolder(ItemLocationHolder holder, int position) {
        Review review = listReview.get(position);
        String urlImage = "";
        holder.txtUsername.setText(review.getNameUser());
        String regrex = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(regrex);

        holder.txtDateReview.setText(simpleDateFormat.format(review.getDateReview()));
        holder.txtDetailReview.setText(review.getContent());
        holder.ratingBar.setRating(review.getScore());
//        urlImage = picture.getImage();
//        urlImage = ApiClient.BASE_URL + "/downloadFile/" + urlImage;
//
//        Picasso.with(mContext).load(urlImage).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return (null != listReview ? listReview.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder {
        protected TextView txtUsername, txtDateReview, txtDetailReview;
        protected RatingBar ratingBar;
        public ItemLocationHolder(View itemView) {
            super(itemView);
            txtUsername = itemView.findViewById(R.id.tv_username);
            txtDateReview = itemView.findViewById(R.id.tv_date_review);
            txtDetailReview = itemView.findViewById(R.id.tv_detail_review);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
