package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that create
 * PokemonTrainer instance.
 * @author Djaghloul Ayoub
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory{

    /**
     * Pokemon metadata provider.
     */
    private IPokemonMetadataProvider metaProvider;
    /**
     * Pokemon factory.
     */
    private IPokemonFactory pokemonFactory;

    /**
     * Constructor of the class PokemonTrainerFactory.
     * @param metaProvider Pokemon metadata provider.
     * @param pokemonFactory Pokemon factory.
     */
    public PokemonTrainerFactory(IPokemonMetadataProvider metaProvider, IPokemonFactory pokemonFactory){
        this.metaProvider = metaProvider;
        this.pokemonFactory = pokemonFactory;
    }


    /**
     * Method to create a PokemonTrainer instance.
     * @param name Trainer name.
     * @param team Trainer team.
     * @param pokedexFactory Pokedex factory.
     * @return PokemonTrainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metaProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
