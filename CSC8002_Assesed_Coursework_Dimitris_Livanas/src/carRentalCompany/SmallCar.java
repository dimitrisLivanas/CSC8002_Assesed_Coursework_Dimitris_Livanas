package carRentalCompany;

/*
 * Class for the SmallCar. This is a subclass of the AbstractClass super class.
 */

public class SmallCar extends AbstractCar {
    private int smallFuelCapacity = 49;
    private boolean isSmall = true;

    
    public SmallCar() {
        super();
        super.setFuelCapacity(smallFuelCapacity);
        super.setCurrentFuel(smallFuelCapacity);
    }

    public boolean isSmall() {
        return isSmall;
    }

    
    public int drive(int distance) {
        int fuelUsed = 0;

        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be less than '0'");
        }

        if (super.isRented() && (super.getCurrentFuel() > 0)) {
            fuelUsed = (distance / 20);
            super.setCurrentFuel(super.getCurrentFuel() - fuelUsed);
            return fuelUsed;
        }
        return fuelUsed;
    }

    public boolean isFull() {
        boolean bool = super.getIsFull();
        return bool;
    }
}
