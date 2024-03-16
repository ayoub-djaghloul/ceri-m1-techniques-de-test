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

        PokemonMetadata example1Metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata example2Metadata = new PokemonMetadata(133, "Aquali", 186, 168, 260);

        Pokemon example1Pokemon = new Pokemon(example1Metadata.getIndex(), example1Metadata.getName(),
                example1Metadata.getAttack(), example1Metadata.getDefense(), example1Metadata.getStamina(),
                613, 64, 4000, 4, 0.56);
        Pokemon example2Pokemon = new Pokemon(example2Metadata.getIndex(), example2Metadata.getName(),
                example2Metadata.getAttack(), example2Metadata.getDefense(), example2Metadata.getStamina(),
                2729, 202, 5000, 4, 1.0);

        pokemons = new ArrayList<>();
        pokemons.add(example1Pokemon);
        pokemons.add(example2Pokemon);
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
        assertEquals(pokemon.getName(), pokedex.getPokemon(0).getName());
        assertEquals(pokemon.getIndex(), pokedex.getPokemon(0).getIndex());
        assertEquals(pokemon.getAttack(), pokedex.getPokemon(0).getAttack());
        assertEquals(pokemon.getDefense(), pokedex.getPokemon(0).getDefense());
        assertEquals(pokemon.getStamina(), pokedex.getPokemon(0).getStamina());
        assertEquals(pokemon.getCp(), pokedex.getPokemon(0).getCp());
        assertEquals(pokemon.getHp(), pokedex.getPokemon(0).getHp());
        assertEquals(pokemon.getDust(), pokedex.getPokemon(0).getDust());
        assertEquals(pokemon.getCandy(), pokedex.getPokemon(0).getCandy());
        assertEquals(pokemon.getIv(), pokedex.getPokemon(0).getIv(), 0.0);

    }

    @Test
    public void testGetPokemons() {
        when(pokedex.getPokemons()).thenReturn(pokemons);
        assertEquals(pokemons.size(), pokedex.getPokemons().size());
    }

    @Test
    public void testGetPokemonsWithComparatorCP() {
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

    @Test
    public void testGetPokemonsWithComparatorIndex() {
        Comparator<Pokemon> indexComparator = Comparator.comparingInt(Pokemon::getIndex);
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(indexComparator);

        when(pokedex.getPokemons(indexComparator)).thenReturn(sortedPokemons);
        List<Pokemon> result = pokedex.getPokemons(indexComparator);

        assertEquals(sortedPokemons.size(), result.size());
        for (int i = 0; i < sortedPokemons.size(); i++) {
            assertEquals(sortedPokemons.get(i), result.get(i));
        }
    }

    @Test
    public void testGetPokemonsWithComparatorName() {
        Comparator<Pokemon> nameComparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(nameComparator);

        when(pokedex.getPokemons(nameComparator)).thenReturn(sortedPokemons);
        List<Pokemon> result = pokedex.getPokemons(nameComparator);

        assertEquals(sortedPokemons.size(), result.size());
        for (int i = 0; i < sortedPokemons.size(); i++) {
            assertEquals(sortedPokemons.get(i), result.get(i));
        }
    }
}
