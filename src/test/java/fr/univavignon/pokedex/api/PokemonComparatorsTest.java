package fr.univavignon.pokedex.api;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class PokemonComparatorsTest {

    @Test
    public void testNameComparator() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);

        pokemons.add(pokemon1);
        pokemons.add(pokemon2);

        pokemons.sort(PokemonComparators.NAME);

        assertEquals("Aquali", pokemons.get(0).getName());
        assertEquals("Bulbasaur", pokemons.get(1).getName());
    }

    @Test
    public void testIndexComparator() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);

        pokemons.add(pokemon2);
        pokemons.add(pokemon1);

        pokemons.sort(PokemonComparators.INDEX);

        assertEquals(1, pokemons.get(0).getIndex());
        assertEquals(2, pokemons.get(1).getIndex());
    }

    @Test
    public void testCpComparator() {
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(2, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1.0);

        pokemons.add(pokemon2);
        pokemons.add(pokemon1);

        Collections.sort(pokemons, PokemonComparators.CP);

        assertEquals(613, pokemons.get(0).getCp());
        assertEquals(2729, pokemons.get(1).getCp());
    }



}
