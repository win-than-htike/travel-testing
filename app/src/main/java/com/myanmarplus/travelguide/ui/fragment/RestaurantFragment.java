package com.myanmarplus.travelguide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.Cinema;
import com.myanmarplus.travelguide.model.Restaurant;
import com.myanmarplus.travelguide.ui.adapter.CinemaRvAdapter;
import com.myanmarplus.travelguide.ui.adapter.RestaurantRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends Fragment {


    private RecyclerView rv_restaurant;
    private RestaurantRvAdapter restaurantRvAdapter;

    public RestaurantFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cinema, container, false);
        rv_restaurant = (RecyclerView)v.findViewById(R.id.rv_cinema);
        restaurantRvAdapter = new RestaurantRvAdapter(getActivity(),getData());
        rv_restaurant.setAdapter(restaurantRvAdapter);
        rv_restaurant.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    private List<Restaurant> getData() {

        List<Restaurant> itemList = new ArrayList<>();

        int[] imageId = {R.drawable.google,R.drawable.google,R.drawable.google,R.drawable.google};
        String[] title = {"Google","Facebook","Youtube","Bing"};

        for (int i = 0; i < imageId.length; i++){

            Restaurant item = new Restaurant();
            item.setTitle(title[i]);
            item.setImageId(imageId[i]);
            itemList.add(item);

        }

        return itemList;

    }

}
