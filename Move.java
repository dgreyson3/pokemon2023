public class Move
{
    // Private constants
    private static final int MAX_DAMAGE = 25;
    
    private int damage;
    private String name;
    
    public Move(String name, int damage)
    {
        this.name = name;
        if(damage > MAX_DAMAGE)
        {
            this.damage = MAX_DAMAGE;
        }
        else 
        {
            this.damage = damage;
        }
    }
    
    
    // Returns the name of the Move
    public String getName()
    {
        return name;
    }

    // Returns how much damage this Move does
    public int getDamage()
    {
        return damage;
    }

    // Returns a String representation of this Move
    // Example: "Water Gun (15 Damage)"
    public String toString()
    {
        return name + " ("+damage+" Damage)";
    }
}
