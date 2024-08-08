package lab5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A JUnit test case class. Every method starting with the word "test" will be
 * called when running the test with JUnit.
 */
public class PersonTest {

    /**
     * Tests for the same age (Expect true)
     */
    @Test
    public void testSameAge1() {
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Jim Knopf", 12);
        assertTrue(testPerson.isSameAge(testPerson2));
    }

    /**
     * Tests for the same age (Expect false)
     */
    @Test
    public void testSameAge2() {
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Lukas Lokomotivfuehrer", 38);
        assertFalse(testPerson.isSameAge(testPerson2));
    }

    // TODO: More tests to follow.....

    /**
     * Test for the same name
     */
    @Test
    public void testSameName1() {
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Jim Knopf", 38);
        assertTrue(testPerson.isSameName(testPerson2));
    }

    public void testSameName2() {
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Lukas Lokomotivfuehrer", 38);
        assertFalse(testPerson.isSameName(testPerson2));
    }

    /**
     * Test for the same person
     */
    @Test
    public void testSamePerson1(){
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Jim Knopf", 12);
        assertTrue(testPerson.equals(testPerson2));
    }

    @Test
    public void testSamePerson2(){
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Lukas Lokomotivfuehrer", 38);
        assertFalse(testPerson.equals(testPerson2));
    }

    /**
     * Test for the instance is older
     */
    @Test
    public void testOlder1(){
        Person testPerson = new Person();
        testPerson.set("Lukas Lokomotivfuehrer", 38);
        Person testPerson2 = new Person();
        testPerson2.set("Jim Knopf", 12);
        assertTrue(testPerson.isOlderThan(testPerson2));
    }

    @Test
    public void testOlder2(){
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Lukas Lokomotivfuehrer", 38);
        assertFalse(testPerson.isOlderThan(testPerson2));
    }

    /**
     * Test for the instance is younger
     */
    @Test
    public void testYounger1(){
        Person testPerson = new Person();
        testPerson.set("Jim Knopf", 12);
        Person testPerson2 = new Person();
        testPerson2.set("Lukas Lokomotivfuehrer", 38);
        assertTrue(testPerson.isYoungerThan(testPerson2));
    }

    @Test
    public void testYounger2(){
        Person testPerson = new Person();
        testPerson.set("Lukas Lokomotivfuehrer", 38);
        Person testPerson2 = new Person();
        testPerson2.set("Jim Knopf", 12);
        assertFalse(testPerson.isYoungerThan(testPerson2));
    }
}
