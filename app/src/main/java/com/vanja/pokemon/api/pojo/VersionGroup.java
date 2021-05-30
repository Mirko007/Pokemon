package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class VersionGroup{

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}