package st9;

/**
 * A class to simulate animals
 * SelfTest Inheritance
 *
 * DO NOT CHANGE THE CLASS
 */
public abstract class Animal
{
    
    private int hungerLevel;
    
    // must be defined in derived classes
    public abstract void play();
    public abstract String speak();
    
    /**
     * Default constructor.
     * Animal is not hungry.
     */
    public Animal()
    {
        hungerLevel = 0;
    }
    
    /**
     * Constructor with an initial hunger level
     * @param aHungerLevel level of hunger
     */
    public Animal(int aHungerLevel)
    {
        hungerLevel = aHungerLevel;
    }
    
    /**
     * Get hunger level.
     * @return the hunger level
     */
    public int getHungerLevel()
    {
        return hungerLevel;
    }
    
    /**
     * Set hunger level.
     * @param aLevel the new hunger level
     */
    public void setHungerLevel(int aLevel)
    {
        hungerLevel = aLevel;
    }
    
    /**
     * Animal is not hungry after eating.
     */
    public void eat()
    {
        hungerLevel = 0;
    }
    
    /**
     * @return String representation of an animal
     */
    public String toString()
    {
        return "(" + getClass().getName() + "): [" +
            "hungerLevel: " + hungerLevel + "] " +
            speak();        
    }
}
