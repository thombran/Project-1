package project1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Stores and analyzes calendar dates.  THIS IS A HELPER CLASS, PLEASE
 * CREATE A SEPARATE CLASS NAMED: SimpleDate.java AND COPY THIS STARTING
 * CODE TO THIS NEW CLASS.
 * <p>
 * NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, HOWEVER
 * HERE IS SOME STARTING CODE.
 *
 * @author Brandon and Dylan
 */

public class SimpleDate {

    /**
     * Month represents the current month
     */
    private int month;

    /**
     * Day represents the current day
     */
    private int day;

    /**
     * Year represents the current year
     */
    private int year;

    /**
     * Days in each month (assuming months are numbered beginning with 1)
     **/
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    /**
     *  List of months in order from January - December
     **/
    private static final String[] MONTHS = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December"};


    /**
     * Number of months in a year
     **/
    private static final int NUM_MONTHS = 12;
    /**
     * Number of days in a year
     **/
    private static final int DAYS_YEAR = 365;

    /**
     * The minimum year accepted as a date in the program
     **/
    public static final int MIN_YEAR = 1753;
    /**
     * Keeps track of how many instances of SimpleDate objects have been created
     */
    private static int counter = 0;

    /******************************************************************
     * Default constructor that sets the SimpleDate to lowest possible date.
     *****************************************************************/
    public SimpleDate() {
        month = 01;
        day = 01;
        year = MIN_YEAR;
        counter += 1;
    }

    /******************************************************************
     * A constructor that accepts a string that represents
     * a date
     *  MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
     *  HERE IS SOME STARTING CODE.
     *
     * @param date A string that represents a date
     * @throws IllegalArgumentException if parameter doesn't
     * represent a valid date.
     ****************************************************************/
    public SimpleDate(String date) {
        String[] parts = date.split("/");
        if(parts.length < 3)
            throw new IllegalArgumentException();
        month = Integer.parseInt(parts[0]);
        day = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);
        if ((month > 12 || month < 1) || day > DAYS_IN_MONTH[month] || year < 1753
                || day < 1 || (!isLeapYear() && month == 2 && day > 28))
            throw new IllegalArgumentException();

        counter += 1;
    }

    /******************************************************************
     * Constructor taking month, day, and year as integers.
     *
     * @param month the month for the given simple date
     * @param day   the day  for the given simple date
     * @param year  the year  for the given simple date
     *              	 *  MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
     * 	MUCH MORE CODING IS NEEDED IN THIS METHOD, HOWEVER
     *  HERE IS SOME STARTING CODE.
     *
     * @throws IllegalArgumentException if input
     * doesn't represent a valid date.
     ******************************************************************/
    public SimpleDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
        if (isLeapYear() && month == 2 && day > 28)
            throw new IllegalArgumentException();
        if ((month > 12 || month < 1) || (day > DAYS_IN_MONTH[month] || day < 1) || year < 1753
                || (!isLeapYear() && month == 02 && day > 28)) {
            throw new IllegalArgumentException();
        }
        counter += 1;
    }

    /**
     * Constructor taking a SimpleDate object as input
     *
     * @param other The date in which this new date will take the form of
     * @throws IllegalArgumentException if the input is not of type SimpleDate
     */
    public SimpleDate(SimpleDate other) {
        this.day = other.day;
        this.year = other.year;
        this.month = other.month;
        counter += 1;
    }

    /**
     * Private method for determining how many days are in a given month.
     * Accounts for leap years and invalid dates.
     *
     * @param month int representing the month
     * @param year  int representing the year
     * @return int representing how many days are in that month of a specific year
     * @throws IllegalArgumentException if input date XOR is invalid (i.e. before 1753 or
     *                                  out of bounds month)
     */
    public int daysInMonth(int month, int year) {
        if (month > 12 || month < 1 || year < 1753) {
            throw new IllegalArgumentException();
        }
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month];
    }

    /**
     * Helper method to determine if the specified date is a leap year
     *
     * @param year The year to be determined if it is a leap year
     * @return Returns true if the specified year is a leap year
     * @throws IllegalArgumentException if input is before 1753
     */
    public static boolean isLeapYear(int year) {
        if (year < 1753)
            throw new IllegalArgumentException();
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /**
     * The caler method for determining if specified year is a leap year
     *
     * @return Returns true if specified year is a leap year
     */
    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    /**
     * Overrides the default toString method to print date out in the format of
     * month day, year (i.e. January 1, 2000)
     *
     * @return Returns a string in the form of the aforementioned format
     */
    public String toString() {
        return "" + MONTHS[this.month - 1] + " " + this.day + ", " +
                this.year;
    }

    /**
     * Overrides default equals method to compare if two SimpleDate objects are equal to one another.
     * Not to be called while using this class
     *
     * @param other The date/SimpleDate object to be compared
     * @return Returns true if the two onjects/dates are equal
     * @throws IllegalArgumentException if other object is null or not an instance of SimpleDate
     */
    public boolean equals(Object other) {
        SimpleDate o;
        if (other != null) {
            if (other instanceof SimpleDate) {
                o = (SimpleDate) other;
                if (this.day == o.day && this.month == o.month && this.year == o.year) {
                    return true;
                } else
                    return false;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Compares two dates and returns if the this date is greater than, less than,
     * or equal to the other date
     *
     * @param other The other date which the this date is being compared to
     * @return 1 if this is greater than other, -1 if less than, 0 if equal
     * and 2 otherwise
     * @throws IllegalArgumentException if the other object is null or invalid (i.e. not
     *                                  a date object)
     */
    public int compareTo(SimpleDate other) {
        if (other != null) {
            if (this.year > other.year)
                return 1;
            else if (this.year < other.year)
                return -1;
            else if (this.equals(other))
                return 0;
            return 2;
        } else
            throw new IllegalArgumentException();
    }

    /**
     * This saves the this date to a file which can be read back at a later time
     *
     * @param fileName The name of the file in which to save to
     * @throws IllegalArgumentException If the filename is empty or otherwise is an invalid
     *                                  file name
     */
    public void save(String fileName) {
        PrintWriter out = null;
        try {
            if (fileName.length() < 1) {
                throw new IllegalArgumentException();
            }
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            out.println(this.month);
            out.println(this.day);
            out.println(this.year);
        } catch (Exception e) {
            throw new IllegalArgumentException();

        }
        out.close();
    }

    /**
     * This is the opposing method to the save method which loads in the date from the
     * specified file name
     *
     * @param fileName The name of the file to load the date from
     * @throws IllegalArgumentException If the file name is invalid or does not exist
     */
    public void load(String fileName) throws IllegalArgumentException {
        SimpleDate s = new SimpleDate();
        try {
            Scanner scnr = new Scanner(new File(fileName));
            s.month = scnr.nextInt();
            s.day = scnr.nextInt();
            s.year = scnr.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println(s.toString());
    }

    /**
     * A method the returns the number of days at the beginning of the “this” year.
     * For example: “2/10/2013” returns 41
     *
     * @return The number of days that have passed during the current year
     * leading up to the calling date object
     */
    public int ordinalDate() {
        int days = 1;
        for (int i = 0; i < this.month; i++)
            days += DAYS_IN_MONTH[i];
        if (this.isLeapYear() && this.month > 2)
            days += 1;
        days += this.day - 1;
        return days;
    }

    /**
     * Returns how many times a SimpleDate object has been created/how many
     * instances there are
     *
     * @return Returns number of SimpleDate objects
     */
    public static int getNumberOfSimpleDates() {
        return counter;
    }

    /**
     * A method that returns true if SimpleDate s1 is exactly the same as SimpleDate s2 object.
     *
     * @param s1 The first date to be compared
     * @param s2 The date to compare to the first date
     * @return Returns true if the two dates are the same
     */
    public static boolean equals(SimpleDate s1, SimpleDate s2) {
        if (s1.equals(s2))
            return true;
        else
            return false;
    }

    /**
     * The month of the specified date
     *
     * @return Returns the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * The day of the specified date
     *
     * @return Returns the day
     */
    public int getDay() {
        return day;
    }

    /**
     * The year of the specified date
     *
     * @return Returns the year
     */
    public int getYear() {
        return year;
    }

    public static int getCounter() {
        return counter;
    }

    /**
     * Sets the date's month to the specified value
     *
     * @param month The desired month represented by a 1-12 integer
     */
    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalArgumentException();
        this.month = month;
    }

    /**
     * Sets the date's day to the specified value
     *
     * @param day The desired day represented by a 1-31 integer
     */
    public void setDay(int day) {
        if (day > DAYS_IN_MONTH[this.month] || day < 1 || day > 31)
            throw new IllegalArgumentException();
        this.day = day;
    }

    /**
     * Sets the date's year to the specified value
     *
     * @param year The desired year represented by an integer value > 1753
     */
    public void setYear(int year) {
        if (year < 1753)
            throw new IllegalArgumentException();
        this.year = year;
    }

    /**
     * Changes the counter (amount of SimpleDate instances) to the specified value
     *
     * @param counter The int amount of instances of SimpleDate
     */
    public static void setCounter(int counter) {
        if (counter < 0)
            throw new IllegalArgumentException();
        SimpleDate.counter = counter;
    }

    /**
     * Increases the SimpleDate object's date by one day at a time
     * Helper method
     */
    public void increment() {
        this.day++;
        if (this.day > DAYS_IN_MONTH[this.month]) {
            if (isLeapYear() && this.month == 02 && this.day < 30)
                return;
            this.month++;
            day = 1;
            if (month == 13) {
                month = 1;
                day = 1;
                year++;
            }
        }
    }

    /**
     * Decreases the SimpleDate object's date by one day at a time.
     * Helper method.
     */
    public void decrement() {
        if (this.day == 1) {
            if (isLeapYear() && this.month == 03 && this.day == 1) {
                this.month--;
                this.day = 29;
                return;
            } else if (month == 1 && day == 1) {
                month = 12;
                day = 31;
                year--;
                return;
            } else {
                this.month--;
                this.day = DAYS_IN_MONTH[month];
                return;
            }
        }
        this.day--;
    }

    /**
     * Determines the date from the specified n amount of days
     *
     * @param n The amount of days to increase the date by. + moves the date into the future,
     *          - moves the date into the past
     * @return The new date after moving the date n days
     */
    public SimpleDate daysFromNow(int n) {
        SimpleDate fromNow = new SimpleDate(this.month, this.day, this.year);
        if (n > 0) {
            for (int i = 0; i < n; i++)
                fromNow.increment();
            return fromNow;
        } else if (n < 0) {
            for (int i = 0; i > n; i--)
                fromNow.decrement();
            return fromNow;
        } else return this;
    }

    /**
     * Helper method to determine if the month and day of a SimpleDate object is less
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is less than the other
     */
    public boolean lesserMD(SimpleDate other) {
        if(this.month == other.month)
            return this.day < other.day;
        else
            return this.month < other.month;

    }

    /**
     * Helper method to determine if the month and day of a SimpleDate object is greater
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is greater than the other
     */
    public boolean greaterMD(SimpleDate other) {
        if(this.month == other.month)
            return this.day > other.day;
        else
            return this.month > other.month;
    }

    /**
     * Helper method to determine if the month, day, and year of a SimpleDate object is less
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is less than the other
     */
    public boolean lesserMDY(SimpleDate other) {
        if(this.year == other.year)
            if(this.month == other.month)
                return this.day < other.day;
            else
                return this.month < other.month;
        else
            return this.year < other.year;
    }

    /**
     * Helper method to determine if the month, day, and year of a SimpleDate object is greater
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is less than the other
     */
    public boolean greaterMDY(SimpleDate other) {
        if(this.year == other.year)
            if(this.month == other.month)
                return this.day > other.day;
            else
                return this.month > other.month;
        else
            return this.year > other.year;
    }

    /**
     * Determines the amount of days that have passed from 'this' date to 'other' date
     *
     * @param other The date being counted from
     * @return Returns a negative number if 'this' date is before (in the past) the 'other' date.
     * Returns a positive number if 'this' date is after (in the future) the 'other' date.
     */

    public int daysSince(SimpleDate other) {
        int days = 0;
        SimpleDate temp1 = new SimpleDate(this);
        SimpleDate temp2 = new SimpleDate(other);
        if (temp1.year == temp2.year) {
            if (temp1.lesserMD(temp2)) {
                while (temp1.day != temp2.day || (temp1.month != temp2.month)) {
                    temp1.increment();
                    days--;
                }
                return days;
            } else if (temp1.greaterMD(temp2)) {
                while (temp1.day != temp2.day || (temp1.month != temp2.month)) {
                    temp1.decrement();
                    days++;
                }
                return days;
            } else
                return 0;
        } else {
            if (temp1.lesserMDY(temp2)) {
                while (temp1.day != temp2.day || temp1.month != temp2.month || temp1.year != temp2.year) {
                    temp1.increment();
                    days--;
                }
                return days;
            } else if (temp1.greaterMDY(temp2)) {
                while (temp1.day != temp2.day || temp1.month != temp2.month || temp1.year != temp2.year) {
                    temp1.decrement();
                    days++;
                }
                return days;
            } else
                return 0;
        }

    }
}// end SimpleDate
