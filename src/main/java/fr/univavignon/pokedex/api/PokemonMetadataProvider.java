package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;
//use english comments

/**
 * a class that provides metadata for Pokemons.
 * It implements the IPokemonMetadataProvider interface.
 * @see IPokemonMetadataProvider
 * @see PokemonMetadata
 * @see PokedexException
 * @see IPokemonMetadataProvider
 * @author Djaghloul Ayoub
 */

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    /**
     * A list of PokemonMetadata.
     * @see PokemonMetadata
     */
    private List<PokemonMetadata> pokemonsMetadata;

    /**
     * A constructor of the PokemonMetadataProvider class.
     * It initializes the list of Pokemons metadata.
     */
    public PokemonMetadataProvider() {
        this.pokemonsMetadata = new ArrayList<>();

    }

    /**
     * Constructeur of the PokemonMetadataProvider class.
     * @param pokemonMetadata List of Pokemons metadata.
     * @see PokemonMetadata
     * @see List
     * @see ArrayList
     */
    PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadata){
        this.pokemonsMetadata = pokemonMetadata;
    }

    /**
     * Method to return the metadata of a Pokemon.
     * @param index Pokemon metadata to return.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for(PokemonMetadata pokemonMetadata : pokemonsMetadata){
            if(pokemonMetadata.getIndex() == index){
                return pokemonMetadata;
            }
        }
        throw new PokedexException("Pokemon inexistant dans le Pokedex");
    }

}
