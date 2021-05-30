package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class OmegarubyAlphasapphire{

	@SerializedName("front_shiny_female")
	private Object frontShinyFemale;

	@SerializedName("front_default")
	private String frontDefault;

	@SerializedName("front_female")
	private Object frontFemale;

	@SerializedName("front_shiny")
	private String frontShiny;

	public Object getFrontShinyFemale(){
		return frontShinyFemale;
	}

	public String getFrontDefault(){
		return frontDefault;
	}

	public Object getFrontFemale(){
		return frontFemale;
	}

	public String getFrontShiny(){
		return frontShiny;
	}
}