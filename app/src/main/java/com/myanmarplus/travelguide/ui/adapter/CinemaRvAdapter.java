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

import java.util.Collections;
import java.util.List;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class CinemaRvAdapter extends RecyclerView.Adapter<CinemaRvAdapter.CinemaViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<Cinema> cList = Collections.emptyList();
    private boolean like = false;
    private boolean bookmarkIcon = false;

    public CinemaRvAdapter(Context context, List<Cinema> cList) {
        this.context = context;
        this.cList = cList;
        notifyDataSetChanged();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CinemaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_item, parent, false);
        CinemaViewHolder viewHolder = new CinemaViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final CinemaViewHolder holder, int position) {

        Cinema item = cList.get(position);
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
        return cList.size();
    }

    public class CinemaViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private ImageView like, bookmark, share;
        CardView cardView;

        public CinemaViewHolder(View itemView) {
            super(itemView);

            like = (ImageView) itemView.findViewById(R.id.like);
            bookmark = (ImageView) itemView.findViewById(R.id.bookmark);
            share = (ImageView) itemView.findViewById(R.id.share);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            image = (ImageView) itemView.findViewById(R.id.card_image);

        }
    }
}
