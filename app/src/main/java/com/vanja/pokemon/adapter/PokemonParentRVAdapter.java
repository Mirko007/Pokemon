package com.vanja.pokemon.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vanja.pokemon.R;
import com.vanja.pokemon.api.pojo.AbilitiesItem;
import com.vanja.pokemon.api.pojo.PokemonResponse;
import com.vanja.pokemon.api.pojo.StatsItem;

import java.util.ArrayList;

public class PokemonParentRVAdapter extends RecyclerView.Adapter<PokemonParentRVAdapter.MyViewHolder> {
    public PokemonResponse PokemonResponse;
    Context ctx;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_pokemon_name, tv_pokemon_moves;
        public ImageView iv_pokemon_front, iv_pokemon_back;
        public RecyclerView rv_pokemon_child;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_pokemon_name = itemView.findViewById(R.id.tv_pokemon_name);
            tv_pokemon_moves = itemView.findViewById(R.id.tv_pokemon_moves);
            iv_pokemon_front = itemView.findViewById(R.id.iv_pokemon_front);
            iv_pokemon_back = itemView.findViewById(R.id.iv_pokemon_back);
            rv_pokemon_child = itemView.findViewById(R.id.rv_pokemon_child);
        }
    }

    public PokemonParentRVAdapter(PokemonResponse pokemonResponse, Context mContext) {
        this.ctx = mContext;
        this.PokemonResponse = pokemonResponse;
    }

    @Override
    public PokemonParentRVAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_parent_rv_items, parent, false);
        return new PokemonParentRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonParentRVAdapter.MyViewHolder holder, int position) {
        PokemonResponse pokemonResponse = PokemonResponse;
        String abilities = "";
        for (AbilitiesItem ability : pokemonResponse.getAbilities()) {
            abilities += ability.getAbility().getName() + "\n";
        }
        holder.tv_pokemon_moves.setText(abilities);
        holder.tv_pokemon_name.setText(pokemonResponse.getName());

        Picasso.get().load(pokemonResponse.getSprites().getFrontDefault()).into(holder.iv_pokemon_front);
        Picasso.get().load(pokemonResponse.getSprites().getBackDefault()).into(holder.iv_pokemon_back);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ctx);
        holder.rv_pokemon_child.setLayoutManager(layoutManager);
        PokemonChildRVAdapter pokemonChildRVAdapter = new PokemonChildRVAdapter((ArrayList<StatsItem>) pokemonResponse.getStats(), holder.rv_pokemon_child.getContext());
        holder.rv_pokemon_child.setAdapter(pokemonChildRVAdapter);

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
