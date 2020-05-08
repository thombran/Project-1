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

public class SimpleDateTestGIVETOSTUDENTS {

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
        assertTrue(d1.compareTo(d2) > 0);
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
	public void testIncorrectLearYear() {
		SimpleDate d1 = new SimpleDate("2/29/2000");
	}

}
