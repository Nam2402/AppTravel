package com.example.nam.travel.views.eat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nam.travel.R;
import com.example.nam.travel.models.PlaceCategoriesModel;
import com.example.nam.travel.models.SingleItemModel;
import com.example.nam.travel.views.adapter.RecyclerViewDataAdapter;

import java.util.ArrayList;

public class EatActivity extends AppCompatActivity {

    private ArrayList<PlaceCategoriesModel> allSampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);

        allSampleData = new ArrayList<>();

        createDummyData();

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
//        recyclerView.setHasFixedSize(true);
//        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(allSampleData, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setAdapter(adapter);
    }

    private void createDummyData() {
        for (int i = 1; i <= 5; i++) {
            PlaceCategoriesModel dm = new PlaceCategoriesModel();
            dm.setHeaderTitle("Categories " + i);
            ArrayList<SingleItemModel> singleItemModels = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                singleItemModels.add(new SingleItemModel("Name " + j, "URL " + j,"Aaaaaaaaaaaa"));
            }
            dm.setAllItemInSection(singleItemModels);
            allSampleData.add(dm);
        }

    }
}
