package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;
    private IPokemonMetadataProvider metadataProvider;



    @Before
    public void setUp() {
        List<PokemonMetadata> testMetadata = new ArrayList<>();
        // Add test metadata.
        testMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        metadataProvider = new PokemonMetadataProvider(testMetadata);
        pokemonFactory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {

        Pokemon pokemon=pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        // Ensure the Pokemon is not null
        assertNotNull("Pokemon should be created successfully", pokemon);

        // Verify the Pokemon's properties
        assertEquals("Incorrect Pokemon index", 0, pokemon.getIndex());
        assertEquals("Incorrect CP", 613, pokemon.getCp());
        assertEquals("Incorrect HP", 64, pokemon.getHp());
        assertEquals("Incorrect dust amount", 4000, pokemon.getDust());
        assertEquals("Incorrect candy count", 4, pokemon.getCandy());

        // Additionally, verify the metadata-related properties
        assertEquals("Incorrect name", "Bulbasaur", pokemon.getName());
        assertEquals("Incorrect attack stat", 126, pokemon.getAttack());
        assertEquals("Incorrect defense stat", 126, pokemon.getDefense());
        assertEquals("Incorrect stamina stat", 90, pokemon.getStamina());

        double expectedIv = (613 + 64 + 4000 + 4) / 100.0;
        assertEquals("Incorrect IV calculation", expectedIv, pokemon.getIv(), 0.01);


    }
}
