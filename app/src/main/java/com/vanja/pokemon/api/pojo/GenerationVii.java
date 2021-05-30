package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class GenerationVii{

	@SerializedName("icons")
	private Icons icons;

	@SerializedName("ultra-sun-ultra-moon")
	private UltraSunUltraMoon ultraSunUltraMoon;

	public Icons getIcons(){
		return icons;
	}

	public UltraSunUltraMoon getUltraSunUltraMoon(){
		return ultraSunUltraMoon;
	}
}