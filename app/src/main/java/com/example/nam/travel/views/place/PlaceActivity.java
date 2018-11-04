package com.example.nam.travel.views.place;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.api.ApiInterface;
import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;
import com.example.nam.travel.models.location.Picture;
import com.example.nam.travel.models.locationOfPlaceCategory.LocationForType;
import com.example.nam.travel.models.typePlace.TypeDTO;
import com.example.nam.travel.models.typePlace.TypeResponse;
import com.example.nam.travel.presenters.places.PlacePresenter;
import com.example.nam.travel.views.adapter.RecyclerViewDataAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PlaceActivity extends AppCompatActivity implements IPlaceActivity {
    private ArrayList<CategoryResponseDTO> listCategoryResponseDTO;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private TypeDTO typeDTO;
    private String urlImage = "";
    private PlacePresenter placePresenter;
    private PlaceActivity seft = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        this.mapped();

    }


    private void mapped() {
        this.imageView = (ImageView) findViewById(R.id.toppicture);
        this.recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        placePresenter = new PlacePresenter(this);
        placePresenter.getPlaceCategory();
    }


    @Override
    public void getPlaceSuccess(TypeDTO categoryPlaceData) {
        this.typeDTO = categoryPlaceData;
        if(typeDTO.getTopLocationOfType() != null && typeDTO.getTopLocationOfType().getPictureList().size() > 0) {
            urlImage = typeDTO.getTopLocationOfType().getPictureList().get(0).getImage();
            urlImage = ApiClient.BASE_URL + "/downloadFile/" + urlImage;
        } else
        {
            urlImage = ApiImageClient.URL_IMAGE_DEFAULT;
        }


        listCategoryResponseDTO = typeDTO.getListCategoryResponse();

        seft.recyclerView.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(seft.listCategoryResponseDTO, seft);
        seft.recyclerView.setLayoutManager(new LinearLayoutManager(seft, LinearLayoutManager.VERTICAL, false));
        seft.recyclerView.setAdapter(adapter);
        Picasso.with(seft).load(urlImage).into(imageView);
    }

    @Override
    public void getPlaceFailure() {
        Toast.makeText(getBaseContext(), "Get place Failure", Toast.LENGTH_SHORT).show();
    }
}
