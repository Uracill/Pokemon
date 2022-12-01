package com.example.pokemon.model.dto;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.dv.DvCatchChance;
import org.checkerframework.checker.regex.qual.Regex;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PokemonDto {

    private long id;

    //TODO: @Regex
    @Size(min = 2, max = 10)
    private String _name;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String _firstType;

    @NotEmpty
    @Size(min = 1, max = 10)
    private String _secondType;

    @Min(1)
    @Max(255)
    private int _catchRate;

    @NotEmpty
    @Size(min = 2, max = 10)
    private String _gender;

    private boolean _caught;

    public PokemonDto() {
    }

    public PokemonDto(String name, String firstType, String secondType, int catchRate, String gender, boolean caught) {
        _name = name;
        _firstType = firstType;
        _secondType = secondType;
        _catchRate = catchRate;
        _gender = gender;
        _caught = caught;
    }

    public static PokemonDto PokemonToDto(Pokemon pokemon) {
        PokemonDto newPokemonDto = new PokemonDto();
        newPokemonDto.setId(pokemon.getId());
        newPokemonDto.setName(pokemon.getName());
        newPokemonDto.setFirstType(pokemon.getFirstType());
        newPokemonDto.setSecondType(pokemon.getSecondType());
        newPokemonDto.setCatchRate(pokemon.getCatchRate());
        newPokemonDto.setGender(pokemon.getGender());
        newPokemonDto.setCaught(pokemon.getCaught());
        return newPokemonDto;
    }

    public static Pokemon DtoToPokemon(PokemonDto pokemonDto) {
        Pokemon newPokemon = new Pokemon();
        newPokemon.setId(pokemonDto.getId());
        newPokemon.setName(pokemonDto.getName());
        newPokemon.setFirstType(pokemonDto.getFirstType());
        newPokemon.setSecondType(pokemonDto.getSecondType());
        newPokemon.setCatchRate(pokemonDto.getCatchRate());
        newPokemon.setGender(pokemonDto.getGender());
        newPokemon.setCaught(pokemonDto.getCaught());
        newPokemon.setCaught(pokemonDto.getCaught());
        return newPokemon;
    }

    public Long getId() {
        return id;
    }

    public void setId(long newId) {
        id = newId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getFirstType() {
        return _firstType;
    }

    public void setFirstType(String firstType) {
        _firstType = firstType;
    }

    public String getSecondType() {
        return _secondType;
    }

    public void setSecondType(String secondType) {
        _secondType = secondType;
    }

    public int getCatchRate() {
        return _catchRate;
    }

    public void setCatchRate(int catchRate) {
        _catchRate = catchRate;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public boolean getCaught() {
        return _caught;
    }

    public void setCaught(boolean caught) {
        _caught = caught;
    }

    public String caughtToString() {
        if(_caught) {
            return "Yes";
        }
        else {
            return "No";
        }
    }

    public String catchRateToString() {
        DvCatchChance catchChance = DvCatchChance.valueOf(_catchRate);
        return catchChance.toString();
    }
}
