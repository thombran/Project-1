package project1;

import java.io.*;
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

    // Days in each month (assuming months are numbered beginning with 1)
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};

    private static final String[] MONTHS = {"January", "February", "March", "April", "May",
            "June", "July", "August", "September", "October", "November",
            "December"};
    // Remember to use the Java style guide on all instance variables.
    // Also, remember no TEXT WRAP!!!

    private static final int NUM_MONTHS = 12;
    private static final int DAYS_YEAR = 365;

    public static final int MIN_YEAR = 1753;

    private static int counter = 0;

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
        month = Integer.parseInt(parts[0]);
        day = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);
        if (month > 12 || day > 31 || year < 1753 || year > 2020
                || month < 1 || day < 1) { //TODO clean up these if statements with helper method
            throw new IllegalArgumentException();
        } else if (!isLeapYear() && month == 02 && day > 28)
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
        if (month > 12 || day > DAYS_IN_MONTH[month] || day > 31 || year < 1753 || year > 2020
                || month < 1 || day < 1 || (!isLeapYear() && month == 02 && day > 28)) {
            throw new IllegalArgumentException();
        }
        counter += 1;
    }

    // THE REST OF THE METHODS NEED JAVA STYLE GUIDING.
    public SimpleDate(SimpleDate other) {
        this.day = other.day;
        this.year = other.year;
        this.month = other.month;
        if (month > 12 || day > DAYS_IN_MONTH[month] || day > 31 || year < 1753 || year > 2020
                || month < 1 || day < 1 || (!isLeapYear() && month == 02 && day > 28)) {
            throw new IllegalArgumentException();
        }
        counter += 1;
    }

    private int daysInMonth(int month, int year) {
        if (month > 12 || month < 1 || year < 1753) {
            throw new IllegalArgumentException();
        }
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return DAYS_IN_MONTH[month];
    }

    public static boolean isLeapYear(int year) {
        if (year < 1753)
            throw new IllegalArgumentException();
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public boolean isLeapYear() {
        return isLeapYear(year);
    }

    public String toString() {
        return "" + MONTHS[this.month - 1] + " " + this.day + ", " +
                this.year;
    }


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


    public int ordinalDate() {
        int days = 0;
        for (int i = 0; i < this.month; i++)
            days += DAYS_IN_MONTH[i];
        if (this.isLeapYear() && this.month > 2)
            days += 1;
        days += this.day - 1;
        return days;
    }

    public static int getNumberOfSimpleDates() {
        return counter;
    }

    public static boolean equals(SimpleDate s1, SimpleDate s2) {
        if (s1.equals(s2))
            return true;
        else
            return false;
    }


    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public static int getCounter() {
        return counter;
    }

    public void setMonth(int month) {
        if (month > 12 || month < 1)
            throw new IllegalArgumentException();
        this.month = month;
    }

    public void setDay(int day) {
        if (day > DAYS_IN_MONTH[this.month] || day < 1 || day > 31)
            throw new IllegalArgumentException();
        this.day = day;
    }

    public void setYear(int year) {
        if (year < 1753)
            throw new IllegalArgumentException();
        this.year = year;
    }

    public static void setCounter(int counter) {
        if (counter < 0)
            throw new IllegalArgumentException();
        SimpleDate.counter = counter;
    }

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

    public void decrement() {
        this.day--;
        if (this.day == 1) {
            if (isLeapYear() && this.month == 03 && this.day == 1) {
                this.month--;
                this.day = 29;
            }
            this.month--;
            this.day = DAYS_IN_MONTH[month];
            if (month == 1) {
                month = 12;
                day = 31;
                year--;
            }
        }
    }

    public SimpleDate daysFromNow(int n) {
        SimpleDate fromNow = new SimpleDate(this.month, this.day, this.year);
        int days;
        if (n > 0) {
            for (int i = 0; i < n; i++)
                fromNow.increment();
            return fromNow;
        } else if (n < 0) {
            for (int i = 0; i < n; i++)
                fromNow.decrement();
            return fromNow;
        } else if (n == 0)
            return this;
        else
            throw new IllegalArgumentException();
    }
} // end SimpleDate