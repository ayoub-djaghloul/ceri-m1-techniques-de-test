package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

    private IPokemonMetadataProvider metaProvider;
    private IPokemonFactory pokemonFactory;

    public PokemonTrainerFactory(IPokemonMetadataProvider metaProvider, IPokemonFactory pokemonFactory){
        this.metaProvider = metaProvider;
        this.pokemonFactory = pokemonFactory;
    }


    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokedex pokedex = pokedexFactory.createPokedex(metaProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}
