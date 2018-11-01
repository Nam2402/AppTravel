package com.example.nam.travel.views.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.nam.travel.views.fragment.HomeFragment;

import com.example.nam.travel.views.fragment.NewLocationFragment;
import com.example.nam.travel.views.fragment.ProfileFragment;

/**
 * Created by Nam on 10/11/2018.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static int NUM_ITEMS = 4;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();

            case 1:
                return new NewLocationFragment();
            case 2:
                return new HomeFragment();
            case 3:
                return new ProfileFragment();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Trang chủ";
            case 1:
                return "Tin mới";
            case 2:
                return "Nổi bật";
            case 3:
                return "Cá nhân";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
