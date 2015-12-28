package com.myanmarplus.travelguide.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myanmarplus.travelguide.ui.activity.CinemaFragment;
import com.myanmarplus.travelguide.ui.activity.EntertainmentFragment;
import com.myanmarplus.travelguide.ui.activity.RestaurantFragment;
import com.myanmarplus.travelguide.ui.fragment.PagodaFragment;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class TabFragmentAdapter extends FragmentStatePagerAdapter {

    public TabFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                PagodaFragment pfg = new PagodaFragment();
                return pfg;

            case 1:
                CinemaFragment cfg = new CinemaFragment();
                return cfg;

            case 2:
                EntertainmentFragment efg = new EntertainmentFragment();
                return efg;

            case 3:
                RestaurantFragment rfg = new RestaurantFragment();
                return rfg;

            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

}
