package project1;

public class Main {

    public static void main(String[] args) {
	    SimpleDate s1 = new SimpleDate("10/25/2020");
        SimpleDate s2 = new SimpleDate("10/25/2020");
        SimpleDate s3 = new SimpleDate("10/25/2020");
        SimpleDate s4 = new SimpleDate("10/25/2020");
	    System.out.println(s1.ordinalDate());
	    System.out.println(SimpleDate.getNumberOfSimpleDates());
	    System.out.println(s1.toString());
    }
}
