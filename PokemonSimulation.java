public class PokemonSimulation extends ConsoleProgram
{
    private PokemonImages images = new PokemonImages();
    
    public void run()
    {
        
        System.out.println("Welcome the Pokemon Simulator!\n");
        System.out.println("Set up first Pokemon Trainer:");
        
        PokemonTrainer player1 = new PokemonTrainer(readLine("Trainer, what is your name? "));
        System.out.println("Hello "+player1+"!\n");
        setup(player1);
        PokemonTrainer player2 = new PokemonTrainer(readLine("Trainer, what is your name? "));
        System.out.println("Hello "+player2+"!\n");
        setup(player2);
        
        
        while(!player1.hasLost()&& !player2.hasLost() ) 
        {
            trainerMove(player1,player2);
            if(player2.hasLost()){break;}
            trainerMove(player2,player1);
        }
        System.out.println(player1.hasLost() ? ""+player2+" wins!":""+player2+" wins!");
    }
    public void trainerMove(PokemonTrainer player1,PokemonTrainer player2)
    {
        readLine("Press Enter to start battle!");
            System.out.println(player1.getNextPokemon());
            System.out.println("Possible Moves:\n"+player1.getNextPokemon().getMoves());
            String inp = readLine(player1 + " choose your Move:");
            while(!player1.getNextPokemon().knowsMove(inp))
            {
                inp = readLine(player1 + " choose your Move:");
            }
            System.out.println(player1 + "'s "+player1.getNextPokemon().getName()+" uses "+inp+ " on "+player2+"'s " +player2.getNextPokemon().getName());
            Pokemon p2 = player2.getNextPokemon();
            player1.getNextPokemon().attack(player2.getNextPokemon(),inp);
            if(p2.hasFainted())
            {
                System.out.println(p2.getName()+" has fainted!");
            }
    }
    public void setup(PokemonTrainer player)
    {
        String[] x = {"first","second"};
        for(int i=0;i<2;i++)
        {
            System.out.println("Choose your "+x[i]+" pokemon");
            Pokemon p1 = new Pokemon(readLine("Enter the name of your pokemon: "));
    
            System.out.println("You chose:\n" + p1);
            while(p1.canLearnMoreMoves())
            {
                if(!readLine("Would you like to teach "+p1.getName()+" a new move? ").equals("yes"))
                {
                    break;
                }
                String name = readLine("Enter the name of the move: ");
                int dmg = readInt("How much damage does this move do? ");
                Move m1 = new Move(name,dmg);
                System.out.println(p1.learnMove(m1) ? p1.getName() + " has learned "+m1:p1.getName() + "failed to learn ");
            }
            System.out.println(p1.getName()+" has learned all of their moves");
            player.addPokemon(p1);
        }
    }
}
