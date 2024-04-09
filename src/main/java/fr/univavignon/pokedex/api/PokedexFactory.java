package fr.univavignon.pokedex.api;

/**
 * a factory class that creates a new instance of pokedex.
 * @author Djaghloul Ayoub
 * @see IPokedexFactory
 * @see IPokedex
 * @see Pokedex
 * @see IPokemonMetadataProvider
 */
public class PokedexFactory implements IPokedexFactory{

    /**
     * Default constructor.
     */
    PokedexFactory(){

    }

    /**
     * Method to create a pokedex instance.
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
