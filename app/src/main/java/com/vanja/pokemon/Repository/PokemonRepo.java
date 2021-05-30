package com.vanja.pokemon.Repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.vanja.pokemon.api.APIClient;
import com.vanja.pokemon.api.pojo.PokemonResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PokemonRepo {
    //private final ArrayList<Pokemon> pokemonArrayList;
    private final  MutableLiveData<PokemonResponse> pokemon;
    public PokemonRepo(Application application) {
        pokemon = new MutableLiveData<>();
    }

    public MutableLiveData<PokemonResponse> RandomPokemonAPI(int id){

        Call<PokemonResponse> call = APIClient.getInstance().getapi().getRandomPokemon(id);
        call.enqueue(new Callback<PokemonResponse>() {

            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if(response.code() == 200) {
                    try {
                        pokemon.setValue(response.body());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                call.cancel();
            }
        });
        return pokemon;

    }

}
