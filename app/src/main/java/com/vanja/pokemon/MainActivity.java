package com.vanja.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

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

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.imePokemona)
    TextView imePOkemona;

    @BindView(R.id.tv_potezi)
    TextView tv_potezi;

    @BindView(R.id.tv_stats)
    TextView tv_stats;

    @BindView(R.id.iv_front)
    ImageView iv_front;

    @BindView(R.id.iv_back)
    ImageView iv_back;


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
                    imePOkemona.setText(pokemonResponse.getName());
                    Picasso.get().load(pokemonResponse.getSprites().getFrontDefault()).into(iv_front);
                    Picasso.get().load(pokemonResponse.getSprites().getBackDefault()).into(iv_back);

                    String abilities= "";
                    for (AbilitiesItem ability : pokemonResponse.getAbilities()){
                        abilities+= ability.getAbility().getName()+"\n";
                    }
                    tv_potezi.setText(abilities);

                    String stats= "";
                    for (StatsItem statsItem : pokemonResponse.getStats()){
                        stats+= statsItem.getStat().getName()+":"+statsItem.getBaseStat()+ "\n";
                    }
                    tv_stats.setText(stats);

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