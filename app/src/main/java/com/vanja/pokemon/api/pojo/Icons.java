package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class Icons{

	@SerializedName("front_default")
	private String frontDefault;

	@SerializedName("front_female")
	private Object frontFemale;

	public String getFrontDefault(){
		return frontDefault;
	}

	public Object getFrontFemale(){
		return frontFemale;
	}
}