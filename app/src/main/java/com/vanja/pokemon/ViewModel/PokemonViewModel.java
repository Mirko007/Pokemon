package com.vanja.pokemon.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;

import com.vanja.pokemon.Repository.PokemonRepo;
import com.vanja.pokemon.api.pojo.PokemonResponse;

import static com.vanja.pokemon.helper.Helper.getRandom;

public class PokemonViewModel extends AndroidViewModel {

    private final PokemonRepo pokemonRepo;
    public PokemonViewModel(@NonNull Application application) {
        super(application);
        pokemonRepo = new PokemonRepo(application);
    }

    public MutableLiveData<PokemonResponse> loadPokemon(int id) {
        return pokemonRepo.RandomPokemonAPI(id);
    }

}
