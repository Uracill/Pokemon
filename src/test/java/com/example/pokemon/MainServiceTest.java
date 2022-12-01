package com.example.pokemon;


import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.dto.PokemonDto;
import com.example.pokemon.repository.PokemonRepository;
import com.example.pokemon.service.MainService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainServiceTest {

    private MainService _mainService;

    private final List<Pokemon> POKEMON;

    public MainServiceTest() {
        POKEMON = List.of(new Pokemon("Pikachu", "Electric", "-", 190, "Male", true),
                new Pokemon("Mewtwo", "Psychic", "-", 3, "Neutral", false),
                new Pokemon("Jolteon", "Electric", "-", 45, "Female", true),
                new Pokemon("Blastoise", "Water", "-", 1, "Female", false),
                new Pokemon("Swampert", "Water", "Ground", 255, "Female", false));

        POKEMON.get(0).setId(20L);
        POKEMON.get(1).setId(31L);
        POKEMON.get(2).setId(42L);
        POKEMON.get(3).setId(55L);
        POKEMON.get(4).setId(100L);
    }

    @BeforeEach
    void setUp() {
        PokemonRepository pokemonRepositoryMoch = mock(PokemonRepository.class);
        when(pokemonRepositoryMoch.findAll()).thenReturn(POKEMON);  //wenn findAll() aufgerufen wird, wird POKEMON zurückgegeben
        when(pokemonRepositoryMoch.findById(31L)).thenReturn(Optional.ofNullable(POKEMON.get(1)));
        _mainService = new MainService(pokemonRepositoryMoch);
    }

    @Test
    void testGetAllPokemon() {
        assertEquals(POKEMON, _mainService.getAllPokemon());
    }

    @Test
    void testGetPokemonDtoById() {
        PokemonDto mewtwoDto = _mainService.getPokemonDtoById(31L);
        assertEquals(31L, mewtwoDto.getId());
        assertEquals("Mewtwo", mewtwoDto.getName());
        assertEquals("Psychic", mewtwoDto.getFirstType());
        assertEquals("-", mewtwoDto.getSecondType());
        assertEquals(3, mewtwoDto.getCatchRate());
        assertEquals("Neutral", mewtwoDto.getGender());
        assertFalse(mewtwoDto.getCaught());

        assertThrows(RuntimeException.class, () -> _mainService.getPokemonDtoById(0));
        assertThrows(RuntimeException.class, () -> _mainService.getPokemonDtoById(Long.MAX_VALUE));
        assertThrows(RuntimeException.class, () -> _mainService.getPokemonDtoById(Long.MIN_VALUE));
    }

    @Test
    void testGetFilteredPokemon() {
        assertEquals(List.copyOf(POKEMON), _mainService.getFilteredPokemon(""));
        assertEquals(List.copyOf(POKEMON), _mainService.getFilteredPokemon("e"));

        assertEquals(List.of(POKEMON.get(0)), _mainService.getFilteredPokemon("Pikachu"));
        assertEquals(List.of(POKEMON.get(0)), _mainService.getFilteredPokemon("piKA"));
        assertEquals(List.of(POKEMON.get(0), POKEMON.get(2)), _mainService.getFilteredPokemon("eLeCtRiC"));
        assertEquals(List.of(POKEMON.get(1), POKEMON.get(2)), _mainService.getFilteredPokemon("4"));
        assertEquals(List.of(POKEMON.get(1)), _mainService.getFilteredPokemon("Neutral"));
        assertEquals(List.of(POKEMON.get(0), POKEMON.get(2), POKEMON.get(3), POKEMON.get(4)),
                _mainService.getFilteredPokemon("mAlE"));
        assertEquals(List.of(POKEMON.get(1), POKEMON.get(3), POKEMON.get(4)),
                _mainService.getFilteredPokemon("nO"));
    }
}
