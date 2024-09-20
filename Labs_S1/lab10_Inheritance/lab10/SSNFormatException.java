package lab10;

/**
 * @author: mkz
 *
 * TASK:
 * Create an exception class SSNFormatException which extends Exception.
 * Your Patient class should throw an SSNFormatException whenever
 *   an invalid social security number is assigned to a Patient.
 * Please change your Patient class accordingly.
 * Update PatientTest to test the new behaviour of your Patient.
 */

public class SSNFormatException extends Exception{
    public SSNFormatException(){
        super("Invalid SSN format");
    }
    public SSNFormatException(String message){
        super(message);
    }
}
