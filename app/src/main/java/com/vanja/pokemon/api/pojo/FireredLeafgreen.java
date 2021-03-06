package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class FireredLeafgreen{

	@SerializedName("back_default")
	private String backDefault;

	@SerializedName("front_default")
	private String frontDefault;

	@SerializedName("back_shiny")
	private String backShiny;

	@SerializedName("front_shiny")
	private String frontShiny;

	public String getBackDefault(){
		return backDefault;
	}

	public String getFrontDefault(){
		return frontDefault;
	}

	public String getBackShiny(){
		return backShiny;
	}

	public String getFrontShiny(){
		return frontShiny;
	}
}