package com.example.pokemon;

import com.example.pokemon.model.Pokemon;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PokemonTest {

    private final List<Pokemon> POKEMON;

    public PokemonTest() {
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

    @Test
    void testGetter() {
        assertEquals(20L, POKEMON.get(0).getId());
        assertEquals("Pikachu", POKEMON.get(0).getName());
        assertEquals("Electric", POKEMON.get(0).getFirstType());
        assertEquals("-", POKEMON.get(0).getSecondType());
        assertEquals(190, POKEMON.get(0).getCatchRate());
        assertEquals("Male", POKEMON.get(0).getGender());
        assertTrue(POKEMON.get(0).getCaught());

        assertEquals(31L, POKEMON.get(1).getId());
        assertEquals("Mewtwo", POKEMON.get(1).getName());
        assertEquals("Psychic", POKEMON.get(1).getFirstType());
        assertEquals("-", POKEMON.get(1).getSecondType());
        assertEquals(3, POKEMON.get(1).getCatchRate());
        assertEquals("Neutral", POKEMON.get(1).getGender());
        assertFalse(POKEMON.get(1).getCaught());

        assertEquals(42L, POKEMON.get(2).getId());
        assertEquals("Jolteon", POKEMON.get(2).getName());
        assertEquals("Electric", POKEMON.get(2).getFirstType());
        assertEquals("-", POKEMON.get(2).getSecondType());
        assertEquals(45, POKEMON.get(2).getCatchRate());
        assertEquals("Female", POKEMON.get(2).getGender());
        assertTrue(POKEMON.get(2).getCaught());

        assertEquals(55L, POKEMON.get(3).getId());
        assertEquals("Blastoise", POKEMON.get(3).getName());
        assertEquals("Water", POKEMON.get(3).getFirstType());
        assertEquals("-", POKEMON.get(3).getSecondType());
        assertEquals(1, POKEMON.get(3).getCatchRate());
        assertEquals("Female", POKEMON.get(3).getGender());
        assertFalse(POKEMON.get(3).getCaught());

        assertEquals(100L, POKEMON.get(4).getId());
        assertEquals("Swampert", POKEMON.get(4).getName());
        assertEquals("Water", POKEMON.get(4).getFirstType());
        assertEquals("Ground", POKEMON.get(4).getSecondType());
        assertEquals(255, POKEMON.get(4).getCatchRate());
        assertEquals("Female", POKEMON.get(4).getGender());
        assertFalse(POKEMON.get(4).getCaught());
    }

    @Test
    void testEmptyConstructor() {
        Pokemon emptyPokemon = new Pokemon();
        assertEquals(0L, emptyPokemon.getId());
        assertNull(emptyPokemon.getName());
        assertNull(emptyPokemon.getFirstType());
        assertNull(emptyPokemon.getSecondType());
        assertEquals(0, emptyPokemon.getCatchRate());
        assertNull(emptyPokemon.getGender());
        assertFalse(emptyPokemon.getCaught());
    }

    @Test
    void testValidInput() {
        POKEMON.get(0).setId(1L);  //gültige Eingaben und Tests
        POKEMON.get(1).setId(Long.MAX_VALUE);
        POKEMON.get(2).setId(123456L);

        POKEMON.get(0).setName("pikachu");
        POKEMON.get(1).setName("Mew");
        POKEMON.get(2).setName("eF-eM");
        POKEMON.get(3).setName("uhafnir");

        POKEMON.get(0).setFirstType("fire");

        POKEMON.get(0).setSecondType("ICE");
        POKEMON.get(1).setSecondType("Null");
        POKEMON.get(2).setSecondType("-");

        POKEMON.get(0).setCatchRate(1);
        POKEMON.get(1).setCatchRate(255);
        POKEMON.get(2).setCatchRate(123);

        POKEMON.get(0).setGender("male");
        POKEMON.get(1).setGender("FeMale");
        POKEMON.get(2).setGender("nEuTrAl");

        assertEquals(1L, POKEMON.get(0).getId());
        assertEquals(Long.MAX_VALUE, POKEMON.get(1).getId());
        assertEquals(123456L, POKEMON.get(2).getId());

        assertEquals("pikachu", POKEMON.get(0).getName());
        assertEquals("Mew", POKEMON.get(1).getName());
        assertEquals("eF-eM", POKEMON.get(2).getName());
        assertEquals("uhafnir", POKEMON.get(3).getName());

        assertEquals("fire", POKEMON.get(0).getFirstType());

        assertEquals("ICE", POKEMON.get(0).getSecondType());
        assertEquals("Null", POKEMON.get(1).getSecondType());
        assertEquals("-", POKEMON.get(2).getSecondType());

        assertEquals(1, POKEMON.get(0).getCatchRate());
        assertEquals(255, POKEMON.get(1).getCatchRate());
        assertEquals(123, POKEMON.get(2).getCatchRate());

        assertEquals("male", POKEMON.get(0).getGender());
        assertEquals("FeMale", POKEMON.get(1).getGender());
        assertEquals("nEuTrAl", POKEMON.get(2).getGender());
    }

//    @Test
//    void testInvalidInput() throws InvalidInputException {
//        POKEMON.get(0).setId(0L);  //ungültige Eingaben und Tests
//        POKEMON.get(1).setName(null);
//        POKEMON.get(2).setFirstType("firee");
//        POKEMON.get(3).setSecondType("IC");
//        POKEMON.get(4).setCatchRate(0);
//        POKEMON.get(0).setGender("Null");
//
//        assertThrows(InvalidInputException.class, () -> {POKEMON.get(0).setId(0L);}, "The ID must be bigger than 0.");
//
//        assertEquals(0L, POKEMON.get(0).getId());
//        assertEquals("Mewtwo", POKEMON.get(1).getName());
//        assertEquals("Electric", POKEMON.get(2).getFirstType());
//        assertEquals("-", POKEMON.get(3).getSecondType());
//        assertEquals(255, POKEMON.get(4).getCatchRate());
//        assertEquals("Male", POKEMON.get(0).getGender());
//    }
}
