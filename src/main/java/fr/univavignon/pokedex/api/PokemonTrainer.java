package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/** Name getter.
	 * @return Trainer name.
	 * **/
	public String getName() {
		return name;
	}

	/** Team getter.
	 * @return Trainer team.
	 * **/
	public Team getTeam() {
		return team;
	}
	
	/** Pokedex getter.
	 * @return Trainer pokedex.
	 * **/
	public IPokedex getPokedex() {
		return pokedex;
	}
	
}
