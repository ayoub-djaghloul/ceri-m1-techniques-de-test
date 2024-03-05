package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    private IPokedex pokedex;
    private List<Pokemon> pokemons;

    @Before
    public void setUp() {
        pokedex = mock(IPokedex.class);

        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(0, "pikatcho", 100, 100, 100, 632, 100, 4000, 4, 0.66));
        pokemons.add(new Pokemon(2, "ach", 220, 220, 160, 3000, 200, 20000, 20, 0.9));


    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(pokemons.size());
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon newPokemon = new Pokemon(3, "Charmander", 128, 96, 78, 613, 64, 4000, 4, 0.56);
        int expectedIndex = 3;

        when(pokedex.addPokemon(newPokemon)).thenReturn(expectedIndex);

        int actualIndex = pokedex.addPokemon(newPokemon);

        assertEquals(expectedIndex, actualIndex);
    }


    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokemons.get(0);
        when(pokedex.getPokemon(0)).thenReturn(pokemon);
        assertEquals(pokemon, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(pokemons);
        assertEquals(pokemons.size(), pokedex.getPokemons().size());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(cpComparator);

        when(pokedex.getPokemons(cpComparator)).thenReturn(sortedPokemons);
        List<Pokemon> result = pokedex.getPokemons(cpComparator);

        assertEquals(sortedPokemons.size(), result.size());
        for (int i = 0; i < sortedPokemons.size(); i++) {
            assertEquals(sortedPokemons.get(i), result.get(i));
        }
    }
}
