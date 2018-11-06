package com.example.nam.travel.views.location.allLocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nam.travel.R;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.presenters.newLocation.NewLocationPresenter;
import com.example.nam.travel.views.adapter.LocationMoreAdapter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import java.util.List;

public class AllLocationActivity extends AppCompatActivity implements IBaseLocation {
    private NewLocationPresenter newLocationPresenter;
    private RecyclerView recyclerView;
    private LocationMoreAdapter locationMoreAdapter;
    private List<BaseLocation> baseLocationList;

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
    public void getBaseLocationSuccess(List<BaseLocation> baseLocations) {
        this.baseLocationList = baseLocations;
        if (baseLocations != null) {
            locationMoreAdapter = new LocationMoreAdapter(baseLocations,getApplicationContext());
            recyclerView.setAdapter(locationMoreAdapter);
        }

    }



    @Override
    public void getBaseLocationFailure() {

    }


}
