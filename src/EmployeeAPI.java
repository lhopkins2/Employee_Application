import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Collections.swap;

/**
 * Class that performs the majority of calculations
 * and holds methods for the Driver class
 */
public class EmployeeAPI {
    private ArrayList<Employee> employees;

    public EmployeeAPI(){
         employees = new ArrayList<Employee>();
    }


    /**
     * Gets employees.
     *
     * @return Value of employees.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets new employees.
     *
     * @param employees New value of employees.
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee a){
        employees.add(a);
    }

    /**
     *
     * @param a manager dept
     * @param b employee
     * @return
     */
    public boolean addEmployeeToDepartment(int a, int b){
        try {
            Employee man = employees.get(a);
            ((Manager) man).addDeptEmployee(employees.get(b));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    /**
     *
     * @param str
     * @return Employee you are searching
     */
    public Employee searchEmployee(String str){
            for(int i = 0; i < employees.size(); i++){
                if(employees.get(i).getLastName().equalsIgnoreCase(str)){
                    return employees.get(i);
                }
            }
            return null;
    }

    public boolean removeEmployee(int a){
        if(employees.size() >= a){
            employees.remove(a);
            return true;
        }
        else return false;
    }

    public boolean removeEmployeeByDept(int a, int b){
        Employee man = employees.get(a);
        if(((Manager) man).getDept().size() >= b){
            ((Manager) man).removeEmployee(b);
            return true;
        }
        else return false;
    }

    public int numberOfEmployees(){
        return employees.size();
    }

    public String listOfEmployees(){
        if(employees.size() == 0)
            return "No employees stored";
        else {
            String result = "";
            for (int i = 0; i < employees.size(); i++) {
                result = result + i+". " + employees.get(i).toString() + "\n";
            }
            return result;
        }
    }

    public String listManagerEmployees(int a){
        Employee man = employees.get(a);
        String result = "";
        if(((Manager) man).getDept().size() == 0)
            return "This manager has no employees in their department";
        else if(employees.size() < a)
            return "This manager does not exist";
        else
            for (int i = 0; i < ((Manager) man).getDept().size(); i++){
                result = result + i+". " +((Manager) man).getDept().get(i) + "\n";
            }
            return result;
    }

    public String listManagerEmployeesFromManager(Employee manager){
        Employee man = manager;
        String result = "";
        if(((Manager) man).getDept().size() == 0)
            return "This manager has no employees in their department";
        else
            for (int i = 0; i < ((Manager) man).getDept().size(); i++){
                result = result + i+". " +((Manager) man).getDept().get(i) + "\n";
            }
        return result;
    }
    public double totalSalariesOwed(){
        double result = 0.0;
        for(int i = 0; i < employees.size(); i++){
            result += employees.get(i).calculateSalary();
        }
        return result;
    }

    public double averageSalaryOwed(){
        double result = 0;
        for(int i = 0; i < employees.size(); i++){
            result += employees.get(i).calculateSalary();
        }
        return result/employees.size();
    }

    public Employee employeeWithHighestPay(){
        Employee temp = employees.get(0);

        for(Employee emp : employees){
            if(emp.calculateSalary() > temp.calculateSalary())
                temp = emp;
        }
        return temp;
    }

    /**
     * Uses Collections and comparator methods from java
     * @return String
     *
    public String sortEmployeesByFirstName(){
        String result = "";
        Collections.sort(employees, Comparator.comparing(Employee::getFirstName));
        for (int i = 0; i < employees.size(); i++){
            result = result + i+". " + employees.get(i).toString()+ "\n";
        }
        return result;
    }*/
    /**
     * Swap to be used in sort methods
     * private because never used outside om EmployeeAPI
     */
    private void swapEmployees(ArrayList<Employee> employees, int a, int b) {
        Employee tmp = employees.get(a);
        employees.set(a, employees.get(b));
        employees.set(b, tmp);
    }

    /**
     * The new sortByFirstName
     *  @return String of employees order alphabetically be first name
     */
    public String sortEmployeesByFirstName() {
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(i).getFirstName().compareTo(employees.get(j).getFirstName()) < 0) {
                    swapEmployees(employees, employees.indexOf(employees.get(i)), employees.indexOf(employees.get(j)));
                     j = 0;
                }
            }

        }
        return listOfEmployees();
    }

    /**
     * Sorted using collections class
    public String sortEmployeesByLastName(){
        String result = "";
        Collections.sort(employees, Comparator.comparing(Employee::getLastName));
        for (int i = 0; i < employees.size(); i++){
            result = result + i+". " + employees.get(i).toString() +"\n";
        }
        return result;
    }
     */

    public String sortEmployeesByLastName() {
        for (int i = 0; i < employees.size(); i++) {
            for (int j = 0; j < employees.size(); j++) {
                if (employees.get(i).getLastName().compareTo(employees.get(j).getLastName()) < 0) {
                    swapEmployees(employees, employees.indexOf(employees.get(i)), employees.indexOf(employees.get(j)));
                    j = 0;
                }
            }

        }
        return listOfEmployees();
    }

    /**
     * Uses Collections class
    public String sortEmployeesByHourlyRate() {
        String result = "";
        Collections.sort(employees, Comparator.comparing(Employee::getHourlyRate).reversed());
        for (int i = 0; i < employees.size(); i++) {
            result = result + i + ". " + employees.get(i).toString() + "\n";
        }
        return result;
    }
     */

    /**
     * Sorts employees and lists then by hourly rate
     * @return  list of the employees in order by hourly rate
     */
    public String sortEmployeesByHourlyRate() {
        for (int i = 0; i < employees.size(); i++) {
            for (int k = 0; k < employees.size(); k++) {
                if (employees.get(i).getHourlyRate() < employees.get(k).getHourlyRate()) {
                    swapEmployees(employees, employees.indexOf(employees.get(i)), employees.indexOf(employees.get(k)));
                    k = 0;
                }
            }
        }
        return listOfEmployees();
    }

    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employeeList.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employeeList.xml"));
        out.writeObject(employees);
        out.close();
    }
}
