package dsa2_lab3;

/**
 * @author mkz
 * TASK: ex3. write a JUnit test to verify ur XML checker
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class XMLCheckerTest {

    @Test
    public void testSimpleValidXML(){
        assertTrue(XMLChecker.wellformedXML
                ("<tag></tag>"));
        assertTrue(XMLChecker.wellformedXML
                ("<tag> some data </tag>"));
    }

    @Test
    public void testComplexValidXML1() {
        assertTrue(XMLChecker.wellformedXML
                ("<rootTag><anotherTag>text text text</anotherTag></rootTag>"));
    }
    @Test
    public void testComplexValidXML2() {
        assertTrue(XMLChecker.wellformedXML
                ("<aTag>data<anotherTag>text text text</anotherTag></aTag>"));
    }
    @Test
    public void testComplexValidXML3(){
        assertTrue(XMLChecker.wellformedXML
                ("<tag> <emptyTag/> </tag>"));
    }

    @Test
    public void testEmptyXML(){
        assertFalse(XMLChecker.wellformedXML(null));
        assertFalse(XMLChecker.wellformedXML(""));
    }

    @Test
    public void testWrongBeginningXML(){
        assertFalse(XMLChecker.wellformedXML
                ("abc"));
        assertFalse(XMLChecker.wellformedXML
                ("abc<tag></tag>"));
        assertFalse(XMLChecker.wellformedXML
                ("</tag>"));
    }

    @Test
    public void testWrongEndingXML(){
        assertFalse(XMLChecker.wellformedXML
                ("<tag>abc</tag>abc"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag></tag"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag></tag>>"));
    }

    @Test
    public void testObviousValidXML(){
        assertFalse(XMLChecker.wellformedXML
                ("<>"));
        assertFalse(XMLChecker.wellformedXML
                ("</>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag<>data</tag>"));
    }

    @Test
    public void testInvalidXML() {
        assertFalse(XMLChecker.wellformedXML
                ("<tag>data</Tag>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag></tag>data<tag></tag>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag></ta/g>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag><tag></tag></tag>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tags> <something> </something> <tags> </aTag> </aTag>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag1> </tag1> <tag2></tag2>"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag> text>text </tag>"));
    }

    @Test
    public void testValidAttribute() {
        assertTrue(XMLChecker.wellformedXML
                ("<tag attribute=\"anAttribute\"> text </tag>"));
        assertTrue(XMLChecker.wellformedXML
                ("<person age=\"54\"> J.K. Rowling </person>"));
    }

    @Test
    public void testInvalidAttribute() {
        assertFalse(XMLChecker.wellformedXML
                ("<tag anAttribute=\"aValue\"> text </tag anAttribute=\"aValue\">"));
        assertFalse(XMLChecker.wellformedXML
                ("<tag attribute> random data</tag>"));
    }
}
