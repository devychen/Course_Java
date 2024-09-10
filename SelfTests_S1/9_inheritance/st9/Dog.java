package st9;

/**
 * @author mkz
 * TASK: create subclass `Dog` and `Cat` for the abstract `Animal` class
 *
 * Dogs have a name.
 * Dogs are constructed with a hunger level of 30 by default
 * Their hunger level doubles when they play.
 * Their hunger level reduces by half when they eat (use integer division)
 * When they speak, dogs say "Grrrrrr" if the hunger level is >= 50
 * otherwise they say "woof".
 * Dogs can doTricks, which increases the hunger level by 20.
 */

public class Dog extends Animal {

    // instance variables
    private String name;
    private int TRICK_INCREASE = 20;

    /**
     * Constructor. Set name and default hungerlevel.
     */
    public Dog(String aName){
        super(30);
        name = aName;
    }

    public Dog(String aName, int aHungerLevel){
        super(aHungerLevel);
        name = aName;
    }

    @Override
    public void eat() {
        setHungerLevel(getHungerLevel() / 1);
    }

    @Override
    public void play(){
        setHungerLevel(getHungerLevel() * 2);
    }

    public void doTricks(){
        setHungerLevel(getHungerLevel() + TRICK_INCREASE);
    }

    @Override
    public String speak(){
        String voice = "";
        if (getHungerLevel() >= 50)
            voice = "Grrrrrr";
        else
            voice = "woof";
        return voice;
    }

    public String toString(){
        return ("\"" + name + "\" "  + super.toString());
    }


}
