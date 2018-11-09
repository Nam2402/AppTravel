package com.example.nam.travel.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nam.travel.R;
import com.example.nam.travel.constant.Constant;
import com.example.nam.travel.models.locationOfPlaceCategory.BaseLocation;
import com.example.nam.travel.presenters.recommendLocation.RecommendLocationPresenter;
import com.example.nam.travel.views.adapter.RecommendLocationAdapter;
import com.example.nam.travel.views.baseLocation.IBaseLocation;
import com.example.nam.travel.views.place.PlaceActivity;


import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener , IBaseLocation {
  Button btnPlace, btnEat, btnRest,btnShopping;
  private RecommendLocationPresenter recommendLocationPresenter;
  private RecyclerView recyclerView;
  private RecommendLocationAdapter recommendLocationAdapter;
  private List<BaseLocation> recommendLocations;

  public HomeFragment(){

  }
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);

    initControls(view);
    addEvents();

    recyclerView = (RecyclerView) view.findViewById(R.id.rc_location_recycler_view);
    recyclerView.setLayoutManager(new GridLayoutManager(getContext(),1));
    recommendLocationPresenter= new RecommendLocationPresenter(this);
    getDataLocation();


    return view;
  }



  public void initControls(View view){
    btnPlace =(Button) view.findViewById(R.id.btn_place);
    btnEat =(Button) view.findViewById(R.id.btn_eat);
    btnRest =(Button) view.findViewById(R.id.btn_rest);
    btnShopping =(Button) view.findViewById(R.id.btn_shopping);
  }

  public void addEvents(){
    btnPlace.setOnClickListener(this);
    btnEat.setOnClickListener(this);
    btnRest.setOnClickListener(this);
    btnShopping.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    Intent intent = new Intent(getActivity(), PlaceActivity.class);
    switch (view.getId()){
      case R.id.btn_place:
        intent.putExtra("idType", Constant.ID_TYPE_PLACE);
        startActivity(intent);
        break;
      case R.id.btn_eat:
        intent.putExtra("idType", Constant.ID_TYPE_EAT_DRINK);
        startActivity(intent);
        break;
      case  R.id.btn_rest:
        intent.putExtra("idType", Constant.ID_TYPE_REST);
        startActivity(intent);
        break;
      case R.id.btn_shopping:
        intent.putExtra("idType", Constant.ID_TYPE_SHOPPING);
        startActivity(intent);
        break;
    }
  }

  private void getDataLocation() {
    //get data place
    recommendLocationPresenter.getRecommendLocation();
  }



  @Override
  public void getBaseLocationSuccess(List<BaseLocation> recommendLocations) {
    this.recommendLocations = recommendLocations;
    if (recommendLocations != null) {
      recommendLocationAdapter = new RecommendLocationAdapter(recommendLocations,getContext());
      recyclerView.setAdapter(recommendLocationAdapter);
    }

  }



  @Override
  public void getBaseLocationFailure() {

  }
}