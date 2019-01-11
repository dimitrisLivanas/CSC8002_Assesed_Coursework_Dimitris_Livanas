package carRentalCompany;

/*
 * A method to create and store the Driver's First and Last name
 */

public final class Driver {

    private final String firstName;
    private final String lastName;

    public Driver(String firstName, String lastName) {
        if (firstName.length() == 0) {
            throw new IllegalArgumentException("You must add a first name");
        }
        if (lastName.length() == 0) {
            throw new IllegalArgumentException("You must add a last name");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "firstName is " + firstName + " lastName is " + lastName;
    }
}
