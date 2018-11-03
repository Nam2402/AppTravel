package com.example.nam.travel.views.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.models.newLocation.NewLocation;
import com.example.nam.travel.views.location.detailLocation.DetailLocationActivity;

import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public class RecommendLocationAdapter extends RecyclerView.Adapter<RecommendLocationAdapter.ItemLocationHolder> {
    private List<NewLocation> newLocationArrayList;
    private Context mContext;


    public RecommendLocationAdapter(List<NewLocation> newLocationArrayList, Context mContext) {
        this.newLocationArrayList = newLocationArrayList;
        this.mContext = mContext;
    }



    @Override
    public ItemLocationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend_location, null);
        ItemLocationHolder itemLocationHolder = new ItemLocationHolder(v);
        return itemLocationHolder;
    }

    @Override
    public void onBindViewHolder(ItemLocationHolder holder, int position) {
        NewLocation itemModel = newLocationArrayList.get(position);
        holder.tvTitle.setText(itemModel.getName());
    }

    @Override
    public int getItemCount() {
        return (null != newLocationArrayList ? newLocationArrayList.size() : 0);
    }

    public class ItemLocationHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        protected ImageView itemImage;
        protected TextView tvDetail;

        public ItemLocationHolder(View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.tv_location_name);
            this.itemImage = itemView.findViewById(R.id.img_rc_location);
            this.tvDetail = itemView.findViewById(R.id.tv_location_address);
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
