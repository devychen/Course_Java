import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

/**
 * @author Saile
 */

public class Addressbook {

    private String addressFileName;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public Addressbook(String addressFileName) throws XMLStreamException, FileNotFoundException {
        this.addressFileName = addressFileName;
        load();
    }
    
    /**
     * Return an ArrayList with the Addresses of this instance
     * @return the addresses
     */
    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    /**
     * Return the name of the file of this Addressbook
     * @return the addressFileName
     */
    public String getAddressFileName() {
        return addressFileName;
    }

    /**
     * Set the name of the file of this Adressbook
     * @param addressFileName the addressFileName to set
     */
    public void setAddressFileName(String addressFileName) {
        this.addressFileName = addressFileName;
    }

    /**
     * Save the content to addressFile
     * @param addressFile path to the file the content is written to
     */
    public void saveToFile(String addressFile) throws IOException {
        FileWriter fw = new FileWriter(new File(addressFile));
        generateXML(fw);
        fw.close();
    }

    /**
     * Save to data file
     */
    public void save() throws IOException {
        saveToFile(addressFileName);
    }

    /**
     * Return a String with the XML representation of this instance
     * @return a String with the XML representation of this instance
     */
    public String toString() {
        StringWriter sw = new StringWriter();
        generateXML(sw);
        return sw.toString();
    }

    /**
     * TODO - You are allowed to change the method signature.
     */
    private void load() {

    }

    /**
     * TODO
     * @param w
     */
    private void generateXML(Writer w) {

    }
}
