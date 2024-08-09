package lab10;

/**
 * A class to represent a person
 */
public class Person {

    private String name;

    /**
     * Construct a Person with a default name
     */
    public Person() {
        setName("No name yet.");
    }

    /**
     * Construct a Person with a name
     * @param initialName the person's name
     */
    public Person(String initialName) {
        setName(initialName);
    }

    /**
     * Change this person's name to newName
     * @param newName the person's new name
     */
    public void setName(String newName) {
       name = newName;
    }

    /**
     * Get this person's name
     * @return this person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get a string representation of this person
     * @return a string representation of this person
     */
    public String toString() {
        return "Name: " + name;
    }

    /**
     * Determine if this Person is equal to otherObj
     * @param otherObj the object to determine equality with
     * @return true if this Person is equal to otherObj, false otherwise
     */
    public boolean equals(Object otherObj) {

        if (otherObj == null) {
            return false;
        }

        if (getClass() != otherObj.getClass()) {
            return false;
        }

        Person otherPerson = (Person) otherObj;
        return name.equalsIgnoreCase(otherPerson.name);
    }
}
