public abstract class Employee {
    /**
     * Is the parent super class for all Employee types
     * @param fName
     * @param lName
     * @param pps
     * @param hoursWorked
     * @param hourlyRate
     * @param NORMAL_WORKWEEK
     * @param MIN_WAGE
     */
    private String firstName;
    private String lastName;
    private String ppsNumber;
    private double hoursWorked;
    private double hourlyRate;
    private static double NORMAL_WORKWEEK;
    private static double MIN_WAGE;

    public Employee(String firstName, String lastName, String ppsNumber, double hoursWorked, double hourlyRate){
        NORMAL_WORKWEEK = 39.5;
        MIN_WAGE = 9.80;
        this.firstName = firstName;
        this.lastName = lastName;
        if (Utilities.validPPS(ppsNumber))
                this.ppsNumber = ppsNumber;
        else this.ppsNumber = "Invalid PPS Number";
        if(Utilities.validDoubleNonNegative(hoursWorked))
            this.hoursWorked = hoursWorked;
        else this.hoursWorked = 0;
        if(Utilities.validDoubleNonNegative(hourlyRate) && hourlyRate >= MIN_WAGE)
            this.hourlyRate = hourlyRate;
        else this.hourlyRate = 0;
    }


    /**
     * Gets hourlyRate.
     *
     * @return Value of hourlyRate.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets new hourlyRate.
     *
     * @param hourlyRate New value of hourlyRate.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Gets NORMAL_WORKWEEK.
     *
     * @return Value of NORMAL_WORKWEEK.
     */
    public static double getNORMAL_WORKWEEK() {
        return NORMAL_WORKWEEK;
    }

    /**
     * Gets firstName.
     *
     * @return Value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets new hoursWorked.
     *
     * @param hoursWorked New value of hoursWorked.
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * Gets MIN_WAGE.
     *
     * @return Value of MIN_WAGE.
     */
    public static double getMIN_WAGE() {
        return MIN_WAGE;
    }

    /**
     * Sets new lastName.
     *
     * @param lastName New value of lastName.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets new firstName.
     *
     * @param firstName New value of firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets hoursWorked.
     *
     * @return Value of hoursWorked.
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Gets lastName.
     *
     * @return Value of lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets ppsNumber.
     *
     * @return Value of ppsNumber.
     */
    public String getPpsNumber() {
        if (Utilities.validPPS(ppsNumber))
            return ppsNumber;
        else return"Invalid PPS Number";
    }

    /**
     * Sets new NORMAL_WORKWEEK.
     *
     * @param NORMAL_WORKWEEK New value of NORMAL_WORKWEEK.
     */
    public static void setNORMAL_WORKWEEK(double NORMAL_WORKWEEK) {
        NORMAL_WORKWEEK = NORMAL_WORKWEEK;
    }

    /**
     * Sets new ppsNumber.
     *
     * @param ppsNumber New value of ppsNumber.
     */
    public void setPpsNumber(String ppsNumber) {
        this.ppsNumber = ppsNumber;
    }

    /**
     * Sets new MIN_WAGE.
     *
     * @param MIN_WAGE New value of MIN_WAGE.
     */
    public static void setMIN_WAGE(double MIN_WAGE) {
        MIN_WAGE = MIN_WAGE;
    }

    public double getOverTime(){
        if(hoursWorked >= NORMAL_WORKWEEK)
            return hoursWorked - NORMAL_WORKWEEK;
        else return hoursWorked;
    }

    public double getSalary(){
        if(hoursWorked < NORMAL_WORKWEEK)
            return hourlyRate * hoursWorked;
        else return (hourlyRate * NORMAL_WORKWEEK) + (getOverTime());
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ppsNumber='" + ppsNumber + '\'' +
                ", hoursWorked=" + hoursWorked +
                ", hourlyRate=" + hourlyRate +
                '}';
    }
}
