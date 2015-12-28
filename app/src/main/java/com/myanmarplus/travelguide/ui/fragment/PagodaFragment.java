package com.myanmarplus.travelguide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.Pagoda;
import com.myanmarplus.travelguide.ui.adapter.PagodaRvAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagodaFragment extends Fragment {


    private RecyclerView rv_pagoda;
    private PagodaRvAdapter pagodaRvAdapter;

    public PagodaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_pagoda, container, false);
        rv_pagoda = (RecyclerView)v.findViewById(R.id.rv_pagoda);
        pagodaRvAdapter = new PagodaRvAdapter(getActivity(),getData());
        rv_pagoda.setAdapter(pagodaRvAdapter);
        rv_pagoda.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }


    private List<Pagoda> getData() {

        List<Pagoda> itemList = new ArrayList<>();

        int[] imageId = {R.drawable.google,R.drawable.google,R.drawable.google,R.drawable.google};
        String[] title = {"Google","Facebook","Youtube","Bing"};

        for (int i = 0; i < imageId.length; i++){

            Pagoda item = new Pagoda();
            item.setTitle(title[i]);
            item.setImageId(imageId[i]);
            itemList.add(item);
        }

        return itemList;

    }
}
