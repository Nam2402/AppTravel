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
import com.example.nam.travel.listener.ItemClickListener;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Nam on 11/5/2018.
 */

public class HighlightLocationAdapter extends RecyclerView.Adapter<HighlightLocationAdapter.ItemLocationHolder> {
    private List<BaseLocation> baseLocationArrayList;
    private Context mContext;


    public HighlightLocationAdapter(List<BaseLocation> baseLocationArrayList, Context mContext) {
        this.baseLocationArrayList = baseLocationArrayList;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_highlight_location, null);
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

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Long idLocation = baseLocationArrayList.get(position).getId();
                Intent intent = new Intent(mContext, DetailLocationActivity.class);
                intent.putExtra("idLocation", idLocation);
                mContext.startActivity(intent);
            }
        });
    }

    public float getRating(BigDecimal sumRating, long numRating) {
        if(numRating == 0) return 0f;
        return sumRating.floatValue() / numRating;
    }

    @Override
    public int getItemCount() {
        return (null != baseLocationArrayList ? baseLocationArrayList.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView tvTitle;
        protected ImageView itemImage;
        protected TextView tvCount;
        protected RatingBar ratingBar;
        private ItemClickListener itemClickListener;
        public ItemLocationHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.itemImage = itemView.findViewById(R.id.image_location);
            this.ratingBar = itemView.findViewById(R.id.ratingBar);
            this.tvCount = itemView.findViewById(R.id.count);

            itemView.setOnClickListener(this);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(mContext, DetailLocationActivity.class);
//                    mContext.startActivity(intent);
//                }
//            });
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
}
