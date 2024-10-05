package dsa2_lab10;

import java.io.*;
import java.util.ArrayList;
import javax.xml.stream.*; // use this instead
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
//import javax.xml.stream.XMLStreamException;

/**
 * @author Saile (Source codes)
 * @author mkz
 * TASK: Complete the missing methods
 *      given
 *      the Class Address.java for reference,
 *      the AddressbookTest.java for testing
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
     * to write an XML document with StAX:
     * Step 1: get XMLEvents
     */
    private void load() throws XMLStreamException, FileNotFoundException {
        Address address = null;
        XMLInputFactory factory = XMLInputFactory.newInstance(); // the iterator
        XMLEventReader reader = factory.createXMLEventReader(new FileReader(addressFileName)); // to iterate
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent(); // iterating through all XMLEvents (XML components) in the whole XML doc
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                switch (startElement.getName().getLocalPart()){
                    case "address":
                        //NOTE??? event=reader.nextEvent();
                        //  在此时还不需要处理其内部的子元素（如 <forename>、<surname> 等），所以没有必要去读取下一个事件
                        address = new Address();
                        break;
                    case "forename":
                        event = reader.nextEvent();
                        address.setForename(event.asCharacters().getData()); // read them as characters
                        break;
                    case "surname":
                        event = reader.nextEvent();
                        address.setSurname(event.asCharacters().getData());
                        break;
                    case "email":
                        event = reader.nextEvent();
                        address.setEmail(event.asCharacters().getData());
                        break;
                }
            }
            if (event.isEndElement()){
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equals("address"))
                    addresses.add(address); // add to arraylist addresses, the IV of class AddressBook
            }

            /*
            对于 <forename>、<surname>、<email> 等元素的内容读取，
            一般是通过 Characters 事件来获取文本数据，而不是依赖 EndElement 事件。
            因此，只需要在遇到 StartElement 标签时切换解析状态，
            并使用 Characters 事件来读取标签中的内容。
            结束标签（EndElement）对于这些子元素来说并不影响解析结果。
             */
        }
    }

    /**
     * TODO
     * Step 2: Write XMLEvents
     * @param w the Writer obj to write XMLEvents to the file
     */
    private void generateXML(Writer w) throws XMLStreamException {
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance(); // API enables apps to obtain XML writers
        XMLEventWriter writer = outputFactory.createXMLEventWriter(w); // Interface writes XML doc
        XMLEventFactory eventFactory = XMLEventFactory.newInstance(); // Interface creates instances of XMLEvents

        Characters indent = eventFactory.createCharacters("\t");
        Characters newLine = eventFactory.createCharacters("\n");

        if(!addresses.isEmpty()){
            // Root: addressbook
            writer.add(eventFactory.createStartDocument());
            StartElement startRoot = eventFactory.createStartElement("","","addressbook");
            writer.add(newLine);
            writer.add(startRoot);

            for (Address address: addresses){
                // StartElement: <address>
                StartElement startaddress = eventFactory.createStartElement("","","address");
                writer.add(newLine);
                writer.add(indent);
                writer.add(startaddress);
                // Element: <forename>
                writer.add(newLine);
                writer.add(indent);
                writer.add(indent);
                StartElement startforename = eventFactory.createStartElement("", "", "forename");
                writer.add(startforename);
                Characters contentforename = eventFactory.createCharacters(address.getForename());
                writer.add(contentforename);
                EndElement endforename = eventFactory.createEndElement("", "","forename");
                writer.add(endforename);
                // Element <surname>
                writer.add(newLine);
                writer.add(indent);
                writer.add(indent);
                StartElement startsurname = eventFactory.createStartElement("", "", "surname");
                writer.add(startsurname);
                Characters contentsurname = eventFactory.createCharacters(address.getForename());
                writer.add(contentsurname);
                EndElement endsurname = eventFactory.createEndElement("", "","surname");
                writer.add(endsurname);
                // Element <email>
                writer.add(newLine);
                writer.add(indent);
                writer.add(indent);
                StartElement startemail = eventFactory.createStartElement("", "", "email");
                writer.add(startemail);
                Characters contentemail = eventFactory.createCharacters(address.getForename());
                writer.add(contentemail);
                EndElement endemail = eventFactory.createEndElement("", "","email");
                writer.add(endemail);
                // End Element <address>
                writer.add(newLine);
                writer.add(indent);
                EndElement endaddress = eventFactory.createEndElement("", "", "address");
                writer.add(endaddress);
            }
            EndElement endRoot = eventFactory.createEndElement("", "", "addressbook");
            writer.add(newLine);
            writer.add(endRoot);
            writer.add(eventFactory.createEndDocument());
            writer.close();
        }
    }
}
