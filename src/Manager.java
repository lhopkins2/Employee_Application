import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager extends Employee{
    /**
     * Creates a Manager Employee under the Employee super class
     * @param fName
     * @param lName
     * @param pps
     * @param hoursWorked
     * @param hourlyRate
     */
    private ArrayList<Employee> dept;

    public Manager(String firstName, String lastName, String pps, double hoursWorked, double hourlyRate){
        super(firstName,lastName,pps, hoursWorked,hourlyRate);
        dept = new ArrayList<>();
    }


    /**
     * Gets dept.
     *
     * @return Value of dept.
     */
    public ArrayList<Employee> getDept() {
        return dept;
    }

    /**
     * Sets new dept.
     *
     * @param dept New value of dept.
     */
    public void setDept(ArrayList<Employee> dept) {
        this.dept = dept;
    }

    @Override
    public double calculateSalary() {
        double result = super.getSalary() * .01;
        return super.getSalary() + result;
    }

    public void addDeptEmployee(Employee emp){
        dept.add(emp);
    }

    public boolean removeEmployee(int a){
        try{
            dept.remove(a);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    public int numberOfEmployees(){
        return dept.size();
    }

    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employeeDeptList.xml"));
        dept = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employeeDeptList.xml"));
        out.writeObject(dept);
        out.close();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", ppsNumber='" + getPpsNumber() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                '}';
    }
}
