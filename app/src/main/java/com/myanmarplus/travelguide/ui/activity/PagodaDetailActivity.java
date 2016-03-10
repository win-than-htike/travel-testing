package com.myanmarplus.travelguide.ui.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.Pagoda;

import java.util.List;

/**
 * Created by winthanhtike on 3/10/16.
 */
public class PagodaDetailActivity extends AppCompatActivity{

    private Pagoda pagoda;
    private TextView pagodaDesc;
    private ImageView imageView;
    private TextView tvToolbarTitle;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagoda_detail);

        configsView();

        Intent intent = getIntent();

        pagoda = (Pagoda) intent.getSerializableExtra("pagoda");
        tvToolbarTitle.setText(pagoda.getPagodaName());
        pagodaDesc.setText(pagoda.getPagodaDesc());
        tvToolbarTitle.setTextColor(R.color.toolbarTextcolor);
        Glide.with(getApplicationContext()).load(pagoda.getDetailPhoto()).into(imageView);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String shareContent = pagoda.getPagodaDesc();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.setType("image/*");
                share.putExtra(Intent.EXTRA_TEXT,shareContent);
                share.createChooser(share,"Share Article");
                startActivity(share);

            }
        });


    }

    private void configsView() {

        pagodaDesc = (TextView)findViewById(R.id.pagoda_desc);
        imageView = (ImageView)findViewById(R.id.event_image);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitleEnabled(false);
        toolbarAndTitle();

    }

    private void toolbarAndTitle() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvToolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

}
