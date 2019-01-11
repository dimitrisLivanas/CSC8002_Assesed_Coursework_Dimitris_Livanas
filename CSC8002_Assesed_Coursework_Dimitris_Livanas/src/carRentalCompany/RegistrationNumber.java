package carRentalCompany;

import java.util.*;

/*
 * A class that creates the Registration Number
 */

public final class RegistrationNumber {
    private static final Map<String, RegistrationNumber> regNum = new HashMap<String, RegistrationNumber>();
    
    private final char letter; 
    private final int numbers; 
    private final String strRep;

/* We make sure in the constructor that re Registration number will be a letter followed by four numbers.
 * @param letter, numbers
 */
    
    private RegistrationNumber(char letter, int numbers) {
        this.letter = letter;
        this.numbers = numbers;
        this.strRep = String.format("%s%04d", letter, numbers);
        
    }
/* 
 * A method that stores information about the Registration number and checks the uniqueness of the number
 * @return getInstance, regNum.get(strRep) 
 */
    public static RegistrationNumber getInstance() {
        Random random = new Random();
        
        final Character letter = (char) (random.nextInt(26) + 'A');
        final int numbers = random.nextInt(9000) + 1000;
        final String strRep = letter + numbers + "";

        if (!regNum.containsKey(strRep)) {
            regNum.put(strRep, new RegistrationNumber(letter, numbers));
        }
        
        else if (regNum.containsKey(strRep)) {
            return getInstance();
        }
       

        return regNum.get(strRep);
       
    }

    public char getLetter() {
        return letter;
    }

    public int getNumbers() {
        return numbers;
    }

    public String getStrRep() {
        return strRep;
    }

    public String toString() {
        return "RegistrationNumber is " + letter + numbers  + strRep;
    }
}
