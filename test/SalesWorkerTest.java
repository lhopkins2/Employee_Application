import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SalesWorkerTest {
    SalesWorker a;
    SalesWorker b;

    @Before
    public void setup() throws Exception {
        a = new SalesWorker("John", "Doe", "1234567JJ", 10.5, 11.30, 9.90);
        b = new SalesWorker("John", "Doe", "1234567JJ", 10.5, 11.30, 22.0);
    }

    @Test
    public void validPercentBonus(){
        assertEquals(9.9, a.getPercentBonus(), .1);
        assertEquals(0.0, b.getPercentBonus(), .1);
    }

    @Test
    public void validSalary(){
        assertEquals(128.55, a.calculateSalary(), .1);
        assertEquals(118.65, b.calculateSalary(), .1);
    }

}
