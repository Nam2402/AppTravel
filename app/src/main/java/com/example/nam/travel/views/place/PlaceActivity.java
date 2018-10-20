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
import com.example.nam.travel.presenters.places.PlacePresenter;
import com.example.nam.travel.views.adapter.RecyclerViewDataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaceActivity extends AppCompatActivity implements IPlaceActivity {
//    private ArrayList<PlaceCategoriesModel> allSampleData;
    private PlacePresenter placePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
//        init();
            getPlaceCategory();
//        allSampleData = new ArrayList<>();
//
//        createDummyData();

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(allSampleData, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
    }

    private void init() {
        placePresenter = new PlacePresenter(this);
        placePresenter.getPlaceCategory();
    }

//    private void createDummyData() {
//        for (int i = 1; i <= 5; i++) {
//            PlaceCategoriesModel dm = new PlaceCategoriesModel();
//            dm.setHeaderTitle("Categories " + i);
//            ArrayList<SingleItemModel> singleItemModels = new ArrayList<>();
//            for (int j = 1; j <= 10; j++) {
//                singleItemModels.add(new SingleItemModel("Name " + j, "URL " + j, "Aaaaaaaaaaaa"));
//            }
//            dm.setAllItemInSection(singleItemModels);
//            allSampleData.add(dm);
//        }
//
//    }


    @Override
    public void getPlaceSuccess(List<CategoryPlace> categoryPlaceData) {

    }

    @Override
    public void getPlaceFailure() {

    }

    public void getPlaceCategory() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<CategoryPlacesResponse> call = apiService.getNameCategory();
        call.enqueue(new Callback<CategoryPlacesResponse>() {
            @Override
            public void onResponse(Call<CategoryPlacesResponse> call, Response<CategoryPlacesResponse> response) {
                if (response.code() >= 300) {
                    Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
                } else if (response.code() >= 200) {
                    CategoryPlacesResponse categoryPlacesResponse = response.body();


                    if (categoryPlacesResponse.getResultCode() == 200) {
                        List<CategoryPlace> categoryPlaces = response.body().getData();
                        recyclerView.setAdapter(new PlaceAdapter(categoryPlaces,R.layout.item_place_type, getApplicationContext()));
//                        Toast.makeText(getBaseContext(), categoryPlacesResponse.getData().toString(), Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CategoryPlacesResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
