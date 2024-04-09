package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RocketPokemonFactoryTest extends IPokemonFactoryTest {

    IPokemonFactory iPokemonFactory;
    @BeforeEach
    public void setUp(){
        super.setUp();
        this.iPokemonFactory = new RocketPokemonFactory();
    }

    @Test
    void createPokemonTest() throws PokedexException {
            Pokemon pokemonAquali = iPokemonFactory.createPokemon(133,2729,202,5000,4);

        assertEquals(pokemonAquali.getIndex(), 133);
            assertEquals(pokemonAquali.getCp(), 2729);
            assertEquals(pokemonAquali.getHp(), 202);
            assertEquals(pokemonAquali.getDust(), 5000);
            assertEquals(pokemonAquali.getCandy(), 4);
            assertEquals(pokemonAquali.getIv(), 1.0, 0.001);


        }
}
