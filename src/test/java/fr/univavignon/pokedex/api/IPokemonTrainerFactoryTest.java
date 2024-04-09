package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private PokemonMetadataProvider metadataProvider;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        metadataProvider = new PokemonMetadataProvider();
        trainerFactory = new PokemonTrainerFactory(metadataProvider, new PokemonFactory(metadataProvider));
    }

    @Test
    public void testCreateTrainer() {
        Team team = Team.MYSTIC;
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", team, pokedexFactory);
        assertNotNull(trainer);

        assertEquals("Ash", trainer.getName());
        assertEquals(team, trainer.getTeam());
        assertEquals(0, trainer.getPokedex().size());
    }

}
