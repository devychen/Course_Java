/**
 * @author: mkz
 * Class description:
 *  Class for a Person.
 *
 *  Pre-conditions:
 *  For set methods: the person has been created.
 *  For test methods: the persons have been created and have values for name and age.
 *
 *  Post-conditions:
 *  Set methods: one or both attributes is assigned a value.
 *  Test methods: true or false is returned.
 *
 *  Based on: Self-Test Question #13 in Chapter 4 (pp. 289-90).
 */

package lab5;

import java.util.*;

public class Person
{
    private String name;
    private int age;
    
    /**
     * Initializes a Person. Reads name and age of a person 
     * from System.in. 
     */
    public void readInput()
    {
        // Create a scanner to ...
        Scanner keyboard = new Scanner(System.in);
        
        // read name...
        System.out.println("What is the person's name?");
        name = keyboard.nextLine();
        
        // and age from System.in
        System.out.println("What is the person's age?");
        age = keyboard.nextInt();
        while (age < 0)
        {
            // Make sure that age is not negative!!!
            System.out.println("Age cannot be negative.");
            System.out.println("Reenter age:");
            age = keyboard.nextInt();
        }
    }
    
    /**
     * Print a description of this Person to System.out
     */
    public void writeOutput()
    {
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }
    
    /**
     * Initializes this Person with name <i>newName</i> and age
     * <i>newAge</i>
     * @param newName - new name of this Person
     * @param newAge  - new age of this Person
     */
    public void set(String newName, int newAge)
    {
        setName(newName);  //Set name...
        setAge(newAge);    // and age         
    }
    
    /**
     * Sets the name of this Person to <i>newName</i>
     * @param newName - new name of this Person
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * Sets the new age of this Person
     * @param newAge  - new age of this Person
     */
    public void setAge(int newAge)
    {
        if (newAge >= 0)
            age = newAge;
        else
        {
            System.out.println("ERROR: Used a negative age.");
            System.exit(0);
        }
    }
    
    /**
     * Returns the name of this Person
     * @return The name of this Person
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the age of this Person
     *@return The age of this Person
     */
    public int getAge()
    {
        return age;
    }


    // TODO : if same person

    /**
     * @param anotherPerson
     * @return True if the same person
     */
    public boolean equals(Person anotherPerson){
        return this.name.equalsIgnoreCase(anotherPerson.getName()) && age == anotherPerson.getAge();
    }


    // TODO: if same name

    /**
     * @param anotherPerson
     * @return True if same name
     */
    public boolean isSameName(Person anotherPerson){
        return this.name.equalsIgnoreCase(anotherPerson.getName());
    }

    // TODO: if same age

    /**
     * @param anotherPerson
     * @return True if same age
     */
    public boolean isSameAge(Person anotherPerson){
        return age == anotherPerson.getAge();
    }

    // TODO: if the instance is older than anotherPerson

    /**
     * @param anotherPerson
     * @return True if older
     */
    public boolean isOlderThan(Person anotherPerson){
        return age > anotherPerson.getAge();
    }

    // TODO: if the instance is younger than anotherPerson.
    /**
     * @param anotherPerson
     * @return True if younger
     */
    public boolean isYoungerThan(Person anotherPerson){
      return age < anotherPerson.getAge();
    }


}

