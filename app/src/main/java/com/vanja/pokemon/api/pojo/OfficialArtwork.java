package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class OfficialArtwork{

	@SerializedName("front_default")
	private String frontDefault;

	public String getFrontDefault(){
		return frontDefault;
	}
}