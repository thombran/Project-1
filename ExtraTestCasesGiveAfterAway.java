package project1;

import org.junit.Assert;
import org.junit.Test;

public class ExtraTestCasesGiveAfterAway {

    private SimpleDate d1 = new SimpleDate(1, 1, 2019);
    private SimpleDate d4 = new SimpleDate(12, 31, 2020);
    private SimpleDate d6 = new SimpleDate(12, 30, 2022);

    private SimpleDate e1a = new SimpleDate("1/1/2018");
    private SimpleDate e1b = new SimpleDate("1/1/2018");
    private SimpleDate e2 = new SimpleDate("1/2/2018");

    @Test
    public void January1stIsDay1() {
        SimpleDate a = new SimpleDate("1/1/2018");
        Assert.assertEquals(1, a.ordinalDate());
        a = new SimpleDate("3/1/2019");
        Assert.assertEquals(60, a.ordinalDate());
    }

    @Test
    public void test() {
        Assert.assertTrue("1980 should be a leap year", SimpleDate.isLeapYear(1980));
        Assert.assertFalse("1981 should not be a leap year", SimpleDate.isLeapYear(1981));
        Assert.assertFalse("1900 should not be a leap year", SimpleDate.isLeapYear(1900));
        Assert.assertFalse("2018 should be a leap year", SimpleDate.isLeapYear(2018));

        verifyValidDateString("1/1/2007", 1, 1, 2007);
        verifyValidDateString("01/01/2007", 1, 1, 2007);

    }

    private void verifyValidDateString(String s, int month, int day, int year) {
        SimpleDate date = new SimpleDate(s);

        Assert.assertEquals("Problem with day when creating " + s, day, date
                .getDay());
        Assert.assertEquals("Problem with month when creating " + s, month,
                date.getMonth());
        Assert.assertEquals("Problem with year when creating " + s, year, date
                .getYear());
    }



    @Test(expected = IllegalArgumentException.class)
    public void constructorDetectsMonthTooHigh() {
        new SimpleDate("13/1/1980");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorHandlesDateWithUnparsableField() {
        new SimpleDate("hiMom!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorHandlesDateWithMissingField() {
        new SimpleDate("1/2");
    }


    @Test
    public void datesWithDifferentDayAreNotEqual() {
        Assert.assertTrue(!e1a.equals(e2));
    }

    @Test
    public void fromNow3() {
        SimpleDate d1 = new SimpleDate(12, 12, 2019);
        SimpleDate d4 = new SimpleDate(12, 31, 2020);
        Assert.assertEquals(d1, d4.daysFromNow(-385));
    }


    @Test
    public void fromNow4() {
        Assert.assertEquals(d4, d1.daysFromNow(730));
    }


    @Test
    public void fromNow7() {
        SimpleDate other1 = new SimpleDate("3/1/2020");
        SimpleDate other2 = new SimpleDate("2/26/2020");
        SimpleDate temp = new SimpleDate("2/28/2020");
        Assert.assertEquals(other1, temp.daysFromNow(2));
        Assert.assertEquals(other2, temp.daysFromNow(-2));
    }


    @Test
    public void since4() {
        Assert.assertEquals(-1459, d1.daysSince(d6));
    }

    @Test
    public void since5() {
        Assert.assertEquals(1459, d6.daysSince(d1));
    }

    @Test
    public void since6() {
        SimpleDate other = new SimpleDate("3/1/2020");
        SimpleDate temp = new SimpleDate("2/28/2020");
        Assert.assertEquals(-2, temp.daysSince(other));
        Assert.assertEquals(2, other.daysSince(temp));
    }

    @Test (expected = IllegalArgumentException.class)
    public void fromNow8() {
        SimpleDate other1 = new SimpleDate("3/1/1760");
        other1.daysFromNow(-9000);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testSaveLoadError() {

        SimpleDate d = new SimpleDate(1, 11, 2018);
        d.save("-!@#$%^&*()testit-.txt");

    }



    @Test
    public void testIncrementAndDecrement() {
        SimpleDate test = new SimpleDate(1, 1, 1753);
        SimpleDate expected = new SimpleDate(3, 2, 1772);
        for (int i = 0; i < 7000; i++) {
            test.increment();
        }

        Assert.assertEquals(expected, test);
    }


    @Test
    public void testequals1() {
        SimpleDate d1 = new SimpleDate(2, 22, 2021);
        SimpleDate d2 = new SimpleDate(2, 22, 2021);
        Assert.assertEquals(d1, d2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testequals3() {
        SimpleDate d1 = new SimpleDate(2, 29, 2021);
        d1.equals(null);
    }
}


