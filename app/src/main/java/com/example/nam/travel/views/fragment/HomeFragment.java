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
import com.example.nam.travel.models.newLocation.NewLocation;
import com.example.nam.travel.presenters.newLocation.NewLocationPresenter;
import com.example.nam.travel.views.adapter.NewLocationAdapter;
import com.example.nam.travel.views.adapter.RecommendLocationAdapter;
import com.example.nam.travel.views.newLocation.INewLocation;
import com.example.nam.travel.views.place.PlaceActivity;

import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener , INewLocation {
  Button btnPlace, btnEat, btnRest,btnShopping;
  private NewLocationPresenter newLocationPresenter;
  private RecyclerView recyclerView;
  private RecommendLocationAdapter recommendLocationAdapter;
  private List<NewLocation> newLocationList;

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
      newLocationPresenter= new NewLocationPresenter(this);
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
    switch (view.getId()){
      case R.id.btn_place:
        startActivity(new Intent(getActivity(),PlaceActivity.class));
        break;
      case R.id.btn_eat:
        startActivity(new Intent(getActivity(), PlaceActivity.class));
        break;
      case  R.id.btn_rest:
        startActivity(new Intent(getActivity(), PlaceActivity.class));
        break;
      case R.id.btn_shopping:
        startActivity(new Intent(getActivity(), PlaceActivity.class));
        break;

    }

  }

  private void getDataLocation() {
    //get data place
    newLocationPresenter.getNewLocation();
  }



  @Override
  public void getNewLocationSuccess(List<NewLocation> newLocations) {
    this.newLocationList = newLocations;
    if (newLocations != null) {
      recommendLocationAdapter = new RecommendLocationAdapter(newLocations,getContext());
      recyclerView.setAdapter(recommendLocationAdapter);
    }

  }



  @Override
  public void getNewLocationFailure() {

  }
}
