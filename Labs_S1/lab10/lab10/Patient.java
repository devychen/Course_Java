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
    private String ssn;    // social  security number (3-2-4 format preferred)

    /**
     * Create a Patient with a default name and a default social security number
     */
    public Patient() throws SSNFormatException {
        super();
        setSsn("000-00-0000");
    }

    /**
     * Create a Patient with name <i>aName</i> and the default social security number
     *
     * @param aName the name of the patient
     */
    public Patient(String aName) throws SSNFormatException {
        super(aName);
        setSsn("000-00-0000");
    }

    /**
     * Create a Patient with name <i>aName</i> and social security number <i>aSsn</i>
     *
     * @param aName the name of the patient
     * @param aSsn  the social security number
     */
    public Patient(String aName, String aSsn) throws SSNFormatException {
        super(aName);
        setSsn(aSsn);
    }

    /**
     * Get a string representation of this Patient
     *
     * @return a string representation of this Patient
     */
    public String toString() {
        return super.toString() + ";Ssn: " + ssn;
    }

    /**
     * Set the social security number of this Patient to <i>newSsn</i>
     *
     * @param newSsn The new social security number of this Patient
     */
    public void setSsn(String newSsn) throws SSNFormatException {
        ssn = newSsn;
        if (isValidSsn(ssn) == false) {
            throw new SSNFormatException();
        }
    }

    /**
     * Get the social security number of this Patient
     *
     * @return the social security number of this Patient
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Determine if this Patient is equal to <i>otherObj</i>
     *
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
        return (super.equals(aPatient)
                && this.ssn.equalsIgnoreCase(aPatient.getSsn()));
    }

    // todo

    /**
     * Handle invalid ssn.
     * Check whether aSsn conforms to the template 'ddd-dd-dddd',
     * *   where every 'd' in the template stands for a digit and the '-' for a '-' character.
     *
     * @param aSsn
     * @return true if valid, false otherwise
     */
    public boolean isValidSsn(String aSsn) {

        if(aSsn == null || aSsn.length() != 11){
            return false;
        }

        boolean invalidSsn1 = false;
        boolean invalidSsn2 = false;
        boolean invalidSsn3 = false;
        boolean validSsn4 = false;

        // 000 index 0,1,2
        for (int i = 0; i < 3; i++){
            if(!Character.isDigit(aSsn.charAt(i))){
                invalidSsn1 = true;
            }
        }

        // 00, index 4,5
        for (int i = 4; i < 6; i++){
            if(!Character.isDigit(aSsn.charAt(i))){
                invalidSsn2 = true;
            }
        }

        // 0000, index 7, 8, 9, 10
        for (int i = 7; i < 11; i++){
            if(!Character.isDigit(aSsn.charAt(i))){
                invalidSsn3 = true;
            }
        }

        // dash '-', index 3, 6
        if (aSsn.charAt(3) == '-' && aSsn.charAt(6) == '-'){
            validSsn4 = true;
        }

        // overall
        return !invalidSsn1 && !invalidSsn2 && !invalidSsn3 && validSsn4;


//        // A simpler version...?
//        if (aSsn == null && aSsn.length() != 11) {
//            return false;
//        }
//
//        for (int i = 0; i < aSsn.length(); i++) {
//            if (i == 3 || i == 6) {
//                if (aSsn.charAt(i) != '-') {
//                    return false;
//                }
//            } else {
//                if (!Character.isDigit(aSsn.charAt(i))) {
//                    return false;
//                }
//            }
//        }
//        return true;

    }
}

