package com.example.nam.travel.views.location.detailLocation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nam.travel.MainActivity;
import com.example.nam.travel.R;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.presenters.loveLocation.LoveLocationPresenter;
import com.example.nam.travel.views.adapter.LoveLocationAdapter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import java.util.List;

public class LoveLocationActivity extends AppCompatActivity implements IBaseLocation {
    private LoveLocationPresenter loveLocationPresenter;
    private RecyclerView recyclerView;
    private LoveLocationAdapter loveLocationAdapter;
    private List<BaseLocation> baseLocationList;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_location);
        recyclerView = (RecyclerView) findViewById(R.id.rc_love_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loveLocationPresenter= new LoveLocationPresenter(this);
        initCollapsingToolbar();
        getDataLocation();

    }
    private void getDataLocation() {
        //get data place
        String token = MainActivity.token;
        if (token != null) {
            loveLocationPresenter.getLoveLocation(token);
        } else {

        }
    }
    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Yêu thích");
        //Display back home button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            loveLocationAdapter = new LoveLocationAdapter(baseLocations,getApplicationContext());
            recyclerView.setAdapter(loveLocationAdapter);
        }

    }


    @Override
    public void getBaseLocationFailure() {

    }


}
