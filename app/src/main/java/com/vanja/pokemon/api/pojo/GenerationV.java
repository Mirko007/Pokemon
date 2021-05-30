package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class GenerationV{

	@SerializedName("black-white")
	private BlackWhite blackWhite;

	public BlackWhite getBlackWhite(){
		return blackWhite;
	}
}