package com.myanmarplus.travelguide.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myanmarplus.travelguide.R;
import com.myanmarplus.travelguide.model.Pagoda;
import com.myanmarplus.travelguide.ui.activity.DhammayazikaActivity;
import com.myanmarplus.travelguide.ui.activity.KyaiktiyoActivity;
import com.myanmarplus.travelguide.ui.activity.ShweDagonPagodaActivity;
import com.myanmarplus.travelguide.ui.activity.ShwezigonActivity;

import java.util.Collections;
import java.util.List;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class PagodaRvAdapter extends RecyclerView.Adapter<PagodaRvAdapter.PagodaViewHolder> {

    LayoutInflater inflater;
    Context context;
    List<Pagoda> pList = Collections.emptyList();
    private boolean like = false;
    private boolean bookmarkIcon = false;

    public PagodaRvAdapter(Context context, List<Pagoda> pList) {
        this.context = context;
        this.pList = pList;
        notifyDataSetChanged();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public PagodaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.card_item, parent, false);
        PagodaViewHolder viewHolder = new PagodaViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final PagodaViewHolder holder, int position) {

        Pagoda item = pList.get(position);
        holder.image.setImageResource(item.getImageId());
        holder.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                switch (position) {

                    case 0:
                        context.startActivity(new Intent(context, ShweDagonPagodaActivity.class));
                        break;

                    case 1:
                        context.startActivity(new Intent(context, KyaiktiyoActivity.class));
                        break;

                    case 2:
                        context.startActivity(new Intent(context, ShwezigonActivity.class));
                        break;

                    case 3:
                        context.startActivity(new Intent(context, DhammayazikaActivity.class));
                        break;

                }
            }
        });
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
        return pList.size();
    }

    public class PagodaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView image;
        private ImageView like, bookmark, share;
        private ItemClickListener clickListener;
        CardView cardView;

        public PagodaViewHolder(View itemView) {
            super(itemView);

            like = (ImageView) itemView.findViewById(R.id.like);
            bookmark = (ImageView) itemView.findViewById(R.id.bookmark);
            share = (ImageView) itemView.findViewById(R.id.share);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            image = (ImageView) itemView.findViewById(R.id.card_image);
            itemView.setOnClickListener(this);

        }

        public void setClickListener(ItemClickListener itemClickListener) {

            this.clickListener = itemClickListener;

        }

        @Override
        public void onClick(View view) {
            clickListener.onClick(view, getAdapterPosition(), false);
        }
    }

}
