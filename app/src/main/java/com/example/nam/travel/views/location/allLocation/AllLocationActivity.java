package com.example.nam.travel.views.location.allLocation;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.nam.travel.R;
import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.presenters.allLocationOfCategory.AllLocationPresenter;
import com.example.nam.travel.presenters.newLocation.NewLocationPresenter;
import com.example.nam.travel.views.adapter.LocationMoreAdapter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;

import java.util.List;

public class AllLocationActivity extends AppCompatActivity implements IAllLocationActivity {
    private Long idCat;
    private String nameCat;
    private AllLocationPresenter allLocationPresenter;
    private RecyclerView recyclerView;
    private LocationMoreAdapter locationMoreAdapter;
    private CategoryResponseDTO categoryResponseDTO;
    private List<BaseLocation> baseLocationList;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_location);
        Intent intent = getIntent();
        idCat = intent.getLongExtra("idCat", 0L);
        nameCat = intent.getStringExtra("nameCat");
        recyclerView = (RecyclerView) findViewById(R.id.rc_all_location);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        allLocationPresenter= new AllLocationPresenter(this);
        getDataLocation();
        initCollapsingToolbar();


    }
    private void getDataLocation() {
        //get data place
        allLocationPresenter.getAllLocation(idCat);
    }
    private void initCollapsingToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(nameCat);
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
    public void getAllLocationSuccess(CategoryResponseDTO categoryResponseDTO) {
        this.categoryResponseDTO = categoryResponseDTO;
        if (categoryResponseDTO != null) {
            baseLocationList = categoryResponseDTO.getListLocationOfCategory();
            locationMoreAdapter = new LocationMoreAdapter(baseLocationList,getApplicationContext());
            recyclerView.setAdapter(locationMoreAdapter);
        }

    }



    @Override
    public void getAllLocationFailure() {

    }


}
