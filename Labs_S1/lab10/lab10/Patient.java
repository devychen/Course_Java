package lab10;

/**
 * Class that extends Person class by adding a Social Security Number
 *
 * @author: mkz
 *
 * TASK: to handle invalid ssn:
 *   Add a static boolean method `isValidSsn(String aSsn)`.
 *   This method must check whether aSsn conforms to the template 'ddd-dd-dddd',
 *   where every 'd' in the template stands for a digit and the '-' for a '-' character.
 *
 *   Important: Don't use regex for this task
 *
 */

public class Patient extends Person {
    private String ssn;    // social security number (3-2-4 format preferred)
    
    /**
     * Create a Patient with a default name and a default social security number
     */
    public Patient() {
        super();
        setSsn("000-00-0000");
    }
    
    /**
     * Create a Patient with name <i>aName</i> and the default social security number
     * @param aName the name of the patient
     */
    public Patient (String aName)  {
        super(aName);
        setSsn("000-00-0000");
    }
    
    /**
     * Create a Patient with name <i>aName</i> and social security number <i>aSsn</i>
     * @param aName the name of the patient
     * @param aSsn the social security number
     */
    public Patient (String aName, String aSsn) {
        super(aName);
        setSsn(aSsn);
    }
    
    /**
     * Get a string representation of this Patient
     * @return a string representation of this Patient
     */
    public String toString() {
        return super.toString()+";Ssn: "+ssn;
    }
    
    /**
     * Set the social security number of this Patient to <i>newSsn</i>
     * @param newSsn The new social security number of this Patient
     */
    public void setSsn(String newSsn) {
        ssn = newSsn;
    }
    
    /**
     * Get the social security number of this Patient
     * @return the social security number of this Patient
     */
    public String getSsn() {
        return ssn;
    }
    
    /**
     * Determine if this Patient is equal to <i>otherObj</i>
     * @param otherObj the object to determine equality with
     * @return true if this Patient is equal to otherObj, false otherwise
     */
    public boolean equals(Object otherObj) {
        if (otherObj == null) {
            return false;
        }
        if (getClass() != otherObj.getClass()) {
            return false;
        }
        
        Patient aPatient = (Patient) otherObj;
        return(super.equals(aPatient)
                   && this.ssn.equalsIgnoreCase(aPatient.getSsn()));
    }
}
