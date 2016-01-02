package com.myanmarplus.travelguide.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.Cinema;
import com.myanmarplus.travelguide.model.Restaurant;

import java.util.Collections;
import java.util.List;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class RestaurantRvAdapter extends RecyclerView.Adapter<RestaurantRvAdapter.RestaurantViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<Restaurant> rList = Collections.emptyList();
    private boolean like = false;
    private boolean bookmarkIcon = false;

    public RestaurantRvAdapter(Context context, List<Restaurant> rList) {
        this.context = context;
        this.rList = rList;
        notifyDataSetChanged();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RestaurantViewHolder holder, int position) {

        Restaurant item = rList.get(position);
        holder.image.setImageResource(item.getImageId());
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (like == true) {
                    holder.like.setImageResource(R.drawable.like_press);
                    like = false;
                } else if (like == false) {

                    holder.like.setImageResource(R.drawable.favorite);
                    like = true;

                }
            }
        });

        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bookmarkIcon == false) {
                    holder.bookmark.setImageResource(R.drawable.bookmark);
                    bookmarkIcon = true;
                } else if (bookmarkIcon == true) {
                    holder.bookmark.setImageResource(R.drawable.bookmark_press);
                    bookmarkIcon = false;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return rList.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private ImageView like, bookmark, share;
        private TextView imageTitle;
        CardView cardView;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            like = (ImageView) itemView.findViewById(R.id.like);
            bookmark = (ImageView) itemView.findViewById(R.id.bookmark);
            share = (ImageView) itemView.findViewById(R.id.share);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            image = (ImageView) itemView.findViewById(R.id.card_image);

        }
    }

}
