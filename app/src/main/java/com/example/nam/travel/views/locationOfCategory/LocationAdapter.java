package com.example.nam.travel.views.locationOfCategory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.models.locationOfPlaceCategory.Location;

import java.util.List;

/**
 * Created by Nam on 10/20/2018.
 */

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    List<Location> locations;
    private int rowLayout;
    private Context context;



    public static class LocationViewHolder extends RecyclerView.ViewHolder {
        LinearLayout categoryLayout;
        ImageView imageView;
        TextView itemTitle;




        public LocationViewHolder(View v) {
            super(v);
            categoryLayout = (LinearLayout) v.findViewById(R.id.layout_location);
            imageView = (ImageView) v.findViewById(R.id.itemImage);
            itemTitle = (TextView) v.findViewById(R.id.tvTitle);

        }
    }

    public LocationAdapter(List<Location> locations, int rowLayout, Context context) {
        this.locations = locations;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new LocationViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LocationViewHolder holder, final int position) {
        holder.itemTitle.setText(locations.get(position).getName());

    }

    @Override
    public int getItemCount() {
//        return locations.size();
        return (null != locations ? locations.size() : 0);
    }
}
