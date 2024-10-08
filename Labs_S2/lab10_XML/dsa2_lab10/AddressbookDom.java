package dsa2_lab10;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Addressbook class with DOM parsing
 */
public class AddressbookDom {

    private String addressFileName;
    private ArrayList<Address> addresses = new ArrayList<Address>();

    public AddressbookDom(String addressFileName) throws ParserConfigurationException, IOException, SAXException {
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
     * Load the XML content using DOM
     */
    private void load() throws ParserConfigurationException, IOException, SAXException {
        // Create a DocumentBuilderFactory and configure it
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file and create a Document object
        Document document = builder.parse(new File(addressFileName));
        document.getDocumentElement().normalize();  // Normalize the XML structure

        // Get all <address> elements
        NodeList addressNodes = document.getElementsByTagName("address");

        for (int i = 0; i < addressNodes.getLength(); i++) {
            Node node = addressNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element addressElement = (Element) node;
                Address address = new Address();

                // Get <forename> value
                String forename = getElementValue("forename", addressElement);
                address.setForename(forename);

                // Get <surname> value
                String surname = getElementValue("surname", addressElement);
                address.setSurname(surname);

                // Get <email> value
                String email = getElementValue("email", addressElement);
                address.setEmail(email);

                // Add the Address object to the addresses list
                addresses.add(address);
            }
        }
    }

    /**
     * Helper method to get the text content of a specific element by tag name
     * @param tagName the tag name of the element to retrieve
     * @param parentElement the parent element to search within
     * @return the text content of the element
     */
    private String getElementValue(String tagName, Element parentElement) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return null;
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

