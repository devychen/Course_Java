### Exercise 1 5 / 5

### Exercise 2 3 / 5
* -1p. because you are missing constructor in SSNFormatException
* -1p. because you don't update your Patient class accordingly, you should throw exception from every constructor in the class.

Best,  
Mario




**Main contents: Chapter9, Savitch**

The deadline for submitting the lab is **Friday, Jan 19th 2:00 PM CET**.
# Lab 10

Last week we created a class Patient which extends Person. Unfortunately, a user can create a Patient with an invalid social security number because we did not validate ssn. We need to prevent this from happening.

**Important:** For this exercise, please use the Person and Patient class files provided in this repository.

**Note:** Don't forget to add the honour code to every file in which you have changed the code


## Exercise 1

Add a static boolean method `isValidSsn(String aSsn)` to class Patient. This method must check whether aSsn conforms to the template 'ddd-dd-dddd', where every 'd' in the template stands for a digit and the '-' for a '-' character.

Create a class PatientTest and add tests for your new method.
(Don't forget to submit PatientTest)

**Important:** Don't use regex for this task

(5 points)

## Exercise 2

Create an exception class SSNFormatException which extends Exception. Your Patient class should throw an SSNFormatException whenever an invalid social security number is assigned to a Patient. Please change your Patient class accordingly.

Update PatientTest to test the new behaviour of your Patient.

(5 points)

### How to test exceptions

Write a test where you either expect an exeption to be thrown, or you don't expect an exception. When you expect an exception, the test must fail when no exception is thrown. When you don't expect an exception, the test must fail when an exception is thrown

### Expect an Exception

Here the Patient has a correct name and an incorrect social security number. An Exception must be thrown.

```java
try{

Patient p1 = new Patient("Jim Knopf","a23-45-6789");

fail();    // fail because no exception was thrown
}

catch (SSNFormatException ex)  {

        // do nothing
        }
```

### Don't expect an Exception

Here the Patient has a correct name and a correct social security number. No Exception should be thrown.

```java
try  {

    Patient p1 = new Patient("Jim Knopf","123-45-6789");
}

catch (SSNFormatException ex)  {

    // when an exception is thrown, print exception message...
    System.out.println("Creation of p1 failed: " + ex.toString());

    // ...and fail the test!!
    fail();
}
```