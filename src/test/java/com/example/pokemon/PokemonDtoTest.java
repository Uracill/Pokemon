package com.example.pokemon;

import com.example.pokemon.model.Pokemon;
import com.example.pokemon.model.dto.PokemonDto;
import org.junit.jupiter.api.Test;



import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonDtoTest {

    private final List<Pokemon> POKEMON;
    private final List<PokemonDto> POKEMONDTO;

    public PokemonDtoTest() {
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

        POKEMONDTO = List.of(new PokemonDto("Pikachu", "Electric", "-", 190, "Male", true),
                new PokemonDto("Mewtwo", "Psychic", "-", 3, "Neutral", false),
                new PokemonDto("Jolteon", "Electric", "-", 45, "Female", true),
                new PokemonDto("Blastoise", "Water", "-", 1, "Female", false),
                new PokemonDto("Swampert", "Water", "Ground", 255, "Female", false));
        POKEMONDTO.get(0).setId(20L);
        POKEMONDTO.get(1).setId(31L);
        POKEMONDTO.get(2).setId(42L);
        POKEMONDTO.get(3).setId(55L);
        POKEMONDTO.get(4).setId(100L);
    }

    @Test
    void testPokemonToDto() {
        PokemonDto pikachuDto = PokemonDto.PokemonToDto(POKEMON.get(0));
        assertEquals(20L, pikachuDto.getId());
        assertEquals("Pikachu", pikachuDto.getName());
        assertEquals("Electric", pikachuDto.getFirstType());
        assertEquals("-", pikachuDto.getSecondType());
        assertEquals(190, pikachuDto.getCatchRate());
        assertEquals("Male", pikachuDto.getGender());
        assertTrue(pikachuDto.getCaught());

        assertThrows(NullPointerException.class, () -> {PokemonDto.PokemonToDto(null);});

    }

    @Test
    void testDtoToPokemon() {
        Pokemon pikachu = PokemonDto.DtoToPokemon(POKEMONDTO.get(0));
        assertEquals(20L, pikachu.getId());
        assertEquals("Pikachu", pikachu.getName());
        assertEquals("Electric", pikachu.getFirstType());
        assertEquals("-", pikachu.getSecondType());
        assertEquals(190, pikachu.getCatchRate());
        assertEquals("Male", pikachu.getGender());
        assertTrue(pikachu.getCaught());

        assertThrows(NullPointerException.class, () -> {PokemonDto.DtoToPokemon(null);});
    }
}
