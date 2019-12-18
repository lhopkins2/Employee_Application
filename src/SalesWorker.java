class SalesWorker extends Employee {
    /**
     * Creates a SAles Worker employee under the Employee super class
     *@param fName
     *@param lName
     *@param pps
     *@param hoursWorked
     *@param hourlyRate
     *@param percentBonus
     */
    private double percentBonus;

    public SalesWorker(String fName, String lName, String pps, double hoursWorked, double hourlyRate, double percentBonus){
        super(fName, lName, pps, hoursWorked, hourlyRate);
        if(Utilities.validPercentBonus(percentBonus))
            this.percentBonus = percentBonus;
    }

    /**
     * Gets percentBonus.
     *
     * @return Value of percentBonus.
     */
    public double getPercentBonus() {
        if(Utilities.validPercentBonus(percentBonus))
            return percentBonus;
        else{percentBonus = 0.0; return percentBonus;}
    }

    /**
     * Sets new percentBonus.
     *
     * @param percentBonus New value of percentBonus.
     */
    public void setPercentBonus(double percentBonus) {
        if(Utilities.validPercentBonus(percentBonus))
            this.percentBonus = percentBonus;
    }

    @Override
    public double calculateSalary(){
        return (super.getSalary() + getPercentBonus());
    }

    @Override
    public String toString() {
        return "SalesWorker{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", ppsNumber='" + getPpsNumber() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", hourlyRate=" + getHourlyRate() +
                ", percentBonus=" + percentBonus +
                '}';
    }
}
