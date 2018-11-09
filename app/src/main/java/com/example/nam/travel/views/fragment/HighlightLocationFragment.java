package com.example.nam.travel.views.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nam.travel.R;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.presenters.highlightLocation.HighlightLocationPresenter;
import com.example.nam.travel.views.adapter.HighlightLocationAdapter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import java.util.List;


public class HighlightLocationFragment extends Fragment implements IBaseLocation {
    private HighlightLocationPresenter highlightLocationPresenter;
    private RecyclerView recyclerView;
    private HighlightLocationAdapter highlightLocationAdapter;
    private List<BaseLocation> baseLocationList;
    public HighlightLocationFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_highlight_location, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_location);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        highlightLocationPresenter= new HighlightLocationPresenter(this);
        getDataLocation();
        return view;
    }
    private void getDataLocation() {
        //get data place
        highlightLocationPresenter.getHighlightLocation();
    }



    @Override
    public void getBaseLocationSuccess(List<BaseLocation> baseLocations) {
        this.baseLocationList = baseLocations;
        if (baseLocations != null) {
            highlightLocationAdapter = new HighlightLocationAdapter(baseLocations,getContext());
            recyclerView.setAdapter(highlightLocationAdapter);
        }

    }



    @Override
    public void getBaseLocationFailure() {

    }

}
