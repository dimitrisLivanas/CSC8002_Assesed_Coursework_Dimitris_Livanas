package carRentalCompany;

/*
 * Class for the LargeCar. This is a subclass of the AbstractClass super class.
 */

public class LargeCar extends AbstractCar {
    private int largeFuelCapacity = 60;
    private boolean isSmall = false;

    
    public LargeCar() {
        super();
        super.setFuelCapacity(largeFuelCapacity);
        super.setCurrentFuel(largeFuelCapacity);
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
            if (distance <= 50) {
                fuelUsed = (distance / 10);
                super.setCurrentFuel(super.getCurrentFuel() - fuelUsed);
                return fuelUsed;
            } else {
                int moreThan = (distance - 50);
                fuelUsed = (50 / 10) + (moreThan / 15);
                super.setCurrentFuel(super.getCurrentFuel() - fuelUsed);
                return fuelUsed;
            }
        }

        return fuelUsed;
    }


    public boolean isFull() {
        boolean bool = super.getIsFull();
        return bool;
    }
}
