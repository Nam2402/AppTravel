package com.example.nam.travel.views.location.allLocation;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

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
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_location);
        recyclerView = (RecyclerView) findViewById(R.id.rc_all_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newLocationPresenter= new NewLocationPresenter(this);
        getDataLocation();
        initCollapsingToolbar();


    }
    private void getDataLocation() {
        //get data place
        newLocationPresenter.getNewLocation();
    }
    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        setTitle(nameType);
        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
