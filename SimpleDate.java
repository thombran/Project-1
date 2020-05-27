package project1;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Stores and analyzes calendar dates.
 * <p>
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
            31, 30, 31, 30, 31};  //Starts with 0 so month "numbers" are in line with reality (i.e. index 1 is January).

    /**
     * List of months in order from January - December
     **/
    private static final String[] MONTHS = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December"}; //Array to keep track of months when creating date Strings


    /**
     * Number of months in a year
     **/
    private static final int NUM_MONTHS = 12; //Max month int that can be referenced
    /**
     * Number of days in a year
     **/
    private static final int DAYS_YEAR = 365; //Max days in year. Used to calculate ordinal dates

    /**
     * The minimum year accepted as a date in the program
     **/
    public static final int MIN_YEAR = 1753; //Earliest date allowed to be entered by user
    /**
     * Keeps track of how many instances of SimpleDate objects have been created
     */
    private static int counter = 0;

    /******************************************************************
     * Default constructor that sets the SimpleDate to lowest possible date.
     *****************************************************************/
    public SimpleDate() {
        month = 1;
        day = 1;
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
        if (parts.length < 3)
            throw new IllegalArgumentException();
        month = Integer.parseInt(parts[0]); //Takes in string arguement and as an array and breaks that down into month, day, and year
        day = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);
        if ((month > 12 || month < 1) || day > DAYS_IN_MONTH[month] || year < MIN_YEAR
                || day < 1 || (!isLeapYear() && month == 2 && day > 28)) //Error if invalid date
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
        if (!isLeapYear() && month == 2 && day > 28) //Throws error if it is a leap year and days exceed days in February
            throw new IllegalArgumentException();
        if ((month > 12 || month < 1) || (day > DAYS_IN_MONTH[month] || day < 1) || year < MIN_YEAR
                || (!isLeapYear() && month == 2 && day > 28)) {
            throw new IllegalArgumentException(); //Error if invalid date
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
        if (month > 12 || month < 1 || year < MIN_YEAR) {
            throw new IllegalArgumentException(); //Error if month or year entered is invalid
        }
        if (month == 2 && isLeapYear(year)) {
            return 29; //Accounts for days in February in leap year
        }
        return DAYS_IN_MONTH[month]; //Otherwise just returns the days ina given month
    }

    /**
     * Helper method to determine if the specified date is a leap year
     *
     * @param year The year to be determined if it is a leap year
     * @return Returns true if the specified year is a leap year
     * @throws IllegalArgumentException if input is before 1753
     */
    public static boolean isLeapYear(int year) {
        if (year < MIN_YEAR)
            throw new IllegalArgumentException(); //Error if year is invalid
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0); //Checks if date is evenly divisible by 4 and either not divisible by a century or divisible by 400 years
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
                this.year; //Lays out the date in Month (spelled out), day and year format (i.e. January 1, 2020)
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
        SimpleDate o; //Creates new object to load the "other" date into
        if (other != null) {
            if (other instanceof SimpleDate) {
                o = (SimpleDate) other; //If other is actually a SimpleDate, then o is created
                if (this.day == o.day && this.month == o.month && this.year == o.year) {
                    return true; //If they two dates are the exact same
                } else
                    return false;
            }
        }
        throw new IllegalArgumentException(); //Error if the two dates/objects cannot be compared
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
            if (this.equals(other))
                return 0; //If the two dates are equal returns 1
            else if (this.year < other.year)
                return -1; //If this date is less than the other, returns -1
            else
                return 1; //returns a 1 if this date is greater than the other
        } else
            throw new IllegalArgumentException(); //Error if the other SimpleDate is null or invalid
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
        try { //Attempts to write data to a specified file name
            if (fileName.length() < 1) {
                throw new IllegalArgumentException(); //Error if the user entered file name is blank
            }
            out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            out.println(this.month); //Writes month to file first
            out.println(this.day); //Writes day to file on separate line
            out.println(this.year); //Writes year to file last on separate line
        } catch (Exception e) {
            throw new IllegalArgumentException(); //Error if print writer is not able to write to file or other error occurs

        }
        out.close(); //Finishes the writing stream and essentially saves the file
    }

    /**
     * This is the opposing method to the save method which loads in the date from the
     * specified file name
     *
     * @param fileName The name of the file to load the date from
     * @throws IllegalArgumentException If the file name is invalid or does not exist
     */
    public void load(String fileName) throws IllegalArgumentException {
        SimpleDate s = new SimpleDate(); //Creates a new SimpleDate to load the saved date into
        try {
            Scanner scnr = new Scanner(new File(fileName));
            s.month = scnr.nextInt(); //Scans for month on first line
            s.day = scnr.nextInt(); //Scans for day on second line
            s.year = scnr.nextInt(); //Scans for year on the third/last line
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println(s.toString()); //Prints out the loaded date in the toString format
    }

    /**
     * A method the returns the number of days at the beginning of the “this” year.
     * For example: “2/10/2013” returns 41
     *
     * @return The number of days that have passed during the current year
     * leading up to the calling date object
     */
    public int ordinalDate() {
        int days = 1; //If date using this method is January 1, ordinal date is 1
        for (int i = 0; i < this.month; i++)
            days += DAYS_IN_MONTH[i]; //Cycles through and adds the days of each month until it reaches current month
        if (this.isLeapYear() && this.month > 2)
            days += 1; //Accounts for extra day in year if month is past February
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
    } //Counter of how many SimpleDates have been created

    /**
     * A method that returns true if SimpleDate s1 is exactly the same as SimpleDate s2 object.
     *
     * @param s1 The first date to be compared
     * @param s2 The date to compare to the first date
     * @return Returns true if the two dates are the same
     */
    public static boolean equals(SimpleDate s1, SimpleDate s2) {
        if (s1.equals(s2)) //Uses the above equals method to compare two SimpleDates
            return true; //True if equal
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
    } //Getter for counter

    /**
     * Sets the date's month to the specified value
     *
     * @param month The desired month represented by a 1-12 integer
     */
    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalArgumentException(); //Error if month is invalid, like 13
        this.month = month; //otherwise sets SimpleDate month to specified number
    }

    /**
     * Sets the date's day to the specified value
     *
     * @param day The desired day represented by a 1-31 integer
     */
    public void setDay(int day) {
        if (day > DAYS_IN_MONTH[this.month] || day < 1)
            throw new IllegalArgumentException(); //Error if day is invalid, like 32
        this.day = day; //Otherwise sets SimpleDate day to specified number
    }

    /**
     * Sets the date's year to the specified value
     *
     * @param year The desired year represented by an integer value > 1753
     */
    public void setYear(int year) {
        if (year < MIN_YEAR)
            throw new IllegalArgumentException(); //Error if year is invalid, i.e. less than MIN_YEAR
        this.year = year; //Otherwise sets SimpleDate year to speicifed number
    }

    /**
     * Changes the counter (amount of SimpleDate instances) to the specified value
     *
     * @param counter The int amount of instances of SimpleDate
     */
    public static void setCounter(int counter) {
        if (counter < 0)
            throw new IllegalArgumentException(); //Error if arguement is negative because there cannot be a negative amount of isntances of an object
        SimpleDate.counter = counter;
    }

    /**
     * Increases the SimpleDate object's date by one day at a time
     * Helper method
     */
    public void increment() {
        this.day++;
        if (this.day > DAYS_IN_MONTH[this.month]) {
            if (isLeapYear() && this.month == 2 && this.day < 30)
                return; //Accounts for leap year by allowing one extra day in February when comparing to the days in a given month
            this.month++; //Increases the month by 1 if the amount of days exceeds days in a month
            day = 1; //Sets day back to one since a new month has started
            if (month == 13) { //Checks to see if increment has led to a new year, in which case date returns to January 1 of year + 1
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
            if (isLeapYear() && this.month == 3 && this.day == 1) {
                this.month--;
                this.day = 29;
                return; //Accounts for leap year by allowing date to move to February 29 when moving date backwards/decrementing
            } else if (month == 1 && day == 1) {
                month = 12;
                day = 31;
                year--; //Allows for date to move into last day of previous year when current date is the first of the current year
                return;
            } else {
                this.month--;
                this.day = DAYS_IN_MONTH[month];
                return; //Otherwise program decreases month by 1 if day is first of a month
            }
        }
        this.day--; //If none of the above applies and it is not the first day of any month, the day decreases by 1
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
                fromNow.increment(); //Increments the local SimpleDate until it reaches the amount of n days specified by user
            return fromNow;
        } else if (n < 0) {
            for (int i = 0; i > n; i--)
                fromNow.decrement(); //Decrements the local SimpleDate until it reaches the amount of n days specified by the user
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
        if (this.month == other.month)
            return this.day < other.day; //If months are equal, returns true if this day is less than the other
        else
            return this.month < other.month; //Otherwise if months are not the same, it just returns if this month is less than the other
    }

    /**
     * Helper method to determine if the month and day of a SimpleDate object is greater
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is greater than the other
     */
    public boolean greaterMD(SimpleDate other) {
        if (this.month == other.month)
            return this.day > other.day; //If months are equal, returns true if this day is greater than the other
        else
            return this.month > other.month; //Otheerwise if months are not the same, it just returns if this month is greater than the other
    }

    /**
     * Helper method to determine if the month, day, and year of a SimpleDate object is less
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is less than the other
     */
    public boolean lesserMDY(SimpleDate other) {
        if (this.year == other.year) //Checks if the years are the same
            if (this.month == other.month) //If years are the same, checks if months are the same
                return this.day < other.day;  //If months are the same, returns if this day is less than other
            else
                return this.month < other.month; //If months are not the same, returns if this month is less than other
        else
            return this.year < other.year; //If years are not the same returns if this year is less than other
    }

    /**
     * Helper method to determine if the month, day, and year of a SimpleDate object is greater
     * than the other
     *
     * @param other The date being compared to
     * @return Returns true if this date is less than the other
     */
    public boolean greaterMDY(SimpleDate other) {
        if (this.year == other.year) //Checks if the years are the same
            if (this.month == other.month) //If year are the same, checks if the months are the same
                return this.day > other.day; //If months are the same, reutns if this day is greater than other
            else
                return this.month > other.month; //If months are not the same, returns if this month is greater than other
        else
            return this.year > other.year; //If years are not the same returns if this year is greater than other
    }

    /**
     * Determines the amount of days that have passed from 'this' date to 'other' date
     *
     * @param other The date being counted from
     * @return Returns a negative number if 'this' date is before (in the past) the 'other' date.
     * Returns a positive number if 'this' date is after (in the future) the 'other' date.
     */

    public int daysSince(SimpleDate other) {
        int days = 0; //If two dates are the same, the days between each other must be zero so days starts at 0
        SimpleDate temp1 = new SimpleDate(this);
        SimpleDate temp2 = new SimpleDate(other); //Creates two new SimpleDate objects so as to not change the dates which will be used in GUI
        if (temp1.year == temp2.year) { //If years are the same, checks to see if months/days of the this/temp1 date is less than the other
            if (temp1.lesserMD(temp2)) {
                while (temp1.day != temp2.day || (temp1.month != temp2.month)) {
                    temp1.increment(); //Increases this date until the two dates are equal
                    days--;
                }
                return days;
            } else if (temp1.greaterMD(temp2)) { //If years are the same, checks to see if months/days of the this/temp1 date is greater than the other
                while (temp1.day != temp2.day || (temp1.month != temp2.month)) {
                    temp1.decrement(); //Decreases this date until the two dates are equal
                    days++;
                }
                return days;
            } else
                return 0;
        } else {
            if (temp1.lesserMDY(temp2)) { //If years are not the same, checks to see if months/days of the this/temp1 date is lesser than the other
                while (temp1.day != temp2.day || temp1.month != temp2.month || temp1.year != temp2.year) {
                    temp1.increment(); //Increases this date until the two dates are equal
                    days--;
                }
                return days;
            } else { //If years are not the same, defaults to assuming this/temp1 date is greater than the other
                while (temp1.day != temp2.day || temp1.month != temp2.month || temp1.year != temp2.year) {
                    temp1.decrement(); //Decreases this date until the two dates are equal
                    days++;
                }
                return days;
            }
        }
    }
}// end SimpleDate
