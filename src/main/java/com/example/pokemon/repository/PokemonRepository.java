package com.example.pokemon.repository;

import com.example.pokemon.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    List<Pokemon> findAll();
}
