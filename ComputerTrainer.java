public class ComputerTrainer extends PokemonTrainer
{
    // private constants
    // Possible pokemon names and move names to generate random Pokemon
    private static final String[] POKEMON_NAMES = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle"};
	private static final String[] MOVE_NAMES = {"Tailwhip", "Bodyslam", "Splash", "Shock"};
	private static final int MAX_DAMAGE = 25;
	private static final int MAX_MOVES = 4;
	
	
	private PokemonImages images = new PokemonImages();

    // Write your ComputerTrainer class here!
    
    // Write a Constructor that sets the name of the ComputerTrainer
    // and adds 2 randomly generated Pokemon to itself
    public ComputerTrainer(String name)
    {
        super(name);
        addRandomPokemon();
        addRandomPokemon();
    }
    
    /*
     * Adds a randomly generated Pokemon to this ComputerTrainer's
     * collection of Pokemon. A ComputerTrainer can only have 2
     * Pokemon. This method returns true if there was room for the 
     * new Pokemon and it was successfully added, false otherwise.
     */
    public boolean addRandomPokemon()
    {
        if(MAX_POKEMON <= team.size()){return false;}
        Pokemon p1 = new Pokemon(POKEMON_NAMES[Randomizer.nextInt(3)]);
        Move m1 = new Move(MOVE_NAMES[Randomizer.nextInt(3)],Randomizer.nextInt(25));
        p1.learnMove(m1);
        team.add(p1);
        return true;
    }
    
    // Returns a Move randomly chosen from the set of Moves
    // that this trainer's current Pokemon knows.
    // If all Pokemon have fainted, returns null.
    public Move chooseRandomMove()
    {
        if(hasLost()){ return null;}
        Pokemon current = getNextPokemon();
        
        return current.getMoves().get(0);
    }
    
}
