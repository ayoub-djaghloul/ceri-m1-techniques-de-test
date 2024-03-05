package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = new IPokedexFactory() {
            @Override
            public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return mock(IPokedex.class);
            }
        };

        trainerFactory = new IPokemonTrainerFactory() {
            @Override
            public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
                return new PokemonTrainer(name, team, pokedexFactory.createPokedex(null, null));
            }
        };
    }

    @Test
    public void testCreateTrainer() {
        Team team = mock(Team.class);
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", team, pokedexFactory);
        assertNotNull(trainer);

        assertEquals("Ash", trainer.getName());
        assertEquals(team, trainer.getTeam());
    }

}
