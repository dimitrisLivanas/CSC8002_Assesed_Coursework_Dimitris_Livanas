package carRentalCompany;

import java.util.*;

/*
 * A method that stores informations about the licence number and also checks if the licence numbers are unique
 */

public final class LicenceNumber {
    private static final Map<String, LicenceNumber> LicenceNum = new HashMap<String, LicenceNumber>();
    private final String initials;
    private final int yearOfIssue;
    private final int serialNum;
    private final String strRep;

    private LicenceNumber(String initials, int yearOfIssue2, int serialNum) {
        this.initials = initials;
        this.yearOfIssue = yearOfIssue2;
        this.serialNum = serialNum;
        strRep = initials + "-" + yearOfIssue2 + "-" + serialNum;
    }

/*
 * Creating the Licence Number and checking for uniqueness
 * @param fullName, yearOfIssue
 * @return LicenceNum.get(strRep)   
 */
    
    public static LicenceNumber getInstance(Driver fullName, Date yearOfIssue) {
        final String initials = fullName.getFirstName().substring(0, 1) + fullName.getLastName().substring(0, 1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(yearOfIssue);
        final int yearOfIssue = cal.get(Calendar.YEAR);
        Random r = new Random();

        final int serialNum = r.nextInt(11);
        final String strRep = initials + "-" + yearOfIssue + "-" + serialNum;

        if (!LicenceNum.containsKey(strRep)) {
            LicenceNum.put(strRep, new LicenceNumber(initials, yearOfIssue, serialNum));
        } else if (LicenceNum.containsKey(strRep)) {
            return getInstance(fullName, yearOfIssue);
        }
   

        return LicenceNum.get(strRep);

    }

    public String getInitials() {
        return initials;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public String getStrRep() {
        return strRep;
    }

    @Override
    public String toString() {
        return "LicenceNumber [initials=" + initials + ", yearOfIssue=" + yearOfIssue + ", serialNum=" + serialNum
                + ", strRep=" + strRep + "]";
    }
}
