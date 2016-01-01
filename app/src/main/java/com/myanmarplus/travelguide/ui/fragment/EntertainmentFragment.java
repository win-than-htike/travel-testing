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
import com.myanmarplus.travelguide.model.Entertainment;
import com.myanmarplus.travelguide.ui.adapter.CinemaRvAdapter;
import com.myanmarplus.travelguide.ui.adapter.EntertainmentRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {


    private RecyclerView rv_entertainment;
    private EntertainmentRvAdapter entertainmentRvAdapter;

    public EntertainmentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_entertainment, container, false);
        rv_entertainment = (RecyclerView)v.findViewById(R.id.rv_entertainment);
        entertainmentRvAdapter = new EntertainmentRvAdapter(getActivity(),getData());
        rv_entertainment.setAdapter(entertainmentRvAdapter);
        rv_entertainment.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    private List<Entertainment> getData() {

        List<Entertainment> itemList = new ArrayList<>();

        int[] imageId = {R.drawable.google,R.drawable.google,R.drawable.google,R.drawable.google};

        for (int i = 0; i < imageId.length; i++){

            Entertainment item = new Entertainment();
            item.setImageId(imageId[i]);
            itemList.add(item);
        }

        return itemList;

    }

}
