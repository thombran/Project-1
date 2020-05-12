package project1;

/**
 *
 * Stores and analyzes calendar dates.  THIS IS A HELPER CLASS, PLEASE
 * CREATE A SEPARATE CLASS NAMED: SimpleDate.java AND COPY THIS STARTING
 * CODE TO THIS NEW CLASS.
 *
 * 	 NOTE: MUCH MORE CODING IS NEEDED IN THESE METHODS, HOWEVER
 * 	 HERE IS SOME STARTING CODE.
 *
 * @author Brandon and Dylan
 */

public class SimpleDate {

	/** Month represents the current month */
	private int month;

	/** Day represents the current day */
	private int day;

	/** Year represents the current year */
	private int year;

    // Days in each month (assuming months are numbered beginning with 1)
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31};
    
	private static final String [] MONTHS = {"January", "February", "March", "April", "May",
	 										"June", "July","August","September","October","November",
											"December"};
    // Remember to use the Java style guide on all instance variables.
	// Also, remember no TEXT WRAP!!!

    private static final int NUM_MONTHS = 12;
    private static final int DAYS_YEAR = 365;

    public static final int MIN_YEAR = 1753;

	private static int counter = 0;

	private SimpleDate(){
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
	public SimpleDate (String date) {
	   if (date == null)
            	    throw new IllegalArgumentException();

           String[] parts = date.split("/");

           if (parts.length == 3) {
              month = Integer.parseInt(parts[0]);
              day = Integer.parseInt(parts[1]);
              year = Integer.parseInt(parts[2]);
              counter += 1;


        }
        else
            throw new IllegalArgumentException()
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
	public SimpleDate (int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		counter += 1;
	}

	// THE REST OF THE METHODS NEED JAVA STYLE GUIDING.
	public SimpleDate (SimpleDate other) {
	   if (other != null) {
		this.day = other.day;
		this.year = other.year;
		this.month = other.month;
		counter += 1;
	   }
	}

	private  int daysInMonth(int month, int year) {
		if (month == 2 && isLeapYear(year)) {
			return 29;
		}
		return DAYS_IN_MONTH[month];
	}

	public static boolean isLeapYear(int year) {
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
        SimpleDate o = (SimpleDate) other;
		if(this.day == o.day &&
		   this.month == o.month &&
		   this.year == o.year) {
			return true;
		}
        else
        	return false;
		}


	public int compareTo(SimpleDate other) {

		if (this.year > other.year)
			return 1;
		else if (this.year < other.year)
			return -1;
		else if (this.equals(other))
			return 0;
		return 2;
	}


	public void save (String fileName) {
		PrintWriter out = null;
        	try {
            	out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        	}
        	catch (Exception e) {
            	e.printStackTrace();
       		}
        	out.print(this.month);
        	out.print(this.day);
        	out.print(this.year);
        	out.close();
	}

	public void load (String fileName) {
		try{
            Scanner fileReader = new Scanner(new File(fileName));
            this.day = fileReader.nextInt();
            this.month = fileReader.nextInt();
            this.year = fileReader.nextInt();

            System.out.print (this.month);
            System.out.print ("/" + this.day);
            System.out.print ("/" + this.year);
        }

        // problem reading the file
        catch(Exception error){
            throw new RuntimeException();
            
        }
	}

	public int ordinalDate(){
		int days = 0;
		for (int i = 0; i < this.month; i++)
			days += DAYS_IN_MONTH[i];
		if(this.isLeapYear() && this.month > 2)
			days += 1;
		days += this.day - 1;
		return days;
	}
	public void increment(){
        day ++;
        if (day > DAYS_IN_MONTH[month]) {
            month ++;
            day = 1;
            if (month == 13) {
                month = 1;
                day = 1;
                year ++;
                
            }
        }
    }

	public static int getNumberOfSimpleDates(){
		return counter;
	}

	public static boolean equals (SimpleDate s1, SimpleDate s2){
		if(s1.equals(s2))
			return true;
		else
			return false;
	}





} // end SimpleDate
