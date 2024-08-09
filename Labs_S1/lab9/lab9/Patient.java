package lab9;

/**
 * @author: mkz
 * TASK: Extends Class Person,
 *  - add a feature 'social security number',
 *    format ddd-dd-dddd, d for digit, but no need to check format
 *  - Implement all methods in the documentation in Patient.html
 *
 *  HINT: use `super`
 *
 */

public class Patient extends Person{

    // Inherited methods: getName, setName

    private String ssn;

    // ------- Constructor -------
    /**
     * Create a Patient with a default name and a default social security number.
     * The default Ssn is '000-00-0000'
     */
    public Patient(){
        super(); // inherited setName
        setSsn("No social security number yet.");
    }

    /**
     * Create a Patient with name aName and
     *    the default social security number '000-00-0000'
     * @param aName
     */
    public Patient(String aName){
        super(aName); // WHY = super(aName)嗎??? super为什么可以这样用
        setSsn("000-00-0000");
    }

    /**
     * Create a Patient with name aName and social security number aSsn
     * @param aName the name of the patient
     * @param aSsn the social security number
     */
    public Patient(String aName, String aSsn){
        super(aName); //调用 Person 类的构造方法，并传入 aName 参数
        setSsn(aSsn);
    }

    // ------- Helper Methods -------

    /**
     * Set the social security number of this Patient to newSsn
     * @param newSsn
     */
    public void setSsn(String newSsn){
        ssn = newSsn;
    }

    /**
     * Get the social security number of this Patient.
     * @return the social security number of this Patient.
     */
    public String getSsn(){
        return ssn;
    }

    /**
     * Get a string representation of this Patient.
     * @return a string representation of this Patient
     */
    @Override
    public String toString(){
        return super.toString() +
                "\nSocial Security Number: " + getSsn();
    }

    /**
     * Determine if this Patient is equal to otherObj.
     * @param otherObj the object to determine equality with
     * @return true if this Patient is equal to otherObj, false otherwise
     */
    @Override
    public boolean equals(Object otherObj){

        if (otherObj == null) return false;
        if (getClass() != otherObj.getClass()) return false;
        Patient otherPatient = (Patient) otherObj;
        return super.equals(otherPatient) && ssn.equals(otherPatient.ssn);
    }
}
