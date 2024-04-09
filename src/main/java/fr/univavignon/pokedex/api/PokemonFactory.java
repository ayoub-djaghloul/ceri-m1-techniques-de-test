package fr.univavignon.pokedex.api;

/**
 * Classe permettant de créer des instances de Pokémon.
 * Elle implémente l'interface IPokemonFactory.
 * @see IPokemonFactory
 * @see Pokemon
 * @author Djaghloul Ayoub
 */
public class PokemonFactory implements IPokemonFactory  {


    /**
     * Fournisseur de métadonnées Pokémon.
     */
    private IPokemonMetadataProvider pokemonMetadataProvider;

    /**
     * Constructeur de la classe PokemonFactory.
     * @param pokemonMetadataProvider le fournisseur de métadonnées Pokémon
     */
    public PokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }


    /**
     * Crée une nouvelle instance de Pokémon à partir des statistiques spécifiées.
     * @param index l'index du Pokémon
     * @param cp les points de combat du Pokémon
     * @param hp les points de vie du Pokémon
     * @param dust la poussière d'étoile nécessaire pour améliorer le Pokémon
     * @param candy le nombre de bonbons nécessaire pour améliorer le Pokémon
     * @return le Pokémon créé
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonMetadata metadata = null;
        try {
            metadata = pokemonMetadataProvider.getPokemonMetadata(index);

        // Calculer les IVs (Valeurs Individuelles) en fonction des statistiques fournies
        double iv = calculateIV(cp, hp, dust, candy);

        return new Pokemon(index,  metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, iv);
        } catch (PokedexException e) {
            e.printStackTrace();
            return null;
        }
        }
    /**
     * Méthode privée pour calculer les IVs d'un Pokémon.
     * @param cp les points de combat du Pokémon
     * @param hp les points de vie du Pokémon
     * @param dust la poussière d'étoile nécessaire pour améliorer le Pokémon
     * @param candy le nombre de bonbons nécessaire pour améliorer le Pokémon
     * @return l'IV du Pokémon
     */
    // Méthode privée pour calculer les IVs
    private double calculateIV(int cp, int hp, int dust, int candy) {
        // Implémentation simplifiée pour le calcul des IVs
        return (double) (cp + hp + dust + candy) / 100;
    }
}
