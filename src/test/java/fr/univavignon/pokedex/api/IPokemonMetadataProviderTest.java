package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() {
        IPokemonMetadataProvider pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

        try {
            when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(
                    new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

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
}
