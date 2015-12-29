package com.myanmarplus.travelguide.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myanmarplus.travelguide.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFragment extends Fragment {


    public EntertainmentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_entertainment, container, false);
    }

}
