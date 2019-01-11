package carRentalCompany;

/*
 * The abstract class for the interface of the Car class.
 */

public abstract class AbstractCar implements InterfaceCar {
    private RegistrationNumber regNum;
    private int fuelCapacity;
    private int currentFuel;
    private boolean isFull;
    private boolean isRented;

    public AbstractCar() {
        RegistrationNumber regNumObj = RegistrationNumber.getInstance();
        regNum = regNumObj;
        isFull = true;
        setIsRented(false);
    }

    public String getRegNum() {
        return regNum.getStrRep();
    }

    public void setFuelCapacity(int capacity) {
        this.fuelCapacity = capacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(int amount) {
        currentFuel = amount;
        isTankFull();
    }

    public void isTankFull() {
        if ((currentFuel - fuelCapacity) >= 0) {
            isFull = true;
        } else
            isFull = false;
    }

    
    public boolean getIsFull() {
        isTankFull();
        return isFull;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setIsRented(Boolean bool) {
        isRented = bool;
    }
    
    public int addFuel(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Less than zero amount");
        }

        if (isFull || !isRented) {
            return 0;
        }
        

        if ((currentFuel + amount) <= fuelCapacity) {
            currentFuel += amount;
            if (currentFuel == fuelCapacity) {
                isFull = true;
                return amount;
            } else
                return amount;
        }
        

        if ((currentFuel + amount) > fuelCapacity) {
            int difference = (fuelCapacity - currentFuel);
            currentFuel = fuelCapacity;
            isFull = true;
            return difference;
        }
        

        return -1;
    }
}
