package st5;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static final double EPSILON = 0.01;



    @Test
    public void test() {
        Calculator c = new Calculator();
        c.add(5,4);
        double expected1 = 9;
        double actual1 = c.getResult();
        assertEquals(expected1, actual1, EPSILON);

        c.clear();
        c.add(6,2);
        double expected2 = 8;
        double actual2 = c.getResult();
        assertEquals(expected2, actual2, EPSILON);

        c.clear();
        c.add(10,7);
        double expected3 = 17;
        double actual3 = c.getResult();
        assertEquals(expected3, actual3, EPSILON);

        c.add(3);
        double expected4 = 20;
        double actual4 = c.getResult();
        assertEquals(expected4, actual4, EPSILON);

        c.mul(4);
        double expected5 = 80;
        double actual5 = c.getResult();
        assertEquals(expected5, actual5, EPSILON);

        c.div(8);
        double expected6 = 10;
        double actual6 = c.getResult();
        assertEquals(expected6, actual6, EPSILON);

        c.clear();
        c.add(3,5);
        double expected7 = 8;
        double actual7 = c.getResult();
        assertEquals(expected6, actual6, EPSILON);

    }


}
