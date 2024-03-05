package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon() {
        Pokemon expectedPokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);

        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(expectedPokemon);

        Pokemon actualPokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(expectedPokemon, actualPokemon);
    }
}
