package das2_lab9;
package lab9.yourName.test; // Adjust package structure as per your project setup

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class POSDictTest {
    private POSDict posDict; // Declare an instance of POSDict for testing
    private static final String TEST_FILE_PATH = "test_dict.dat"; // Temporary file for testing

    @Before
    public void setUp() throws IOException {
        // Create a temporary test dictionary file
        File file = new File(TEST_FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(",\t,\n");
            writer.write("?\t.\n");
            writer.write(".\t.\n");
            writer.write("able\tjj\n");
            writer.write("about\tin\n");
            writer.write("about\trb\n");
            writer.write("above\tin\n");
        }
        // Initialize the POSDict instance
        posDict = new POSDict();
    }

    @Test
    public void testMappingFile() {
        try {
            // Test if the map method loads the file correctly without exceptions.
            posDict.map(TEST_FILE_PATH);
            // Check if the word "about" has both "in" and "rb" tags
            assertTrue("POSDict should contain 'about' with tag 'in'", posDict.hasPOS("about", "in"));
            assertTrue("POSDict should contain 'about' with tag 'rb'", posDict.hasPOS("about", "rb"));
        } catch (IOException e) {
            fail("IOException was thrown during testMappingFile: " + e.getMessage());
        }
    }

    @Test
    public void testHasPOSWithValidWordAndTag() {
        try {
            posDict.map(TEST_FILE_PATH);
            assertTrue("POSDict should contain 'able' with tag 'jj'", posDict.hasPOS("able", "jj"));
        } catch (IOException e) {
            fail("IOException was thrown during testHasPOSWithValidWordAndTag: " + e.getMessage());
        }
    }

    @Test
    public void testHasPOSWithInvalidTag() {
        try {
            posDict.map(TEST_FILE_PATH);
            assertFalse("POSDict should not contain 'able' with tag 'rb'", posDict.hasPOS("able", "rb"));
        } catch (IOException e) {
            fail("IOException was thrown during testHasPOSWithInvalidTag: " + e.getMessage());
        }
    }

    @Test
    public void testHasPOSWithNullWord() {
        try {
            posDict.map(TEST_FILE_PATH);
            // Ensure handling of null word input gracefully without crashing
            assertFalse("POSDict should return false for null word input", posDict.hasPOS(null, "jj"));
        } catch (IOException e) {
            fail("IOException was thrown during testHasPOSWithNullWord: " + e.getMessage());
        } catch (NullPointerException npe) {
            fail("NullPointerException was thrown during testHasPOSWithNullWord: " + npe.getMessage());
        }
    }

    @Test
    public void testHasPOSWithNullTag() {
        try {
            posDict.map(TEST_FILE_PATH);
            // Ensure handling of null POS tag input gracefully without crashing
            assertFalse("POSDict should return false for null tag input", posDict.hasPOS("able", null));
        } catch (IOException e) {
            fail("IOException was thrown during testHasPOSWithNullTag: " + e.getMessage());
        } catch (NullPointerException npe) {
            fail("NullPointerException was thrown during testHasPOSWithNullTag: " + npe.getMessage());
        }
    }

    @Test
    public void testHasPOSWithUnknownWord() {
        try {
            posDict.map(TEST_FILE_PATH);
            assertFalse("POSDict should return false for unknown word", posDict.hasPOS("unknownWord", "jj"));
        } catch (IOException e) {
            fail("IOException was thrown during testHasPOSWithUnknownWord: " + e.getMessage());
        }
    }

    @Test
    public void testMappingWithNonExistentFile() {
        try {
            // Attempt to map a non-existent file
            posDict.map("non_existent_file.dat");
            fail("Expected an IOException to be thrown for non-existent file.");
        } catch (IOException e) {
            // Test passed if IOException is caught
            assertTrue("IOException was caught as expected for non-existent file", true);
        }
    }
}
