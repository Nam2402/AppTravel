package com.example.nam.travel.views.place;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nam.travel.R;
import com.example.nam.travel.models.categoryPlace.CategoryPlace;
import com.example.nam.travel.views.locationOfCategory.LocationAdapter;

import java.util.List;

/**
 * Created by Nam on 10/18/2018.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    List<CategoryPlace> categoryPlaces;
    private int rowLayout;
    private Context context;
    private RecyclerView.RecycledViewPool recycledViewPool;



    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        LinearLayout categoryLayout;
        TextView itemTitle;
        Button btnMore;
        protected RecyclerView recyclerView;



        public PlaceViewHolder(View v) {
            super(v);
            categoryLayout = (LinearLayout) v.findViewById(R.id.category_layout);
            itemTitle = (TextView) v.findViewById(R.id.itemTitle);
            recyclerView = itemView.findViewById(R.id.recycler_view_list);
            btnMore = (Button) v.findViewById(R.id.btnMore);
        }
    }

    public PlaceAdapter(List<CategoryPlace> categoryPlaces, int rowLayout, Context context) {
        this.categoryPlaces = categoryPlaces;
        this.rowLayout = rowLayout;
        this.context = context;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public PlaceAdapter.PlaceViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PlaceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PlaceViewHolder holder, final int position) {
        holder.itemTitle.setText(categoryPlaces.get(position).getName());
        List location = categoryPlaces.get(position).getLocationList();
        LocationAdapter adapter = new LocationAdapter(location, rowLayout,context);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setRecycledViewPool(recycledViewPool);

    }

    @Override
    public int getItemCount() {
        return categoryPlaces.size();
    }
}
