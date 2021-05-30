package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class GenerationIii{

	@SerializedName("firered-leafgreen")
	private FireredLeafgreen fireredLeafgreen;

	@SerializedName("ruby-sapphire")
	private RubySapphire rubySapphire;

	@SerializedName("emerald")
	private Emerald emerald;

	public FireredLeafgreen getFireredLeafgreen(){
		return fireredLeafgreen;
	}

	public RubySapphire getRubySapphire(){
		return rubySapphire;
	}

	public Emerald getEmerald(){
		return emerald;
	}
}