package com.example.nam.travel;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nam.travel.views.adapter.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        final TabLayout.Tab aroundTab = tabLayout.newTab();
        final TabLayout.Tab mapTab = tabLayout.newTab();
        final TabLayout.Tab chatTab = tabLayout.newTab();
        final TabLayout.Tab profileTab = tabLayout.newTab();

        View aroundView = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView aroundImage = aroundView.findViewById(R.id.img_tab);
        TextView aroundText = aroundView.findViewById(R.id.txt_name_tab);
        aroundImage.setImageResource(R.drawable.ic_home_black_24dp_selected);
        aroundText.setText("Trang chủ");


        View mapView = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView mapImage = mapView.findViewById(R.id.img_tab);
        TextView mapText = mapView.findViewById(R.id.txt_name_tab);
        mapImage.setImageResource(R.drawable.ic_update_black_24dp);
        mapText.setText("Tin mới");

        View chatView = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView chatImage = chatView.findViewById(R.id.img_tab);
        TextView chatText = chatView.findViewById(R.id.txt_name_tab);
        chatImage.setImageResource(R.drawable.ic_notifications_black_24dp);
        chatText.setText("Nổi bật");


        View profileView = getLayoutInflater().inflate(R.layout.custom_tab,null);
        final ImageView profileImage = profileView.findViewById(R.id.img_tab);
        TextView profileText = profileView.findViewById(R.id.txt_name_tab);
        profileImage.setImageResource(R.drawable.ic_person_black_24dp);
        profileText.setText("Cá nhân");

        aroundTab.setCustomView(aroundView);
        chatTab.setCustomView(chatView);
        mapTab.setCustomView(mapView);
        profileTab.setCustomView(profileView);

        tabLayout.addTab(aroundTab,0);
        tabLayout.addTab(mapTab,1);
        tabLayout.addTab(chatTab,2);
        tabLayout.addTab(profileTab,3);

        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        aroundImage.setImageResource(R.drawable.ic_home_black_24dp_selected);
                        mapImage.setImageResource(R.drawable.ic_update_black_24dp);
                        chatImage.setImageResource(R.drawable.ic_notifications_black_24dp);
                        profileImage.setImageResource(R.drawable.ic_person_black_24dp);
                        break;
                    case 1:
                        aroundImage.setImageResource(R.drawable.ic_home_black_24dp);
                        mapImage.setImageResource(R.drawable.ic_update_black_24dp_selected);
                        chatImage.setImageResource(R.drawable.ic_notifications_black_24dp);
                        profileImage.setImageResource(R.drawable.ic_person_black_24dp);
                        break;
                    case 2:
                        aroundImage.setImageResource(R.drawable.ic_home_black_24dp);
                        mapImage.setImageResource(R.drawable.ic_update_black_24dp);
                        chatImage.setImageResource(R.drawable.ic_notifications_black_24dp_selected);
                        profileImage.setImageResource(R.drawable.ic_person_black_24dp);
                        break;
                    case 3:
                        aroundImage.setImageResource(R.drawable.ic_home_black_24dp);
                        mapImage.setImageResource(R.drawable.ic_update_black_24dp);
                        chatImage.setImageResource(R.drawable.ic_notifications_black_24dp);
                        profileImage.setImageResource(R.drawable.ic_person_black_24dp_selected);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public void onBackPressed() {

    }
}

