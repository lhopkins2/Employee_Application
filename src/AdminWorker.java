public class AdminWorker extends  Employee{
    /**
     * creates an Admin Worker under the Employee parent class
     * @param fName
     * @param lName
     * @param pps
     * @param hoursWorked
     * @param hourlyRate
     * @param fixedBonus
     */
    private double fixedBonus;
    public AdminWorker(String fName, String lName, String pps, double hoursWorked, double hourlyRate, double fixedBonus){
        super(fName, lName, pps, hoursWorked, hourlyRate);
        if(Utilities.validDoubleNonNegative(fixedBonus))
            this.fixedBonus = fixedBonus;
    }


    /**
     * Sets new fixedBonus.
     *
     * @param fixedBonus New value of fixedBonus.
     */
    public void setFixedBonus(double fixedBonus) {
        if(Utilities.validDoubleNonNegative(fixedBonus))
            this.fixedBonus = fixedBonus;
    }

    /**
     * Gets fixedBonus.
     *
     * @return Value of fixedBonus.
     */
    public double getFixedBonus() {
        return fixedBonus;
    }

    @Override
    public double calculateSalary(){
        return super.getSalary() + fixedBonus;
    }

    @Override
    public String toString() {
        return "AdminWorker{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", ppsNumber='" + getPpsNumber() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                ", fixedBonus=" + fixedBonus +
                '}';
    }
}
