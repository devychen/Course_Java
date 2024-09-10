package st9;

/**
 * @author mkz
 * TASK: create subclass `Dog` and `Cat` for the abstract `Animal` class
 *
 * Cats have a name.
 * Cats are constructed with a hunger level of 10 by default
 * Their hunger level increases by 20 when they play.
 * Their hunger level reduces to zero when they eat.
 * If the hunger level is >= 85 they say "REOW",
 * if 30 <= hunger level < 85, they say "meow",
 * otherwise they say "purrrr"
 * Cats can catchMice, which decreases the hunger level by half.
 */

public class Cat extends Animal {


    private String name;
    private int PLAY_INCREASE = 20;

    /**
     * Constructor to set name and hunger level
     * @param aName
     */
    public Cat(String aName) {
        super(10);
        name = aName;
    }

    public Cat(String aName, int aHungerLevel){
        super(aHungerLevel);
        name = aName;
    }

    /**
     * Their hunger level increases by 20 when they play.
     */
    @Override
    public void play(){
        setHungerLevel(getHungerLevel() + PLAY_INCREASE);
    }

    /**
     * Cats can catchMice, which decreases the hunger level by half.
     */
    public void catchMice(){
        setHungerLevel(getHungerLevel() / 2);
    }

    /**
     * Their hunger level reduces to zero when they eat.
     */
    public void eat(){
        super.eat();
    }

    @Override
    public String speak(){
        String voice ="";
        if (getHungerLevel() >= 85){
            voice = "REOW";
        } else if (getHungerLevel() >= 30 && getHungerLevel() < 85){
            voice = "meow";
        } else {
            voice = "purrrr";
        }
        return voice;
    }

    public String toString(){
        return ("\"" + name + "\"" + super.toString());
    }

}
