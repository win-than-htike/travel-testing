package com.myanmarplus.travelguide.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.ui.adapter.TabFragmentAdapter;
import com.myanmarplus.travelguide.ui.fragment.DrawerFragment;

public class MainActivity extends AppCompatActivity {

    private TabFragmentAdapter mTabFragmentAdapter;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    DrawerFragment mDrawerFragment;
    ActionBarDrawerToggle mDrawerToggle;
//    RelativeLayout drawerListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Travel Guide");
        toolbar.setTitleTextColor(R.color.toolbarTextcolor);

//        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
//        drawerListLayout = (RelativeLayout)findViewById(R.id.nav_drawer);
        mDrawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        mDrawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), toolbar);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.pagoda));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.cinema));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.entertainment));
        mTabLayout.addTab(mTabLayout.newTab().setIcon(R.drawable.restaurant));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mTabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mTabFragmentAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
