
//TODO JavaDoc
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class UtilitiesTest {
//No need for fields here as using all methods as static.

    SalesWorker a;
    SalesWorker b;
    @Before
    public void setup() throws Exception {
        a = new SalesWorker("John", "Doe", "1234567JJ", 10.5, 11.30, 9.90);
        b = new SalesWorker("John", "Doe", "1234567JJ", 10.5, 11.30, 22.0);
    }
    //TODO - change this to max10Chars
    @Test
    public void max10Chars() {
        assertEquals("1234567890", Utilities.max10Chars("1234567890"));
        assertEquals("1234567890", Utilities.max10Chars("1234567890-123"));
        assertEquals("", Utilities.max10Chars(""));
    }



    @Test
    public void validIntRange() {
        assertTrue(Utilities.validIntRange(1, 10, 5));
        assertTrue(Utilities.validIntRange(1, 10, 1));
        assertTrue(Utilities.validIntRange(1, 10, 10));
        assertFalse(Utilities.validIntRange(1, 10, 0));
        assertFalse(Utilities.validIntRange(1, 10, 11));

    }

    @Test
    public void validIntNonNegative() {
        assertTrue(Utilities.validIntNonNegative(0));
        assertTrue(Utilities.validIntNonNegative(1));
        assertTrue(Utilities.validIntNonNegative(1000));
        assertFalse(Utilities.validIntNonNegative(-1));


    }


   @Test
    public void validIndex() {
        ArrayList<Employee> strs = new ArrayList<>();
        strs.add(a);
        strs.add(b);
        assertTrue(Utilities.validIndex(1, strs));
        assertTrue(Utilities.validIndex(0, strs));
        assertFalse(Utilities.validIndex(-1, strs));
        assertFalse(Utilities.validIndex(4, strs));
    }

    @Test
    public void validPercentBonus() {
        //TODO - Write validPercentBonus()
    }

    @Test
    public void validDoubleNonNegative() {
        //TODO - Write validDoubleNonNegative()
    }


    @Test
    public void validPPS() {
        assertTrue(Utilities.validPPS("1234567JK"));
        assertTrue(Utilities.validPPS("1234567jj"));
        assertFalse(Utilities.validPPS(""));
        assertFalse(Utilities.validPPS("1234JJ"));
        assertFalse(Utilities.validPPS("1234567JJJ"));
        assertFalse(Utilities.validPPS("123456789J"));
        assertFalse(Utilities.validPPS("12345678J"));
    }

}
