import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmployeeAPITest {
    Manager a;
    AdminWorker b;
    SalesWorker c;
    EmployeeAPI api;

    @Before
    public void setup() throws Exception {
        api = new EmployeeAPI();
        a = new Manager("John", "Doe", "1234567JJ", 10.5, 11.30);
        b = new AdminWorker("Pete", "Wavy", "7654321HH", 40.1, 9.80, 8);
        c = new SalesWorker("David", "Brown", "1234567AA", 36.7, 10.22, 14.0);
        api.addEmployee(a);
        api.addEmployee(b);
        api.addEmployee(c);
        api.addEmployeeToDepartment(0,2);
    }

    @Test
    public void validEmployeeDept(){
        assertFalse(api.addEmployeeToDepartment(2, 1));
        assertTrue(api.addEmployeeToDepartment(0,1));
    }

    @Test
    public void validSearch(){
        assertEquals(b, api.searchEmployee("Wavy"));
        assertEquals(c, api.searchEmployee("bROWN"));
    }

    @Test
    public void validDeptList(){
        assertEquals("0. SalesWorker{firstName='David', lastName='Brown', ppsNumber='1234567AA', hoursWorked=36.7, hourlyRate=10.22, percentBonus=14.0}\n", api.listManagerEmployees(0));
    }

    @Test
    public void correctSalaryTotalAndAverage(){
        assertEquals((a.calculateSalary() + b.calculateSalary()+ c.calculateSalary()), api.totalSalariesOwed(), .1);
        assertEquals((a.calculateSalary() + b.calculateSalary()+ c.calculateSalary())/3, api.averageSalaryOwed(), .1);
    }

    @Test
    public void correctHighestPaidEmployee(){
        assertEquals(b, api.employeeWithHighestPay());
    }
}