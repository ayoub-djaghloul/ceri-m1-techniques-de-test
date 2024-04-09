package fr.univavignon.pokedex.api;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Classe représentant le Pokedex, implémentant l'interface IPokedex.
 * @author Djaghloul Ayoub
 */
public class Pokedex implements IPokedex {
    private final List<Pokemon> pokemons = new ArrayList<>();
    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    /**
     * Construit une instance de Pokedex avec le fournisseur de métadonnées et la fabrique de Pokémon spécifiés.
     * @param metadataProvider le fournisseur de métadonnées Pokémon
     * @param pokemonFactory la fabrique pour créer des instances de Pokémon
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Retourne le nombre de Pokémon dans le Pokedex.
     * @return le nombre de Pokémon
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Ajoute un Pokémon au Pokedex.
     * @param pokemon le Pokémon à ajouter
     * @return l'index du Pokémon ajouté
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1; // Retourne l'index du Pokémon ajouté
    }

    /**
     * Retourne le Pokémon correspondant à l'index spécifié.
     * @param id l'index du Pokémon
     * @return le Pokémon correspondant
     * @throws PokedexException si l'index est invalide
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("ID invalide : " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Retourne la liste des Pokémon du Pokedex.
     * @return la liste des Pokémon
     */
    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons); // Retourne une copie pour éviter la modification extérieure
    }

    /**
     * Retourne la liste des Pokémon du Pokedex, triée selon l'ordre spécifié.
     * @param order le comparateur pour trier les Pokémon
     * @return la liste des Pokémon triée
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);
        return sortedPokemons;
    }

    /**
     * Crée un Pokémon à partir des statistiques spécifiées.
     * @param index l'index du Pokémon
     * @param cp les points de combat du Pokémon
     * @param hp les points de vie du Pokémon
     * @param dust la poussière d'étoile nécessaire pour améliorer le Pokémon
     * @param candy le nombre de bonbons nécessaire pour améliorer le Pokémon
     * @return le Pokémon créé
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    /**
     * Retourne les métadonnées du Pokémon correspondant à l'index spécifié.
     * @param index l'index du Pokémon
     * @return les métadonnées du Pokémon
     * @throws PokedexException si l'index est invalide
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

}