package com.example.nam.travel.views.place;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.PlaceCategoriesModel;
import com.example.nam.travel.models.SingleItemModel;
import com.example.nam.travel.models.categoryPlace.CategoryPlace;
import com.example.nam.travel.models.categoryPlace.CategoryPlacesResponse;
import com.example.nam.travel.models.locationOfPlaceCategory.Location;
import com.example.nam.travel.presenters.locationOfCategory.LocationPresenter;
import com.example.nam.travel.presenters.places.PlacePresenter;
import com.example.nam.travel.views.adapter.RecyclerViewDataAdapter;
import com.example.nam.travel.views.locationOfCategory.LocationAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaceActivity extends AppCompatActivity implements IPlaceActivity {
    private List<Location> locations;
    private PlacePresenter placePresenter;
    private LocationPresenter locationPresenter;
    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;
    private LocationAdapter locationAdapter;
    private List<CategoryPlace> categoryPlaceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        getDataPlace();

    }

    private void getDataPlace() {
        //get data place
        placePresenter.getPlaceCategory();
    }

    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        placePresenter = new PlacePresenter(this);
//        locationPresenter = new LocationPresenter(this);


    }


    @Override
    public void getPlaceSuccess(List<CategoryPlace> categoryPlaceData) {
        this.categoryPlaceList = categoryPlaceData;
        if (categoryPlaceData != null) {
            placeAdapter = new PlaceAdapter(categoryPlaceData, R.layout.item_place_type, getApplicationContext());
            recyclerView.setAdapter(placeAdapter);
        }
//        getLocationListInPlace();
    }

//    private void getLocationListInPlace() {
//        locationPresenter.getLocation();
//    }

    @Override
    public void getPlaceFailure() {
        Toast.makeText(getBaseContext(), "Get place Failure", Toast.LENGTH_SHORT).show();
    }



    @Override
    public void getLocationSuccess(List<Location> locationList) {
//        this.locations = locationList;
//        if (locationList != null) {
//            locationAdapter = new LocationAdapter(locationList, R.layout.activity_place_type, getApplicationContext());
//            recyclerView.setAdapter(placeAdapter);
//        }


    }

    @Override
    public void getLocationFailure() {

    }


}
