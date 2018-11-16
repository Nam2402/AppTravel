package com.example.nam.travel.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.listener.ItemClickListener;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nam on 11/3/2018.
 */

public class LocationMoreAdapter extends RecyclerView.Adapter<LocationMoreAdapter.ItemLocationHolder> {
    private List<BaseLocation> baseLocationArrayList;
    private Context mContext;


    public LocationMoreAdapter(List<BaseLocation> baseLocationArrayList, Context mContext) {
        this.baseLocationArrayList = baseLocationArrayList;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_item_location, null);
        ItemLocationHolder itemLocationHolder = new ItemLocationHolder(v);
        return itemLocationHolder;
    }

    @Override
    public void onBindViewHolder(ItemLocationHolder holder, int position) {
        BaseLocation itemModel = baseLocationArrayList.get(position);
        holder.tvTitle.setText(itemModel.getName());
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
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != baseLocationArrayList ? baseLocationArrayList.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView tvTitle;
        protected ImageView itemImage;
        protected TextView tvAddress;
        private ItemClickListener itemClickListener;
        public ItemLocationHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_all_location_name);
            this.itemImage = itemView.findViewById(R.id.img_all_location);
            itemView.setOnClickListener(this);
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