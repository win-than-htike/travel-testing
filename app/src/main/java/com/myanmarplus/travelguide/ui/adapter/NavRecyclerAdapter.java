package com.myanmarplus.travelguide.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.NavigationItem;
import com.myanmarplus.travelguide.ui.activity.CinemaActivity;
import com.myanmarplus.travelguide.ui.activity.EntertainmentActivity;
import com.myanmarplus.travelguide.ui.activity.PagodaActivity;
import com.myanmarplus.travelguide.ui.activity.RestaurantActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class NavRecyclerAdapter extends RecyclerView.Adapter<NavRecyclerAdapter.NavViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<NavigationItem> data = Collections.emptyList();

    public NavRecyclerAdapter(Context context, List<NavigationItem> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public NavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.drawer_list_item,parent,false);
        NavViewHolder holder = new NavViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(NavViewHolder holder, final int position) {

        NavigationItem item = data.get(position);
        holder.icon.setImageResource(item.getIconId());
        holder.title.setText(item.getTitle());
        holder.rvLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){

                    case 0:
                        context.startActivity(new Intent(context, PagodaActivity.class));
                        break;

                    case 1:
                        context.startActivity(new Intent(context, CinemaActivity.class));
                        break;

                    case 2:
                        context.startActivity(new Intent(context, EntertainmentActivity.class));
                        break;

                    case 3:
                        context.startActivity(new Intent(context, RestaurantActivity.class));
                        break;

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NavViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rvLayout;
        private ImageView icon;
        private TextView title;

        public NavViewHolder(View itemView) {
            super(itemView);

            rvLayout = (RelativeLayout)itemView.findViewById(R.id.rv_layout);
            icon = (ImageView)itemView.findViewById(R.id.icon);
            title = (TextView)itemView.findViewById(R.id.title);

        }
    }


}
