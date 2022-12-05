package com.example.pokemon.service;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.dto.PokemonDto;
import com.example.pokemon.repository.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {
    private final PokemonRepository _pokemonRepository;

    public MainService(PokemonRepository pokemonRepository) {
        _pokemonRepository = pokemonRepository;
    }

    public void add(PokemonDto pokemonDto) {
        Pokemon pokemon = PokemonDto.DtoToPokemon(pokemonDto);
        _pokemonRepository.save(pokemon);
    }

    public void deleteById(long id) {
        _pokemonRepository.deleteById(id);
    }

    public void delete(PokemonDto pokemonDto) {
        Pokemon pokemon = PokemonDto.DtoToPokemon(pokemonDto);
        _pokemonRepository.delete(pokemon);
    }

    public List<Pokemon> getAllPokemon() {
        return _pokemonRepository.findAll();
    }

    public PokemonDto getPokemonDtoById(long id) {
        return _pokemonRepository.findById(id)
            .map(PokemonDto::PokemonToDto)
            .orElseThrow(() -> new RuntimeException("No Pokemon found for ID:" + id))
    }

    public List<Pokemon> getFilteredPokemon(String filterString) {
        String lowerString = filterString.toLowerCase();

        return getAllPokemon().stream().filter(pokemon -> pokemon.getName().toLowerCase().contains(lowerString) //FilterString in Groß- oder Kleinschreibung in einem der Felder vorkommt. Falls ja, wird das Pokemon in die gefilterte Liste aufgenommen.
                || pokemon.getFirstType().toLowerCase().contains(lowerString)
                || pokemon.getSecondType().toLowerCase().contains(lowerString)
                || PokemonDto.PokemonToDto(pokemon).catchRateToString().contains(lowerString)
                || pokemon.getGender().toLowerCase().contains(lowerString)
                || PokemonDto.PokemonToDto(pokemon).caughtToString().toLowerCase().contains(lowerString)).toList();
    }

    public List<PokemonDto> getFilteredPokemonDtos(String filterString) {
        return pokemonListToDtoList(getFilteredPokemon(filterString));
    }

    private List<PokemonDto> pokemonListToDtoList(List<Pokemon> pokemonList) {
        List<PokemonDto> pokemonDtoList = new ArrayList<>();
        for(Pokemon pokemon: pokemonList) {
            pokemonDtoList.add(PokemonDto.PokemonToDto(pokemon));
        }
        return pokemonDtoList;
    }

    private List<Pokemon> pokemonDtoListToPokemonList(List<PokemonDto> pokemonDtoList) {
        List<Pokemon> pokemonList = new ArrayList<>();
        for(PokemonDto pokemonDto: pokemonDtoList) {
            pokemonList.add(PokemonDto.DtoToPokemon(pokemonDto));
        }
        return pokemonList;
    }
}
