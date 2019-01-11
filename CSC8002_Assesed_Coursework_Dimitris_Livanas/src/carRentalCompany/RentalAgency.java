package carRentalCompany;
/*
 * Contains the cars the company has and methods for cheking details about the cars like ckecking the available cars, returning
 * the rented cars given a person's driving licence and checking if a person is eligible to rent a car of a specified type.
 */
import java.util.*;


public class RentalAgency {
    private static List<AbstractCar> ListOfCars = new ArrayList<AbstractCar>();
    private static Map<DrivingLicence, AbstractCar> CARS = new HashMap<DrivingLicence, AbstractCar>();

/*
 * A method to call another method that add cars to a list named "ListOfCars"
 */
    public RentalAgency() {
        addCars();
    }

/*
 * A method to add 30 small cars and 20 large cars to the company   
 */
    private void addCars() {
    	int i = 0;
        while (i < 30) {
            ListOfCars.add(new SmallCar());
        }

        while (i < 20) {
            ListOfCars.add(new LargeCar());
        }
        i++;
    }

/*
 * A method that returns the List of cars
 * @return ListOfCars    
 */
    public List<AbstractCar> getListOfCars() {
        return ListOfCars;
    }

/*
 * A method that returns the Map called CARS
 * @return CARS   
 */
    public Map<DrivingLicence, AbstractCar> getCARS() {
        return CARS;
    }

/*
 * A method that checks whether a car is large or small. If the car is small it is added in the count.
 * @param isSmall
 * @return count    
 */
    public int availableCars(Boolean isSmall) {
        int count = 0;
        for (AbstractCar temp : ListOfCars) {
            if (temp.isSmall() == isSmall)
                if (!temp.isRented()) {
                    count++;
                } else if (!temp.isRented()) {
                    count++;
                }
        }
        return count;
    }

/*
 * A method that returns the cars that are already rented.
 * @return rentedCars    
 */
    public List<AbstractCar> getRentedCars() {
        List<AbstractCar> rentedCars = new ArrayList<AbstractCar>();
        for (AbstractCar temp : ListOfCars) {
            if (temp.isRented()) {
                rentedCars.add(temp);
            }
        }
        return rentedCars;
    }

/*
 * A method that returns a car matching a driving licence.
 * @param DrivingLicence object: licence
 * @return CARS.get(licence)
 * @return null    
 */
    public AbstractCar getCar(DrivingLicence licence) {
        if (CARS.containsKey(licence)) {
            return CARS.get(licence);
        } else
            return null;
    }
/*
 * A method that calculates the age of a driver, how many years the drivers has their licence
 * and if they are already renting a car. It also checks if the car in the list has a full tank and
 * is not rented.
 * @param licence, isSmall
 */
    public void issueCar(DrivingLicence licence, Boolean isSmall) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(licence.getDriverDateOfBirth());
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        Calendar doi = Calendar.getInstance();
        doi.setTime(licence.getDateOfIssue());
        int yearsHeld = today.get(Calendar.YEAR) - doi.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < doi.get(Calendar.MONTH)) {
            yearsHeld--;
        } else if (today.get(Calendar.MONTH) == doi.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < doi.get(Calendar.DAY_OF_MONTH)) {
            yearsHeld--;
        }
       

        boolean flag = false;
        
        if ((licence.isFull()) && (!licence.getCurrentlyRenting())) {
            
            for (AbstractCar temp : ListOfCars) {
                
                if (temp.isSmall() == isSmall) {
                    
                    if ((age >= 21) && (yearsHeld >= 1)) {
                        
                        if ((!temp.isRented()) && (temp.isFull())) {
                            
                            temp.setIsRented(true);
                            licence.setCurrentlyRenting(true);
                            CARS.put(licence, temp);
                            flag = false;
                            break;
                        } else if ((age >= 25) && (yearsHeld >= 5) && (!temp.isRented()) && (temp.isFull())) {
                            temp.setIsRented(true);
                            licence.setCurrentlyRenting(true);
                            CARS.put(licence, temp);
                            flag = false;
                            break;
                        } else
                            flag = true;
                    } else
                        flag = true;
                } else
                    flag = true;
            }
        } else
            flag = true;
        if (flag) {
            System.out.println("Car could not be issued");
        }
    }
/*
 * This method should terminate a rental contract by returning the car's status to not rented and the amount of fuel to Fuel requierd
 * to fill the tank. It should also change the status of the driving licence to not renting now.
 */
    public int terminateRental(DrivingLicence licence) {
      
    }
}