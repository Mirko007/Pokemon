package com.vanja.pokemon.api;

import com.vanja.pokemon.api.pojo.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("pokemon/{pokemon_id}")
    Call<PokemonResponse> getRandomPokemon(@Path("pokemon_id")int pokemon_id);
}
