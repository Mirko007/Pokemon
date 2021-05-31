package com.vanja.pokemon.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.vanja.pokemon.R;
import com.vanja.pokemon.api.pojo.StatsItem;

import java.util.ArrayList;

public class PokemonChildRVAdapter extends RecyclerView.Adapter<PokemonChildRVAdapter.MyViewHolder> {
    public ArrayList<StatsItem> childArrayList;
    Context ctx;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_stats_name;
        public TextView tv_stats_value;
        public ProgressBar progress_bar_stat;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_stats_name = itemView.findViewById(R.id.tv_stats_name);
            tv_stats_value = itemView.findViewById(R.id.tv_stats_value);
            progress_bar_stat = itemView.findViewById(R.id.progress_bar_stat);
        }
    }

    public PokemonChildRVAdapter(ArrayList<StatsItem> arrayList, Context mContext) {
        this.ctx = mContext;
        this.childArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_child_rv_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StatsItem statsItem = childArrayList.get(position);
        holder.tv_stats_name.setText(statsItem.getStat().getName());
        holder.tv_stats_value.setText(String.valueOf(statsItem.getBaseStat()));
        holder.progress_bar_stat.setMax(150);
        holder.progress_bar_stat.setProgress(statsItem.getBaseStat());
        if (statsItem.getBaseStat() > 99)
            holder.progress_bar_stat.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
        else if (statsItem.getBaseStat() > 50)
            holder.progress_bar_stat.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        else
            holder.progress_bar_stat.setProgressTintList(ColorStateList.valueOf(Color.RED));


    }

    @Override
    public int getItemCount() {
        return childArrayList.size();
    }
}
