package carRentalCompany;

import java.util.*;

/*
 * A class to "create" the Driving Licence by getting the necessary information through get methods.
 */

public final class DrivingLicence {
    private final Driver driverName;
    private final Date driverDateOfBirth;
    private final Date dateOfIssue;
    private final LicenceNumber number;
    private final boolean isFull;
    private boolean currentlyRenting = false;

    public DrivingLicence(Driver driverName, Date dateOfBirth, Date dateOfIssue, boolean isFull) {
        this.driverName = driverName;
        this.driverDateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
        this.number = LicenceNumber.getInstance(driverName, dateOfIssue);
        this.isFull = isFull;
    }

    public Driver getDriverName() {
        return driverName;
    }

    public Date getDriverDateOfBirth() {
        return driverDateOfBirth;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public LicenceNumber getNumber() {
        return number;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setCurrentlyRenting(Boolean bool) {
        currentlyRenting = bool;
    }

    public boolean getCurrentlyRenting() {
        return currentlyRenting;
    }

    @Override
    public String toString() {
        return "\nDrivingLicence \ndriverName= " + driverName.toString() + "\ndriverDateOfBirth= " + driverDateOfBirth
                + "\ndateOfIssue= " + dateOfIssue + "\nnumber= " + number.toString() + "\nisFull= " + isFull + "]";
    }

}