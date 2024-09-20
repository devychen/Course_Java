package lab10;

import org.junit.Test;
import static org.junit.Assert.*;

public class PatientTest {


    private Patient p1;

    @Test
    public void testPatient_SSN_Valid() {
        try{
            p1 = new Patient("Hana Ono","123-45-6789");
        }catch (SSNFormatException ex)  {
            // when an exception is thrown, print exception message...
            System.out.println("Creation of p1 failed: " + ex.toString());
            // ...and fail the test!!
            fail();
        }
    }

    @Test
    public void testPatient_SSN_NotDigit1() {
        try{
            p1 = new Patient("Hano Ono", "a23-45-6789");
            fail();    // fail because no exception was thrown
        } catch(SSNFormatException ex) {
            // do nothing
        }
    }

    @Test
    public void testPatient_SSN_NotDigit2() {
        try{
            p1 = new Patient("Hano Ono", "123-a5-6789");
            fail();    // fail because no exception was thrown
        } catch(SSNFormatException ex) {
            // do nothing
        }
    }

    @Test
    public void testPatient_SSN_NotDigit3() {
        try{
            p1 = new Patient("Hano Ono", "123-45-a789");
            fail();    // fail because no exception was thrown
        } catch(SSNFormatException ex) {
            // do nothing
        }
    }


    @Test
    public void testPatient_SSN_Null() {
       try{
           p1 = new Patient("Hana Ono", null);
           fail();
       } catch(SSNFormatException ex){
            // do nothing
       }
    }

    @Test
    public void testPatient_SSN_Longer() {
        try{
            p1 = new Patient("Hana Ono", "123-45-67899");
            fail();
        } catch(SSNFormatException ex){
            // do nothing
        }
    }

    @Test
    public void testPatient_SSN_Shorter() {
        try{
            p1 = new Patient("Hana Ono", "123-45-678");
            fail();
        } catch(SSNFormatException ex){
            // do nothing
        }
    }

    @Test
    public void testPatient_SSN_WrongDash() {
        try{
            p1 = new Patient("Hana Ono", "12-345-6789");
            fail();
        } catch(SSNFormatException ex){
            // do nothing
        }
    }
}