package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    private List<PokemonMetadata> pokemonsMetadata;

    // Constructeur de la classe PokemonMetadataProvider sans paramètres
    public PokemonMetadataProvider() {
        this.pokemonsMetadata = new ArrayList<>();

    }

    // Constructeur de la classe PokemonMetadataProvider
    PokemonMetadataProvider(List<PokemonMetadata> pokemonMetadata){
        this.pokemonsMetadata = pokemonMetadata;
    }

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
