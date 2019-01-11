package carRentalCompany;

/*
 * The interface class for the Car
 */

public interface InterfaceCar {

    public String getRegNum();

    public int getFuelCapacity();

    public int getCurrentFuel();

    public void isTankFull();

    public boolean isFull();

    public boolean isRented();

    public void setIsRented(Boolean bool);

    public int addFuel(int amount);

    public int drive(int distance);

    public boolean isSmall();

}
