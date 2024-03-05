package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        IPokedexFactory pokedexFactory = new IPokedexFactory() {
            @Override
            public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
                return new IPokedex() {
                    @Override
                    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
                        return null;
                    }

                    @Override
                    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
                        return null;
                    }

                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public int addPokemon(Pokemon pokemon) {
                        return 0;
                    }

                    @Override
                    public Pokemon getPokemon(int id) throws PokedexException {
                        return null;
                    }

                    @Override
                    public List<Pokemon> getPokemons() {
                        return null;
                    }

                    @Override
                    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
                        return null;
                    }
                };
            }
        };

        // on crée un pokedex
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        // on assure que le pokedex n'est pas null
        assertNotNull(pokedex);
    }
}
