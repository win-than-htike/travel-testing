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
import com.myanmarplus.travelguide.ui.adapter.CinemaRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CinemaFragment extends Fragment {

    private RecyclerView rv_cinema;
    private CinemaRvAdapter cinemaRvAdapter;

    public CinemaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cinema, container, false);
        rv_cinema = (RecyclerView)v.findViewById(R.id.rv_cinema);
        cinemaRvAdapter = new CinemaRvAdapter(getActivity(),getData());
        rv_cinema.setAdapter(cinemaRvAdapter);
        rv_cinema.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    private List<Cinema> getData() {

        List<Cinema> itemList = new ArrayList<>();

        int[] imageId = {R.drawable.google,R.drawable.google,R.drawable.google,R.drawable.google};

        for (int i = 0; i < imageId.length; i++){

            Cinema item = new Cinema();
            item.setImageId(imageId[i]);
            itemList.add(item);
        }

        return itemList;

    }

}
