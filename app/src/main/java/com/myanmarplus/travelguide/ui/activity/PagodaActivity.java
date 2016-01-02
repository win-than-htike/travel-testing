package com.myanmarplus.travelguide.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.myanmarplus.travelguide.R;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class PagodaActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagoda);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pagoda");

    }
}
