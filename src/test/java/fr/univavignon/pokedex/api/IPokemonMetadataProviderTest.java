package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        // Initialisation avec des données test pour PokémonMetadata
        PokemonMetadata pikachuMetadata = new PokemonMetadata(25, "Pikachu", 55, 40, 90);
        PokemonMetadata bulbasaurMetadata = new PokemonMetadata(1, "Bulbasaur", 45, 49, 45);
        metadataProvider = new PokemonMetadataProvider(Arrays.asList(pikachuMetadata, bulbasaurMetadata));
    }
    @Test
    public void testGetPokemonMetadata() {
        try {
        List<PokemonMetadata> testMetadata = new ArrayList<>();
        // Add test metadata.
        testMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));
        IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider(testMetadata);



        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(0);

        assertNotNull(pokemonMetadata);
        assertEquals(0, pokemonMetadata.getIndex());
        assertEquals("Bulbasaur", pokemonMetadata.getName());
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGetPokemonMetadataExists() throws PokedexException {
        // Test pour un Pokémon existant
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(25); // Pikachu
        assertNotNull(metadata);
        assertEquals("Pikachu", metadata.getName());
    }
    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataNotExists() throws PokedexException {
        // Test pour un Pokémon inexistant, devrait lancer une PokedexException
        metadataProvider.getPokemonMetadata(999); // Index 999 n'existe pas
    }
}
