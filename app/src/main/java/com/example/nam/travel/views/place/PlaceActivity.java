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
        this.getPlaceCategory();

    }


    private void mapped() {
        this.imageView = (ImageView) findViewById(R.id.toppicture);
        this.recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        placePresenter = new PlacePresenter(this);
        placePresenter.getPlaceCategory();
    }


    @Override
    public void getPlaceSuccess(List<CategoryResponseDTO> categoryPlaceData) {

    }

    @Override
    public void getPlaceFailure() {

    }


    public TypeResponse fakeReturnValue() {
        Picture picture = new Picture(1,"caurong.jpg","caurong.jpg",1L);
        List<Picture> pictureList = new ArrayList<>();
        pictureList.add(picture);
        LocationForType locationForType = new LocationForType(1,"Dia diem 1","Dia diem 1",pictureList);
        LocationForType locationForType1 = new LocationForType(1,"Dia diem 2","Dia diem 2",pictureList);
//        LocationForType locationForType3 = new LocationForType(1,"Dia diem 1","Dia diem 1",pictureList);
//        LocationForType locationForType4 = new LocationForType(1,"Dia diem 2","Dia diem 2",pictureList);
//        LocationForType locationForType5 = new LocationForType(1,"Dia diem 1","Dia diem 1",pictureList);
//        LocationForType locationForType6 = new LocationForType(1,"Dia diem 2","Dia diem 2",pictureList);
//        LocationForType locationForType7 = new LocationForType(1,"Dia diem 1","Dia diem 1",pictureList);
//        LocationForType locationForType8 = new LocationForType(1,"Dia diem 2","Dia diem 2",pictureList);
        List<LocationForType> locationForTypeList = new ArrayList<>();
        locationForTypeList.add(locationForType);
//         locationForTypeList.add(locationForType1);
//        locationForTypeList.add(locationForType3);
//        locationForTypeList.add(locationForType4);
//        locationForTypeList.add(locationForType5);
//        locationForTypeList.add(locationForType6);
//        locationForTypeList.add(locationForType7);
//        locationForTypeList.add(locationForType8);
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO(1L,"Category 1",locationForTypeList);
        CategoryResponseDTO categoryResponseDTO1 = new CategoryResponseDTO(1L,"Category 2",locationForTypeList);
        CategoryResponseDTO categoryResponseDTO2 = new CategoryResponseDTO(1L,"Category 3",locationForTypeList);
        ArrayList<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
        categoryResponseDTOList.add(categoryResponseDTO);
        categoryResponseDTOList.add(categoryResponseDTO1);
        categoryResponseDTOList.add(categoryResponseDTO2);

        TypeDTO typeDTO = new TypeDTO(locationForType,categoryResponseDTOList);
        TypeResponse typeResponse = new TypeResponse(200,"Ok",typeDTO);
        return typeResponse;

    }
    public void getPlaceCategory() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        TypeResponse typeResponse = fakeReturnValue();
//        if(typeResponse.getResult_code() == 200) {
//            listCategoryResponseDTO = typeResponse.getTypeDTO().getListCategoryResponse();
//        }
//        this.recyclerView.setHasFixedSize(true);
//        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this.listCategoryResponseDTO, this);
//        this.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        this.recyclerView.setAdapter(adapter);


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TypeResponse> call = apiService.getNameCategory();
        call.enqueue(new Callback<TypeResponse>() {
            @Override
            public void onResponse(Call<TypeResponse> call, Response<TypeResponse> response) {
                if (response.code() >= 300) {
                    Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
                } else if (response.code() >= 200) {
                    TypeResponse typeResponse = response.body();
                    if (typeResponse.getResult_code() == 200) {

                        typeDTO = response.body().getTypeDTO();

                        System.out.println(typeDTO.toString());

                        if(typeDTO.getTopLocationOfType() != null && typeDTO.getTopLocationOfType().getPictureList().size() > 0) {
                            urlImage = typeDTO.getTopLocationOfType().getPictureList().get(0).getImage();
                            urlImage = ApiClient.BASE_URL + "/image/" + urlImage;
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
                } else {
                    Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<TypeResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Failure", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
