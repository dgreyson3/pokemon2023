import java.util.ArrayList;
public class PokemonTrainer
{
    // private constants
    public static final int MAX_POKEMON = 2;
    private String name;
    ArrayList<Pokemon> team = new ArrayList<Pokemon>();
    
    public PokemonTrainer(String name)
    {
        this.name = name;
    }
    // Write your PokemonTrainer class here
    /*
     * Adds Pokemon p to the PokemonTrainer's collection of Pokemon.
     * A Player is only allowed MAX_POKEMON Pokemon, so this method
     * will return true if there was room for the new Pokemon and
     * it was successfully added, false if there was no room for the
     * new Pokemon.
     */
    public boolean addPokemon(Pokemon p)
    {
        if(team.size() < MAX_POKEMON)
        {
            team.add(p);
            return true;
        }
        return false;
    }
    
    /*
     * Returns true if all of the PokemonTrainer's Pokemon
     * have fainted, false otherwise.
     */
    public boolean hasLost()
    {
        for(int i=0;i<team.size();i++)
        {
            if(!team.get(i).hasFainted())
            {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Returns the first Pokemon that has not yet fainted
     * from this PokemonTrainer's collection of Pokemon.
     * If every Pokemon has fainted, this method returns null.
     */
    public Pokemon getNextPokemon()
    {
        for(int i=0;i<team.size();i++)
        {
            if(!team.get(i).hasFainted())
            {
                return team.get(i);
            }
        }
        return null;
    }
    
    // Returns this PokemonTrainer's name
    public String toString()
    {
        return name;
    }
}
