package com.example.nam.travel.views.place;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.nam.travel.R;
import com.example.nam.travel.api.ApiClient;
import com.example.nam.travel.api.ApiImageClient;
import com.example.nam.travel.models.categoryPlace.CategoryResponseDTO;
import com.example.nam.travel.models.typePlace.TypeDTO;
import com.example.nam.travel.presenters.places.PlacePresenter;
import com.example.nam.travel.views.adapter.RecyclerViewDataAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class PlaceActivity extends AppCompatActivity implements IPlaceActivity {
    private ArrayList<CategoryResponseDTO> listCategoryResponseDTO;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private TypeDTO typeDTO;
    private String urlImage = "";
    private PlacePresenter placePresenter;
    private PlaceActivity seft = this;
    private Long idPlaceType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        // actionBar
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowCustomEnabled(true);
        }
        Intent intent = getIntent();
        idPlaceType = intent.getLongExtra("idType", 3L);
        this.mapped();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }


    private void mapped() {
        this.imageView = (ImageView) findViewById(R.id.toppicture);
        this.recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        placePresenter = new PlacePresenter(this);
        placePresenter.getPlaceCategory(idPlaceType);
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
