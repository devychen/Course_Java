package lab9;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * @author: mkz
 *
 * TASK: test for Patient.class, but not required.
 */


public class PatientTest {

    private Patient patient;
    private Patient namedPatient;
    private Patient fullPatient;

    // 初始化三个不同的 Patient 对象
    @Before
    public void setUp() {
        patient = new Patient();
        namedPatient = new Patient("Hana Ono");
        fullPatient = new Patient("Hana Ono", "123-45-6789");
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("No social security number yet.", patient.getSsn());
        assertEquals("No name yet.", patient.getName());
    }

    @Test
    public void testNameConstructor2(){
        assertEquals("Hana Ono", namedPatient.getName());
        assertEquals("000-00-0000", namedPatient.getSsn());
    }

    @Test
    public void testFullConstructor3(){
        assertEquals("Hana Ono", fullPatient.getName());
        assertEquals("123-45-6789", fullPatient.getSsn());
    }

    @Test
    public void testSetSsn(){
        fullPatient.setSsn("987-65-4321");
        assertEquals("987-65-4321", fullPatient.getSsn());
    }

    /**
     * 实际上已经在前面间接测试过了，完全是copy+paste，其实可以不写
     */
    @Test
    public void testGetSsn(){
        assertEquals("No social security number yet.", patient.getSsn());

        assertEquals("123-45-6789", fullPatient.getSsn());

        fullPatient.setSsn("987-65-4321");
        assertEquals("987-65-4321", fullPatient.getSsn());
    }

    @Test
    public void testToString(){
        String expected = "Name: Hana Ono" +
                          "\nSocial Security Number: 123-45-6789";
        assertEquals(expected, fullPatient.toString());
    }

    @Test
    public void testEquals1(){
        Patient anotherPatient = new Patient("Hana Ono", "123-45-6789");
        assertTrue(fullPatient.equals(anotherPatient));
    }

    /**
     * Same ssn, different name
     */
    @Test
    public void testEquals2(){
        Patient anotherPatient = new Patient("Umi Ono", "123-45-6789");
        assertFalse(patient.equals(anotherPatient));
    }

    /**
     * Different ssn & name
     */
    @Test
    public void testEquals3(){
        Patient anotherPatient = new Patient("Umi Ono", "987-65-4321");
    }
}


/**
 * why use `@Before`
 * 减少重复:
 * 每个测试方法都需要使用 defaultPatient、namedPatient 和 fullPatient 这三个对象。
 * 如果没有 @Before，您需要在每个测试方法中都创建这些对象，这会导致代码重复。
 *
 * 确保一致性:
 * 假设某个测试方法修改了 fullPatient 的 ssn，
 * @Before 方法确保每个测试方法都从相同的对象状态开始，不受其他测试方法中修改的影响。
 */