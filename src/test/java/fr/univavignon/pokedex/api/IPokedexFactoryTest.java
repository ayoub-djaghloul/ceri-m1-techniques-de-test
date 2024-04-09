package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        // Créez des métadonnées de test pour le Pokémon
        List<PokemonMetadata> testMetadata = new ArrayList<>();
        testMetadata.add(new PokemonMetadata(0, "Bulbasaur", 126, 126, 90));

        // Initialisez PokemonMetadataProvider avec les métadonnées de test
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(testMetadata);
        IPokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);

        // Assuming PokedexFactoryImpl is your real implementation of IPokedexFactory
        IPokedexFactory pokedexFactory = new PokedexFactory();

        // Créez un pokedex en utilisant la factory
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // Créez un Pokémon et vérifiez qu'il n'est pas null
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull("Le Pokémon ne devrait pas être null", pokemon);

        // Assurez-vous que le pokedex n'est pas null
        assertNotNull("Le Pokedex ne devrait pas être null", pokedex);
    }
}
