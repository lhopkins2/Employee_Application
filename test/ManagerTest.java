import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager a;

    @Before
    public void setup() throws Exception {
        a = new Manager("John", "Doe", "1234567JJ", 10.5, 11.30);
        a.addDeptEmployee(a);
    }

    @Test
    public void correctNumberOfEmployees(){
        assertEquals(1, a.numberOfEmployees());
    }

    @Test
    public void correctSalary(){
        assertEquals(119.84, a.calculateSalary(), .1);
    }



}