/**
 * Main entry point of Assignment 2
 *
 * @author Liam Hopkins
 * @module Programming Funds 2
 * @date 24/11/2019
 */
public class Driver {
    private EasyScanner input;
    private EmployeeAPI empAPI;

    public Driver(){
        empAPI = new EmployeeAPI();
        input = new EasyScanner();
        runMenu();
    }

    public static void main(String[] args){
        new Driver();
    }

    private int mainMenu() {
        System.out.println("Organization Menu");
        System.out.println("---------");
        System.out.println("  1) Add an employee (Manager)");
        System.out.println("  2) Add an employee (Sales worker)");
        System.out.println("  3) Add an employee (Admin worker)");
        System.out.println("  4) Add an existing employee to a department");
        System.out.println("  5) Delete an employee");
        System.out.println("  6) Delete an employee from a manager");
        System.out.println("  --------------------");
        System.out.println("  7) Find the total of the salaries owed to all the employees");
        System.out.println("  8) Find the average of the salaries owed to all the employees");
        System.out.println("  9) Print the employee with the highest pay");
        System.out.println("  10) Print the number of Employees");
        System.out.println("  --------------------");
        System.out.println("  11) List all employees in alphabetical order by first name");
        System.out.println("  12) List all employees in alphabetical order by last name");
        System.out.println("  13) List all employees in order by their hourly rate");
        System.out.println("  ------------------");
        System.out.println("  14) Search the system for an employee by second name");
        System.out.println("  15) Search for an employee through a manager's department");
        System.out.println("  -------");
        System.out.println("  16) Save to XML");
        System.out.println("  17) Load from XML");
        System.out.println("  -------");
        System.out.println("  0) Exit");
        System.out.print(" ==>>");
        return input.nextInt();
    }

    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addManager();
                    break;
                case 2:
                    addSalesWorker();
                    break;
                case 3:
                    addAdminWorker();
                    break;
                case 4:
                    addEmployeeToDepartment();
                    break;
                case 5:
                    removeEmployeeByName();
                    break;
                case 6:
                    removeEmployeeByDept();
                    break;
                case 7:
                    System.out.println(empAPI.totalSalariesOwed());
                    break;
                case 8:
                    System.out.println(empAPI.averageSalaryOwed());
                    break;
                case 9:
                    System.out.println(empAPI.employeeWithHighestPay());
                    break;
                case 10:
                    System.out.println(empAPI.numberOfEmployees());
                    break;
                case 11:
                    System.out.println(empAPI.sortEmployeesByFirstName());
                    break;
                case 12:
                    System.out.println(empAPI.sortEmployeesByLastName());
                    break;
                case 13:
                    System.out.println(empAPI.sortEmployeesByHourlyRate());
                    break;
                case 14:
                    searchEmployeeBySecondName();
                    break;
                case 15:
                    searchEmployeeByManagerDepartment();
                    break;
                case 16:
                    try{
                        empAPI.save();;
                    }
                    catch(Exception e){
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 17:
                    try{
                        empAPI.load();
                    }
                    catch(Exception e){
                        System.err.println("Error reading from file: " + e);
                    }
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            //pause the program so that the user can read what we just printed to the terminal window
            System.out.println("\nPress any key to continue...");
            input.nextString();

            //display the main menu again
            option = mainMenu();
        }

        //the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }

    public void addManager(){
        System.out.print("Enter the first name of the manager: ");
        String fName = input.nextString();
        System.out.println();
        System.out.print("Enter the last name of the manager: ");
        String lName = input.nextString();
        System.out.println();
        System.out.print("Enter the pps number of the manager: ");
        String pps = input.nextString();
        System.out.println();
        System.out.print("Enter the amount of hours worked by the manager: ");
        double hoursWorked = input.nextDouble();
        System.out.println();
        System.out.print("Enter the hourly rate of the manager: ");
        double hourlyRate = input.nextDouble();
        System.out.println();

        Manager a = new Manager(fName, lName, pps, hoursWorked, hourlyRate);
        empAPI.addEmployee(a);
    }

    public void addSalesWorker() {
        System.out.print("Enter the first name of the Sales Worker: ");
        String fName = input.nextString();
        System.out.println();
        System.out.print("Enter the last name of the Sales Worer: ");
        String lName = input.nextString();
        System.out.println();
        System.out.print("Enter the pps number of the Sales Worker: ");
        String pps = input.nextString();
        System.out.println();
        System.out.print("Enter the amount of hours worked by the Sales Worker: ");
        double hoursWorked = input.nextDouble();
        System.out.println();
        System.out.print("Enter the hourly rate of the Sales Worker: ");
        double hourlyRate = input.nextDouble();
        System.out.println();
        System.out.print("Enter the percent bonus of the Sales Worker: ");
        double bonus = input.nextDouble();
        System.out.println();

        SalesWorker a = new SalesWorker(fName, lName, pps, hoursWorked, hourlyRate, bonus);
        empAPI.addEmployee(a);
    }

    public void addAdminWorker(){
        System.out.print("Enter the first name of the Admin Worker: ");
        String fName = input.nextString();
        System.out.println();
        System.out.print("Enter the last name of the Admin Worker: ");
        String lName = input.nextString();
        System.out.println();
        System.out.print("Enter the pps number of the Admin Worker: ");
        String pps = input.nextString();
        System.out.println();
        System.out.print("Enter the amount of hours worked by the Admin Worker: ");
        double hoursWorked = input.nextDouble();
        System.out.println();
        System.out.print("Enter the hourly rate of the Admin Worker: ");
        double hourlyRate = input.nextDouble();
        System.out.println();
        System.out.print("Enter the fixed bonus of the Admin Worker: ");
        double bonus = input.nextDouble();
        System.out.println();

        AdminWorker a = new AdminWorker(fName, lName, pps, hoursWorked, hourlyRate, bonus);
        empAPI.addEmployee(a);
    }

    public void addEmployeeToDepartment(){
        System.out.println("Enter the index of the manager's department");
        System.out.println(empAPI.listOfEmployees());
        System.out.print(">>> ");
        int choice = input.nextInt();
        System.out.println();
        System.out.print("Enter the index of the employee: ");
        int emp = input.nextInt();

        empAPI.addEmployeeToDepartment(choice, emp);
    }

    public void removeEmployeeByName(){
        int test = 0;
        System.out.print("Enter the first name of the employee you'd like to remove: ");
        String name = input.nextString();
        for(int i = 0; i < empAPI.getEmployees().size(); i++){
                if(empAPI.getEmployees().get(i).getFirstName().equalsIgnoreCase(name)) {
                    empAPI.removeEmployee(i);
                    test = 1;
                }
        }
        if(test == 0)
            System.out.println("That employee does not exist");
    }

    public void removeEmployeeByDept(){
        System.out.println("Enter the index of the manager's department");
        System.out.println(empAPI.listOfEmployees());
        System.out.print(">>> ");
        int choice = input.nextInt();
        System.out.println();
        System.out.println("Enter the index of the employee: ");
        System.out.println(empAPI.listManagerEmployees(choice));
        System.out.print(">>> ");
        int emp = input.nextInt();

        if(empAPI.removeEmployeeByDept(choice, emp))
            empAPI.removeEmployeeByDept(choice, emp);
        else System.out.println("That employee does not exist");
    }

    public void searchEmployeeBySecondName(){
        System.out.print("Enter the last name of the employee you'd like details on: ");
        String name = input.nextString();
        Employee a = null;
        for(int i = 0; i < empAPI.getEmployees().size(); i++) {
            if (empAPI.getEmployees().get(i).getLastName().equalsIgnoreCase(name))
                a = empAPI.getEmployees().get(i);
        }
        if(a != null)
            System.out.println(a.toString());
        else System.out.println("That employee does not exist");
    }

    public void searchEmployeeByManagerDepartment(){
        System.out.println("Enter the index of the manager's department you'd like to list");
        System.out.println(empAPI.listOfEmployees());
        System.out.print(">>>");
        int choice = input.nextInt();
        System.out.println(empAPI.listManagerEmployees(choice));
        System.out.println("Enter the index of the employee you'd like to see details on: ");
        int emp = input.nextInt();
        System.out.println(empAPI.getEmployees().get(emp).toString());
    }

}
