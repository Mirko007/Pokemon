package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class StatsItem{

	@SerializedName("stat")
	private Stat stat;

	@SerializedName("base_stat")
	private int baseStat;

	@SerializedName("effort")
	private int effort;

	public Stat getStat(){
		return stat;
	}

	public int getBaseStat(){
		return baseStat;
	}

	public int getEffort(){
		return effort;
	}
}