package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class Other{

	@SerializedName("dream_world")
	private DreamWorld dreamWorld;

	@SerializedName("official-artwork")
	private OfficialArtwork officialArtwork;

	public DreamWorld getDreamWorld(){
		return dreamWorld;
	}

	public OfficialArtwork getOfficialArtwork(){
		return officialArtwork;
	}
}