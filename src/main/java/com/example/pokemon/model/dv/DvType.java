package com.example.pokemon.model.dv;

public enum DvType {
    Null,
    Normal,
    Flight,
    Poison,
    Ground,
    Rock,
    Bug,
    Ghost,
    Steel,
    Fire,
    Water,
    Leaf,
    Electric,
    Psychic,
    Ice,
    Dragon,
    Dark,
    Fairy;

    @Override
    public String toString() {
        if(this.equals(DvType.Null)) {
            return "-";
        }
        else {
            return super.toString();
        }
    }
}
