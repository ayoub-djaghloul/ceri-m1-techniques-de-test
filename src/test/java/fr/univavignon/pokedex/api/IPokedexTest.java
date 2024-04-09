package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IPokedexTest {

    private IPokedex pokedex;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;
    private List<Pokemon> pokemons;

    @Before
    public void setUp() {
        // Create instances of the required dependencies
        metadataProvider = new PokemonMetadataProvider();
        pokemonFactory = new PokemonFactory(metadataProvider);

        // Use these instances to construct a real Pokedex object
        pokedex = new Pokedex(metadataProvider, pokemonFactory);


        Pokemon example1Pokemon = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon example2Pokemon = new Pokemon(133, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 1.0);

        pokemons = new ArrayList<>();
        pokemons.add(example1Pokemon);
        pokemons.add(example2Pokemon);

        pokedex.addPokemon(example1Pokemon);
        pokedex.addPokemon(example2Pokemon);
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size()); // Assuming you added 2 Pokemons in setUp
    }

    @Test
    public void testAddPokemon() {
        Pokemon newPokemon = new Pokemon(3, "Charmander", 128, 96, 78, 613, 64, 4000, 4, 0.56);
        int indexBefore = pokedex.size();
        pokedex.addPokemon(newPokemon);
        assertEquals(indexBefore + 1, pokedex.size());
        assertEquals("Charmander", newPokemon.getName());

    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0); // Assuming the first added Pokemon has index 0
        assertEquals("Bulbasaur", pokemon.getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonWithInvalidIndex() throws PokedexException {
        pokedex.getPokemon(-1); // Ensure your method actually throws an exception for this case
    }


    @Test
    public void testGetPokemonHP() throws PokedexException {
        Pokemon pokemon = pokedex.getPokemon(0);
        assertEquals(64, pokemon.getHp());
    }

    @Test
    public void testGetPokemonDust() throws PokedexException {
        Pokemon pokemon = pokemons.get(0);
        assertEquals(pokemon.getDust(), pokedex.getPokemon(0).getDust());
    }

    @Test
    public void testGetPokemonCandy() throws PokedexException {
        Pokemon pokemon = pokemons.get(0);
        assertEquals(pokemon.getCandy(), pokedex.getPokemon(0).getCandy());
    }

    @Test
    public void testGetPokemonIv() throws PokedexException {
        Pokemon pokemon = pokemons.get(0);
        assertEquals(pokemon.getIv(), pokedex.getPokemon(0).getIv(), 0.0);
    }

    @Test
    public void testGetPokemonsWithComparatorCP() {
        Comparator<Pokemon> cpComparator = Comparator.comparingInt(Pokemon::getCp);
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(cpComparator);

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

        List<Pokemon> result = pokedex.getPokemons(indexComparator);

        assertEquals(sortedPokemons.size(), result.size());
        for (int i = 0; i < sortedPokemons.size(); i++) {
            assertEquals(sortedPokemons.get(i), result.get(i));
        }
    }

    @Test
    public void testGetPokemonsReturnsAll() {
        List<Pokemon> allPokemons = pokedex.getPokemons();
        assertEquals(2, allPokemons.size()); // Vérifie si tous les Pokémon sont retournés
        assertTrue(allPokemons.containsAll(pokemons)); // Vérifie si les Pokémon retournés sont ceux ajoutés
    }

    @Test
    public void testGetPokemonsWithOrder() {
        Comparator<Pokemon> nameComparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedByName = pokedex.getPokemons(nameComparator);

        // Assurez-vous que la liste est triée par nom
        assertEquals("Bulbasaur", sortedByName.get(0).getName());
        assertEquals("Vaporeon", sortedByName.get(1).getName());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataForNonExistentPokemon() throws PokedexException {
        // Tente de récupérer les métadonnées pour un index qui n'existe pas
        metadataProvider.getPokemonMetadata(999);
    }


}
