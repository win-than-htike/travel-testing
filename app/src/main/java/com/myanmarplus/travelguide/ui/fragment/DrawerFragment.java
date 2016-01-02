package com.myanmarplus.travelguide.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.NavigationItem;
import com.myanmarplus.travelguide.ui.adapter.NavRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by winthanhtike on 12/28/15.
 */
public class DrawerFragment extends Fragment {

    private DrawerLayout mDrawerLayot;
    private ActionBarDrawerToggle mDrawerToggle;
    private RecyclerView drawerRecycler;
    NavRecyclerAdapter navAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.drawer_list_layout, container, false);
        drawerRecycler = (RecyclerView) v.findViewById(R.id.drawer_list);
        navAdapter = new NavRecyclerAdapter(getActivity(), getData());
        drawerRecycler.setAdapter(navAdapter);
        drawerRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public List<NavigationItem> getData() {

        List<NavigationItem> navList = new ArrayList<>();

        int[] iconId = {R.drawable.pagoda, R.drawable.cinema, R.drawable.entertainment, R.drawable.restaurant};
        String[] title = {"Pagoda", "Cinema", "Entertainment", "Restuarant"};

        for (int i = 0; i < iconId.length; i++) {

            NavigationItem item = new NavigationItem();
            item.setIconId(iconId[i]);
            item.setTitle(title[i]);
            navList.add(item);

        }

        return navList;

    }


    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {

        mDrawerLayot = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), mDrawerLayot, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayot.setDrawerListener(mDrawerToggle);
        mDrawerLayot.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

}
