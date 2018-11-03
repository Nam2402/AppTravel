package com.example.nam.travel.views.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nam.travel.R;
import com.example.nam.travel.models.newLocation.NewLocation;
import com.example.nam.travel.presenters.newLocation.NewLocationPresenter;
import com.example.nam.travel.views.adapter.NewLocationAdapter;
import com.example.nam.travel.views.newLocation.INewLocation;

import java.util.ArrayList;
import java.util.List;


public class NewLocationFragment extends Fragment implements INewLocation {
    private NewLocationPresenter newLocationPresenter;
    private RecyclerView recyclerView;
    private NewLocationAdapter newLocationAdapter;
    private List<NewLocation> newLocationList;
    public NewLocationFragment(){

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_location, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_location);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
        newLocationPresenter= new NewLocationPresenter(this);
        getDataLocation();

        return view;
    }
    private void getDataLocation() {
        //get data place
        newLocationPresenter.getNewLocation();
    }



    @Override
    public void getNewLocationSuccess(List<NewLocation> newLocations) {
        this.newLocationList = newLocations;
        if (newLocations != null) {
            newLocationAdapter = new NewLocationAdapter(newLocations,getContext());
            recyclerView.setAdapter(newLocationAdapter);
        }

    }



    @Override
    public void getNewLocationFailure() {

    }






}
