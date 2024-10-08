package dsa2_lab10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Addressbook class with SAX parsing
 */
public class AddressbookSax {

    private String addressFileName;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public AddressbookSax(String addressFileName) throws IOException, SAXException {
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
     * Set the name of the file of this Addressbook
     * @param addressFileName the addressFileName to set
     */
    public void setAddressFileName(String addressFileName) {
        this.addressFileName = addressFileName;
    }

    /**
     * Load the XML content using SAX
     */
    private void load() throws IOException, SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                Address address = null;
                String content = null;

                // When the start of an element is found
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    switch (qName) {
                        case "address":
                            address = new Address();
                            break;
                    }
                }

                // When characters are found inside an element
                public void characters(char[] ch, int start, int length) throws SAXException {
                    content = new String(ch, start, length);
                }

                // When the end of an element is found
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    switch (qName) {
                        case "forename":
                            if (address != null) address.setForename(content);
                            break;
                        case "surname":
                            if (address != null) address.setSurname(content);
                            break;
                        case "email":
                            if (address != null) address.setEmail(content);
                            break;
                        case "address":
                            if (address != null) addresses.add(address);
                            break;
                    }
                }
            };

            saxParser.parse(new FileInputStream(addressFileName), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Save the content to a specified address file
     * @param addressFile path to the file to write to
     */
    public void saveToFile(String addressFile) throws IOException {
        // Implementation would be the same as before
    }

    /**
     * Save to data file
     */
    public void save() throws IOException {
        saveToFile(addressFileName);
    }

    /**
     * Generate XML content as a string representation
     * @return a String with the XML representation of this instance
     */
    public String toString() {
        // Implementation would be the same as before
        return "";
    }
}
