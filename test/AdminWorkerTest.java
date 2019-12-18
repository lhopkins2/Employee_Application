import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdminWorkerTest {
    AdminWorker a;
    AdminWorker b;

    @Before
    public void setup() throws Exception {
        a = new AdminWorker("John", "Doe", "1234567JJ", 10.5, 11.30, -9.90);
        b = new AdminWorker("John", "Doe", "1234567JJ", 10.5, 11.30, 22.0);
    }

    @Test
    public void validBonus(){
        assertEquals(0, a.getFixedBonus(), .1);
        assertEquals(22.0, b.getFixedBonus(), .1);
    }

    @Test
    public void validSalary(){
        assertEquals(118.65, a.calculateSalary(), .1);
        assertEquals(140.65, b.calculateSalary(), .1);
    }
}
