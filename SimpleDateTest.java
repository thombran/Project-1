package project1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This is just a small sample of JUnits, you are to write
 * many many more to have thorough coverage of your code; beyond 100%
 * statement coverage
 *
 * @author fergusor
 */

public class SimpleDateTest {

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
        assertTrue(d1.compareTo(d2) == 0);
    }
    @Test
    public void testCompareTo4() {
        SimpleDate d1 = new SimpleDate("3/1/2012");
        SimpleDate d2 = new SimpleDate("3/1/2013");
        assertTrue(d1.compareTo(d2) == -1);
    }


    // must use separate test cases for each error
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectYear() {
        SimpleDate d1 = new SimpleDate("3/1/1700");
    }

    // must use separate test cases for each error
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectMonth() {
        SimpleDate d1 = new SimpleDate("-3/1/1700");
    }

    // must use separate test cases for each error
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectLeapYear() {
        SimpleDate d1 = new SimpleDate("2/29/2000");
    }

    // must use separate test cases for each error
    @Test
    public void testSimpleDate() {
        SimpleDate d1 = new SimpleDate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectDate() {
        SimpleDate d1 = new SimpleDate("13/1/1700");
    }
    @Test
    public void testSimpleDateInt() {
        SimpleDate d1 = new SimpleDate(5,20,2010);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntMonth() {
        SimpleDate d1 = new SimpleDate(13,2,2010);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectIntLeapYear() {
        SimpleDate d1 = new SimpleDate(2,29,2000);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSimpleDateOtherBadMonth() {
        SimpleDate d1 = new SimpleDate(0,20,2010);
        SimpleDate d2 = new SimpleDate(d1);

    }
    @Test
    public void testDaysInMonth() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertTrue(d1.daysInMonth(1,2020) == 31);
    }
    @Test
    public void testDaysInMonthLeapYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertTrue(d1.daysInMonth(2,2020) == 29);
    }
    @Test
    public void testDaysInMonthNotLeapYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        assertTrue(d1.daysInMonth(2,2019) == 28);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonthBadMonth() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.daysInMonth(13,2020);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonthBadYear() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.daysInMonth(10,1600);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isLeapYearIntBad() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.isLeapYear(1700);
    }

    @Test
    public void testtoStringMethod() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        System.out.println(d1.toString());
    }

    @Test
    public void testEqualsNot() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        SimpleDate d2 = new SimpleDate(1,21,2010);
        assertFalse(d1.equals(d2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testEqualsBadInput() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        SimpleDate d2 = new SimpleDate(1,21,2010);
        assertFalse(d1.equals(1));
    }

    @Test
    public void testIncrement() {
        SimpleDate d1 = new SimpleDate(1,20,2010);
        d1.increment();
        assertTrue(d1.getDay() == 21);

    }

    @Test
    public void testIncrement2() {
        SimpleDate d1 = new SimpleDate(1,31,2010);
        d1.increment();
        assertTrue(d1.getDay() == 01);
        assertTrue(d1.getMonth() == 02);
    }
    @Test
    public void testIncrement3() {
        SimpleDate d1 = new SimpleDate(12,31,2010);
        d1.increment();
        assertTrue(d1.getDay() == 01);
        assertTrue(d1.getMonth() == 01);
        assertTrue(d1.getYear() == 2011);
    }

    @Test
    public void testCounter() {
        SimpleDate.setCounter(0);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertTrue(d2.getCounter() == 2);
    }

    @Test
    public void testGetNumberOfSimpleDates() {
        SimpleDate.setCounter(0);
        SimpleDate d1 = new SimpleDate(12, 31, 2010);
        SimpleDate d2 = new SimpleDate(12, 31, 2010);
        assertTrue(d2.getNumberOfSimpleDates() == 2);
    }
}