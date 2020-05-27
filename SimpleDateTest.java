package project1;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * JUnit tests created to test every function of SimpleDate
 *
 * @author Brandon and Dylan
 */

public class SimpleDateTest {
    // testing for correct and incorrect leapyears
    @Test
    public void testIsLeapYear() {
        SimpleDate d = new SimpleDate("3/1/2013");
        assertFalse(d.isLeapYear());
        d = new SimpleDate("3/1/2000");
        assertTrue(d.isLeapYear());
    }

    // testing the compare method for this greater than other
    @Test
    public void testCompareTo1() {
        SimpleDate d1 = new SimpleDate("3/1/2013");
        SimpleDate d2 = new SimpleDate("8/21/2000");
        assertTrue(d1.compareTo(d2) > 0);
    }

    // testing the compare method for this greater less than other
    @Test
    public void testCompareTo2() {
        SimpleDate d1 = new SimpleDate("3/1/2013");
        SimpleDate d2 = new SimpleDate("8/21/2000");
        assertFalse(d1.compareTo(d2) < 0);
    }

    // testing the compare method for this equals  other
    @Test
    public void testCompareTo3() {
        SimpleDate d1 = new SimpleDate("3/1/2013");
        SimpleDate d2 = new SimpleDate("3/1/2013");
        assertEquals(0, d1.compareTo(d2));
    }
    // Testing the compare method for different year
    @Test
    public void testCompareTo4() {
        SimpleDate d1 = new SimpleDate("3/1/2012");
        SimpleDate d2 = new SimpleDate("3/1/2013");
        assertEquals(d1.compareTo(d2), -1);
    }
    // Testing the compare method for different year
    @Test (expected = IllegalArgumentException.class)
    public void testCompareTo5() {
        SimpleDate d1 = new SimpleDate("3/1/2012");
        SimpleDate d2 = new SimpleDate("3/1/2013");
        d1.compareTo(null);
    }


    // testing SimpleDate string method for incorrect year
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectYear() {
        SimpleDate d1 = new SimpleDate("3/1/1700");
    }

    // testing SimpleDate string method for negative month
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectMonth() {
        SimpleDate d1 = new SimpleDate("-3/1/1900");
    }
    // testing SimpleDate string method for incorrect positive month
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectMonth2() {
        SimpleDate d1 = new SimpleDate("13/1/1900");
    }
    // testing SimpleDate string method for incorrect positive day
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectDay() {
        SimpleDate d1 = new SimpleDate("3/45/1900");
    }
    // testing SimpleDate string method for incorrect negative day
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectDay2() {
        SimpleDate d1 = new SimpleDate("3/-20/1900");
    }

    // testing SimpleDate string method for incorrect length
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectLength() {
        SimpleDate d1 = new SimpleDate("3/1");
    }

    // Testing year that is not leap year
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectLeapYear() {
        SimpleDate d1 = new SimpleDate("2/29/2000");
    }

    // Testing basic SimpleDate method
    @Test
    public void testSimpleDate() {
        SimpleDate d1 = new SimpleDate();
    }

    // Testing String SimpleDate for all bad parameters
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectDate() {
        SimpleDate d1 = new SimpleDate("13/45/1700");
    }

    // Testing correct parameters for SimpleDate with Integers
    @Test
    public void testSimpleDateInt() {
        SimpleDate d1 = new SimpleDate(5,20,2010);
    }

    // Testing incorrect Positive month for SimpleDate with Integers
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntMonth() {
        SimpleDate d1 = new SimpleDate(13,2,2010);
    }
    // Testing incorrect negative month for SimpleDate with Integers
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntMonth2() {
        SimpleDate d1 = new SimpleDate(-1,2,2010);
    }

    // Testing incorrect Positive day for SimpleDate with Integers
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntDay() {
        SimpleDate d1 = new SimpleDate(12,34,2010);
    }
    // Testing incorrect negative day for SimpleDate with Integers
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntDay2() {
        SimpleDate d1 = new SimpleDate(1,-2,2010);
    }

    // Testing incorrect year for SimpleDate with Integers
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntYear() {
        SimpleDate d1 = new SimpleDate(12,20,1700);
    }

    // Testing incorrect leap year using SimpleDate Integer method
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntLeapYear() {
        SimpleDate d1 = new SimpleDate(2,29,2000);
    }

    // Testing SimpleDate other method for bad parameters
    @Test (expected = IllegalArgumentException.class)
    public void testSimpleDateOther2() {
        SimpleDate d1 = new SimpleDate(0,20,2010);
        SimpleDate d2 = new SimpleDate(d1);
    }
    //Testing SimpleDate constructor using too many days in non-leap year in February
    @Test (expected = IllegalArgumentException.class)
    public void testSimpleDateFeb(){
        SimpleDate d1 = new SimpleDate(02,29, 2019);
    }
    // Testing daysInMonth method for correct days
    @Test
    public void testDaysInMonth() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertEquals(31, d1.daysInMonth(1, 2020));
    }
    // Testing daysInMonth method for correct days in feb on a leap year
    @Test
    public void testDaysInMonthLeapYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertEquals(29, d1.daysInMonth(2, 2020));
    }
    // Testing daysInMonth method for correct days in feb not on a leap year
    @Test
    public void testDaysInMonthNotLeapYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertEquals(28, d1.daysInMonth(2, 2019));
    }
    // Testing daysInMonth method for incorrect month
    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonthBadMonth() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.daysInMonth(13,2020);
    }
    // Testing daysInMonth method for incorrect year
    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonthBadYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.daysInMonth(10,1600);
    }
    // Testing isLeapYear method to check outofbound year
    @Test (expected = IllegalArgumentException.class)
    public void isLeapYear2() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.isLeapYear(1700);
    }

    // Testing isLeapYear method to check for good leap year
    @Test
    public void isLeapYear3() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertTrue(d1.isLeapYear(2020));
    }
    // Testing isLeapYear method to check non leap year
    @Test
    public void isLeapYear4() {
        SimpleDate d1 = new SimpleDate();
        assertFalse(d1.isLeapYear(1905));
    }
    //Testing toString method for SimpleDate Int method
    @Test
    public void testToStringMethod() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        System.out.println(d1.toString());
    }
    //Testing toString method for SimpleDate string method
    @Test
    public void testToStringMethod2() {
        SimpleDate d1 = new SimpleDate("1/20/2020");
        System.out.println(d1.toString());
    }
    //Testing toString method for SimpleDate other method
    @Test
    public void testToStringMethod3() {
        SimpleDate d1 = new SimpleDate("1/20/2020");
        SimpleDate d2 = new SimpleDate(d1);
        System.out.println(d2.toString());
    }
    // Testing true equals method for comparing two SimpleDates
    @Test
    public void testEquals() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        SimpleDate d2 = new SimpleDate(3, 1, 2020);
        assertTrue(SimpleDate.equals(d1,d2));
    }
    // Testing false equals method for comparing two not equal SimpleDates
    @Test
    public void testEquals2() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        SimpleDate d2 = new SimpleDate(3, 2, 2020);
        assertFalse(SimpleDate.equals(d1,d2));
    }
    // Testing equals method for dates that are not equal
    @Test
    public void testEquals3() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        SimpleDate d2 = new SimpleDate(1,21,2010);
        assertNotEquals(d1, d2);
    }
    // Testing equals method for dates that are equal
    @Test (expected = IllegalArgumentException.class)
    public void testEquals4() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        SimpleDate d2 = new SimpleDate(1,20,2010);
        assertTrue(d1.equals(1));
    }
    // Testing Increment method for simple day increment
    @Test
    public void testIncrement() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.increment();
        assertEquals(21, d1.getDay());
    }
    // Testing Increment method for correct day and month change
    @Test
    public void testIncrement2() {
        SimpleDate d1 = new SimpleDate(1,31,2010);
        d1.increment();
        assertEquals(1, d1.getDay());
        assertEquals(2, d1.getMonth());
    }
   // Testing Increment method for correct day month year change
    @Test
    public void testIncrement3() {
        SimpleDate d1 = new SimpleDate(12,31,2010);
        d1.increment();
        assertEquals(1, d1.getDay());
        assertEquals(1, d1.getMonth());
        assertEquals(2011, d1.getYear());
    }
    // Testing Increment method for february leap year incrementing correctly
    @Test
    public void testIncrement4() {
        SimpleDate d1 = new SimpleDate(2,28,2020);
        d1.increment();
        assertEquals(29, d1.getDay());
    }
    // Testing Decrement method for simple day increment
    @Test
    public void testDecrement() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.decrement();
        assertEquals(19, d1.getDay());
    }
    // Testing Decrement method for correct day and month change
    @Test
    public void testDecrement2() {
        SimpleDate d1 = new SimpleDate(2,1,2010);
        d1.decrement();
        assertEquals(31, d1.getDay());
        assertEquals(1, d1.getMonth());
    }
    // Testing Decrement method for correct day month year change
    @Test
    public void testDecrement3() {
        SimpleDate d1 = new SimpleDate(1,1,2010);
        d1.decrement();
        assertEquals(31, d1.getDay());
        assertEquals(12, d1.getMonth());
        assertEquals(2009, d1.getYear());
    }
    // Testing Decrement method for february leap year decrementing correctly
    @Test
    public void testDecrement4() {
        SimpleDate d1 = new SimpleDate(3,1,2020);
        d1.decrement();
        assertEquals(29, d1.getDay());
    }
    // Testing daysFromNow method for correct days being added to SimpleDate
    @Test
    public void testDaysFromNow() {
        SimpleDate d1 = new SimpleDate(3,1,2020);
        SimpleDate d2 = new SimpleDate(3,21,2020);
        Assert.assertEquals(d2, d1.daysFromNow(20));

    }
    // Testing daysFromNow method for correct days being subtracted to SimpleDate
    @Test
    public void testDaysFromNow2() {
        SimpleDate d1 = new SimpleDate(3,21,2020);
        SimpleDate d2 = new SimpleDate(3,11,2020);
        Assert.assertEquals(d2, d1.daysFromNow(-10));
    }
    // Testing daysFromNow method for no days being added or subtracted
    @Test
    public void testDaysFromNow3() {
        SimpleDate d1 = new SimpleDate(3,21,2020);
        d1.daysFromNow(0);
        assertEquals(21, d1.getDay());
    }
    // Testing daysFromNow method for correct days and month being added to SimpleDate
    @Test
    public void testDaysFromNow4() {
        SimpleDate d1 = new SimpleDate(3,1,2020);
        SimpleDate d2 = new SimpleDate(4, 1,2020);
        Assert.assertEquals(d2, d1.daysFromNow(31));
    }
    // Testing daysFromNow method for correct days month and year being added to SimpleDate
    @Test
    public void testDaysFromNow5() {
        SimpleDate d1 = new SimpleDate(12, 1,2020);
        SimpleDate d2 = new SimpleDate(1, 1,2021);
        Assert.assertEquals(d2, d1.daysFromNow(31));
    }
    // Testing counter for correct amount
    @Test
    public void testCounter() {
        SimpleDate.setCounter(0);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertEquals(2, d2.getCounter());
    }
    // Testing counter for correct amount
    @Test
    public void testCounter2() {
        SimpleDate.setCounter(2);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertEquals(4, d2.getCounter());
    }
    // Testing setCounter method for incorrect parameter
    @Test (expected = IllegalArgumentException.class)
    public void testSetCounter() {
        SimpleDate.setCounter(-2);
    }
    //Testing the save method for a correct save
    @Test
    public void testSave() {
        String path = "test.txt";
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        d1.save(path);
    }
    // Testing the save method for a incorrect input
    @Test (expected = IllegalArgumentException.class)
    public void testSave2() {
        String path = "";
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        d1.save(path);
    }
    // Testing the load method for a correct load of SimpleDate
    @Test
    public void testLoad() {
        SimpleDate d1 = new SimpleDate(10, 20, 2005);
        d1.load("test.txt");
    }

    // Testing the load method for a incorrect load of SimpleDate
    @Test (expected = IllegalArgumentException.class)
    public void testLoad2() {
        SimpleDate d1 = new SimpleDate(10, 20, 2005);
        d1.load("");
    }



    // Testing lesserMD method for true
    @Test
    public void testLesserMD() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 30, 2010);
        assertTrue(d2.lesserMD(d1));
    }
    // Testing lesserMD method for false
    @Test
    public void testLesserMD2() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertFalse(d1.lesserMD(d2));
    }
    // Testing greaterMD method
    @Test
    public void testGreaterMD() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertTrue(d1.greaterMD(d2));
    }
    // Testing greaterMD method for false
    @Test
    public void testGreaterMD2() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertFalse(d2.greaterMD(d1));
    }
    // Testing lesserMDY method for true different month
    @Test
    public void testLesserMDY() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertTrue(d2.lesserMDY(d1));
    }
    // Testing lesserMDY method for true same month
    @Test
    public void testLesserMDY2() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 30, 2010);
        assertTrue(d2.lesserMDY(d1));
    }
    // Testing greaterMDY method for false
    @Test
    public void testGreaterMDY() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertFalse(d2.greaterMDY(d1));
    }
    // Testing greaterMDY method for true same month
    @Test
    public void testGreaterMDY2() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 30, 2010);
        assertTrue(d1.greaterMDY(d2));
    }
    // Testing greaterMDY method for true different month
    @Test
    public void testGreaterMDY3() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertTrue(d1.greaterMDY(d2));
    }
    @Test
    public void testGreaterMDY4(){
        SimpleDate d1 = new SimpleDate(12, 31, 2011);
        SimpleDate d2 = new SimpleDate(11, 30, 2010);
        assertTrue(d1.greaterMDY(d2));
    }
    // Testing daysSince method for negative days
    @Test
    public void testDaysSince() {
        SimpleDate d1 = new SimpleDate(1, 15, 2019);
        SimpleDate d2 = new SimpleDate(1, 25, 2019);
        Assert.assertEquals(-10, d1.daysSince(d2));
    }
    // Testing daysSince method for different months
    @Test
    public void testDaysSince2() {
        SimpleDate d1 = new SimpleDate("3/2/2020");
        SimpleDate d2 = new SimpleDate("2/28/2020");
        Assert.assertEquals(-3, d2.daysSince(d1));
        Assert.assertEquals(3, d1.daysSince(d2));
    }
    // Testing daysSince method for different years
     @Test
    public void testDaysSince3() {
        SimpleDate d1 = new SimpleDate("3/2/2019");
        SimpleDate d2 = new SimpleDate("3/2/2018");
        Assert.assertEquals(-365, d2.daysSince(d1));
        Assert.assertEquals(365, d1.daysSince(d2));
    }
    // Testing daysSince method for same day
    @Test
    public void testDaysSince4() {
        SimpleDate d1 = new SimpleDate("3/2/2019");
        SimpleDate d2 = new SimpleDate("3/2/2019");
        Assert.assertEquals(0, d2.daysSince(d1));
        Assert.assertEquals(0, d1.daysSince(d2));
    }

    // Testing ordinalDate method
    @Test
    public void testOrdinalDate() {
        SimpleDate d1 = new SimpleDate(2, 10, 2013);
        assertEquals(41, d1.ordinalDate());
    }
    // Testing ordinalDate method for leapyear
    @Test
    public void testOrdinalDate2() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        assertEquals(61, d1.ordinalDate());
    }

    // Testing ordinalDate method for whole year
    @Test
    public void testOrdinalDate3() {
        SimpleDate d1 = new SimpleDate(12, 31, 2019);
        assertEquals(365, d1.ordinalDate());
    }
    // Testing ordinalDate method for whole year on a leap year
    @Test
    public void testOrdinalDate4() {
        SimpleDate d1 = new SimpleDate(12, 31, 2020);
        assertEquals(366, d1.ordinalDate());
    }
    // Testing setMonth method for correct month
    @Test
    public void testSetMonth() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setMonth(4);
        assertEquals(4, d1.getMonth());
    }
    // Testing setMonth method for incorrect month
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonth2() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setMonth(20);
    }

    // Testing setDay method for correct day set
    @Test
    public void testSetDay() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setDay(4);
        assertEquals(4, d1.getDay());
    }
    // Testing setDay method for incorrect day
    @Test (expected = IllegalArgumentException.class)
    public void testSetDay2() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setDay(54);
    }
    // Testing setYear method for correct year
    @Test
    public void testSetYear() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setYear(2004);
        assertEquals(2004, d1.getYear());
    }
    // Testing setYear method for incorrect year
    @Test (expected = IllegalArgumentException.class)
    public void testSetYear2() {
        SimpleDate d1 = new SimpleDate(3, 1, 2020);
        d1.setYear(20);
    }
    // Testing getNumberOfSimpleDates method for correct amount
    @Test
    public void testGetNumberOfSimpleDates() {
        SimpleDate.setCounter(0);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertEquals(2, d2.getNumberOfSimpleDates());
    }
    // Testing getNumberOfSimpleDates method for correct amount
    @Test
    public void testGetNumberOfSimpleDates2() {
        SimpleDate.setCounter(0);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertEquals(2, d2.getNumberOfSimpleDates());
    }
    // Testing the SimpleDate other method for correct parameters
    @Test
    public void testSimpleDateOther() {
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(d1);
    }

}
