package com.example.nam.travel.views.location.allLocation;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nam.travel.R;
import com.example.nam.travel.models.newLocation.NewLocation;
import com.example.nam.travel.presenters.newLocation.NewLocationPresenter;
import com.example.nam.travel.views.adapter.LocationMoreAdapter;
import com.example.nam.travel.views.adapter.NewLocationAdapter;
import com.example.nam.travel.views.newLocation.INewLocation;
import com.example.nam.travel.views.place.IPlaceActivity;

import java.util.List;

public class AllLocationActivity extends AppCompatActivity implements INewLocation {
    private NewLocationPresenter newLocationPresenter;
    private RecyclerView recyclerView;
    private LocationMoreAdapter locationMoreAdapter;
    private List<NewLocation> newLocationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_location);
        recyclerView = (RecyclerView) findViewById(R.id.rc_all_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newLocationPresenter= new NewLocationPresenter(this);
        getDataLocation();

    }
    private void getDataLocation() {
        //get data place
        newLocationPresenter.getNewLocation();
    }

    @Override
    public void getNewLocationSuccess(List<NewLocation> newLocations) {
        this.newLocationList = newLocations;
        if (newLocations != null) {
            locationMoreAdapter = new LocationMoreAdapter(newLocations,getApplicationContext());
            recyclerView.setAdapter(locationMoreAdapter);
        }

    }



    @Override
    public void getNewLocationFailure() {

    }


}
