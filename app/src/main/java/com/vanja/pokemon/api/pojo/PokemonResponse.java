package com.vanja.pokemon.api.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("base_experience")
    private Integer baseExperience;
    @SerializedName("height")
    private Integer height;
    @SerializedName("is_default")
    private Boolean isDefault;
    @SerializedName("order")
    private Integer order;
    @SerializedName("weight")
    private Integer weight;
    @SerializedName("abilities")
    private List<AbilitiesItem> abilities = null;
    @SerializedName("moves")
    private List<Move> moves = null;
    @SerializedName("species")
    private Species species;
    @SerializedName("sprites")
    private Sprites sprites;
    @SerializedName("stats")
    private List<StatsItem> stats = null;
    @SerializedName("types")
    private List<Type> types = null;
//    @SerializedName
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<AbilitiesItem> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitiesItem> abilities) {
        this.abilities = abilities;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<StatsItem> getStats() {
        return stats;
    }

    public void setStats(List<StatsItem> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}
