package com.example.nam.travel.views.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.models.newLocation.NewLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam on 11/1/2018.
 */

public class NewLocationAdapter extends RecyclerView.Adapter<NewLocationAdapter.ItemLocationHolder> {
    private List<NewLocation> newLocationArrayList;
    private Context mContext;


    public NewLocationAdapter(List<NewLocation> newLocationArrayList, Context mContext) {
        this.newLocationArrayList = newLocationArrayList;
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
            this.tvTitle = itemView.findViewById(R.id.tv_title);
            this.itemImage = itemView.findViewById(R.id.image_location);
            this.tvDetail = itemView.findViewById(R.id.address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
