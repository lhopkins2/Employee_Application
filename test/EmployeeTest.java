import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmployeeTest {
    Manager a;

    @Before
    public void setup() throws Exception{
        a = new Manager("John", "Doe", "1234567JJ", 10.5, 11.30);
    }

    @Test
    public void validConstructor(){
        assertEquals("John", a.getFirstName());
        assertEquals("Doe", a.getLastName());
        assertEquals("1234567JJ", a.getPpsNumber());
        assertEquals(10.5, a.getHoursWorked(), .1);
        assertEquals(11.30, a.getHourlyRate(), .1);
    }

    @Test
    public void validSalary(){
        assertEquals(118.65, a.getSalary(), .1);
    }
}
