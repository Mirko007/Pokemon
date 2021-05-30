package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

public class GenerationVi{

	@SerializedName("omegaruby-alphasapphire")
	private OmegarubyAlphasapphire omegarubyAlphasapphire;

	@SerializedName("x-y")
	private XY xY;

	public OmegarubyAlphasapphire getOmegarubyAlphasapphire(){
		return omegarubyAlphasapphire;
	}

	public XY getXY(){
		return xY;
	}
}