package com.example.nam.travel.views.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nam.travel.R;
import com.example.nam.travel.views.eat.EatActivity;
import com.example.nam.travel.views.place.PlaceActivity;
import com.example.nam.travel.views.rest.RestActivity;
import com.example.nam.travel.views.shopping.ShoppingActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {
  Button btnPlace, btnEat, btnRest,btnShopping;

  public HomeFragment(){

  }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_home, container, false);

      initControls(view);
      addEvents();




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
        startActivity(new Intent(getActivity(), EatActivity.class));
        break;
      case  R.id.btn_rest:
        startActivity(new Intent(getActivity(), RestActivity.class));
        break;
      case R.id.btn_shopping:
        startActivity(new Intent(getActivity(), ShoppingActivity.class));
        break;

    }

  }
}
