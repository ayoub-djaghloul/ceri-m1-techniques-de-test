package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * IPokedex interface. An IPokedex aims to store all information about
 * captured pokemon, as their default metadata as well.
 * 
 * @author fv
 */
public interface IPokedex extends IPokemonMetadataProvider, IPokemonFactory {
	
	/**
	 * Returns the number of pokemon this pokedex contains.
	 * 
	 * @return Number of pokemon in this pokedex.
	 */
	int size();
	
	/**
	 * Adds the given <code>pokemon</code> to this pokedex and returns
	 * it unique index.
	 * 
	 * @param pokemon Pokemon to add to this pokedex.
	 * @return Index of this pokemon relative to this pokedex.
	 */
	int addPokemon(Pokemon pokemon);
	
	/**
	 * Locates the pokemon identified by the given <code>id</code>.
	 * 
	 * @param id Unique pokedex relative identifier.
	 * @return Pokemon denoted by the given identifier.
	 * @throws PokedexException If the given <code>index</code> is not valid.
	 */
	Pokemon getPokemon(int id) throws PokedexException;
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
	List<Pokemon> getPokemons();

	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <code>order</code>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
	List<Pokemon> getPokemons(Comparator<Pokemon> order);
	
}
