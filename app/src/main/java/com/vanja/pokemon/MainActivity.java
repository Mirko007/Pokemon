package com.vanja.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.vanja.pokemon.ViewModel.PokemonViewModel;
import com.vanja.pokemon.adapter.PokemonParentRVAdapter;
import com.vanja.pokemon.api.pojo.AbilitiesItem;
import com.vanja.pokemon.api.pojo.Ability;
import com.vanja.pokemon.api.pojo.PokemonResponse;
import com.vanja.pokemon.api.pojo.StatsItem;
import com.vanja.pokemon.helper.Helper;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.vanja.pokemon.helper.Helper.getRandom;

public class MainActivity extends AppCompatActivity {
  private PokemonViewModel pokemonViewModel;
    private RecyclerView.Adapter pokemonParentRVAdapter;
    private RecyclerView.LayoutManager parentLayoutManager;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.rv_PokemonParent)
    RecyclerView rv_PokemonParent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);

        pokemonViewModel = new ViewModelProvider(this
                , ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()))
                .get(PokemonViewModel.class);
        pokemonViewModel.loadPokemon(getRandom()).observe(this, new Observer<PokemonResponse>() {
            @Override
            public void onChanged(PokemonResponse pokemonResponse) {
                if(pokemonResponse!=null){
                    parentLayoutManager = new LinearLayoutManager(MainActivity.this);
                    pokemonParentRVAdapter = new PokemonParentRVAdapter(pokemonResponse, MainActivity.this);
                    rv_PokemonParent.setLayoutManager(parentLayoutManager);
                    rv_PokemonParent.setAdapter(pokemonParentRVAdapter);
                    pokemonParentRVAdapter.notifyDataSetChanged();

                }
            }
        });

        //getLifecycle().addObserver(pokemonViewModel);
    }

    @OnClick(R.id.fab)
    public void btn_fab() {
        pokemonViewModel.loadPokemon(getRandom());
    }

}