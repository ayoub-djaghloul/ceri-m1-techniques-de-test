package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{

    PokedexFactory(){//Constructeur par défaut
    }
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
