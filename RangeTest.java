package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    //private Range exampleRange1;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }
    
    //@Before 
    //public void setUp() throws Exception { exampleRange1 = new Range(1, 2);
    //}


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeZer() {
    	Range obj1 = new Range(1, 5);
        assertEquals("The central value of -1 and 1 should be 0",
        3, obj1.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueOfPositiveRange() {
    	Range positiveRange = new Range(2, 4);
        assertEquals("The central value of -1 and 1 should be 0",
        3, positiveRange.getCentralValue(), .000000001d);
    }
    
    
    @Test
    public void centralValueOfNegativeRange() {
        Range negativeRange = new Range(-5, -1);
        assertEquals("The central value of a negative range from -5 to -1 should be -3",
                -3, negativeRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueOfSymmetricRangeShouldBeMidpoint() {
        Range symmetricRange = new Range(-3, 3);
        assertEquals("The central value of a symmetric range from -3 to 3 should be 0",
                0, symmetricRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfAsymmetricRangeShouldBeMidpoint() {
        Range symmetricRange = new Range(-2, 4);
        assertEquals("The central value of a symmetric range from -2 to 4 should be 1",
                1, symmetricRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueOfOddLenghtRange() {
        Range oddLenghtRange = new Range(1, 6);
        assertEquals("The central value of a symmetric range from -2 to 4 should be 1",
                3.5, oddLenghtRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueOfEvenLenghtRange() {
        Range oddLenghtRange = new Range(2, 6);
        assertEquals("The central value of a symmetric range from 2 to 6 should be 4",
                4, oddLenghtRange.getCentralValue(), .000000001d);
    }
    @Test
    public void lengthOfRangeShouldBeTwo() {
        assertEquals("The length of the range from -1 to 1 should be 2",
                2.0, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void centralValueOfSinglePointRangeShouldBeThatValue() {
        Range singlePointRange = new Range(5, 5);
        assertEquals("The central value of a single-point range with value 5 should be 5",
                5, singlePointRange.getCentralValue(), .000000001d);
    }

    
    @Test
    public void shouldContainZero() {
    	Range obj1 = new Range(-1, 1);
    	assertTrue("The Range from -1 to 1 should contain", obj1.contains(0));
    }
    
    @Test
    public void shouldContainCentralValue() {
    	Range obj1 = new Range(-1, 1);
    	double centralValue = obj1.getCentralValue();
    	assertTrue("The Range from -1 to 1 should contain", obj1.contains(centralValue));
    }
    
    @Test
    public void shouldNotContainValueOutside() {
    	Range obj1 = new Range(-1, 1);
    	assertFalse("The Range from -1 to 1 should not contain", obj1.contains(-2.0));
    }
    
    @Test
    public void shouldContainLowerBound() {
    	Range obj1 = new Range(0, 2);
    	double lowerBound = obj1.getLowerBound();
    	assertTrue("The Range from -1 to 1 should not contain", obj1.contains(lowerBound));
    }
    
    @Test
    public void lowerBoundOfNaNRange() {
        Range nanRange = new Range(Double.NaN, Double.NaN);
        assertTrue("The lower bound of a NaN range should be NaN",
                Double.isNaN(nanRange.getLowerBound()));
    }

    @Test
    public void lowerBoundOfInfiniteRange() {
        Range infiniteRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        assertEquals("The lower bound of an infinite range should be negative infinity",
                Double.NEGATIVE_INFINITY, infiniteRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundOfZeroToZeroRange() {
        Range zeroRange = new Range(0, 0);
        assertEquals("The lower bound of a range from 0 to 0 should be 0",
                0, zeroRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundOfNegativeToZeroRange() {
        Range negativeToZeroRange = new Range(-2, 0);
        assertEquals("The lower bound of a range from -2 to 0 should be -2",
                -2, negativeToZeroRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundWithNegativeValue() {
        Range negativeRange = new Range(-5, 2);
        assertEquals("The lower bound of a range from -5 to 2 should be -5",
                -5, negativeRange.getLowerBound(), .000000001d);
    }
   

   

    

    
    @Test
    public void shouldContainUpperBound() {
    	Range obj1 = new Range(4, 5);
    	double upperBound = obj1.getUpperBound();
    	assertTrue("The Range from -1 to 1 should not contain", obj1.contains(upperBound));
    }
    
    @Test
    public void shouldNotContainValueJustBelowLowerBound() {
    	Range obj1 = new Range(2, 4);
        assertFalse("The Range from 2 to 4 should not contain a value just below its lower bound",
        		obj1.contains(obj1.getLowerBound() - 0.000001d));
    }

    @Test
    public void shouldNotContainValueJustAboveUpperBound() {
    	Range obj1 = new Range(2, 4);
        assertFalse("The Range from 2 to 4 should not contain a value just above its upper bound",
        		obj1.contains(obj1.getUpperBound() + 0.000001d));
    }


    
    /*@Test
    public void shouldNotContainInEmptyRange() {
        Range emptyRange = new Range(2, 1);
        assertFalse("An empty range should not contain any value",
                emptyRange.contains(1.5));
    }*/

    @Test
    public void lowerBoundShouldBeCorrect() {
        assertEquals("The lower bound of the range should be -1",
                -1.0, exampleRange.getLowerBound(), .000000001d);
    }
    
    
    
    @Test
    public void upperBoundShouldBeCorrect() {
        assertEquals("The upper bound of the range should be 1",
                1.0, exampleRange.getUpperBound(), .000000001d);
    }
    
    
    
    @Test
    public void toStringShouldReturnCorrectRepresentation() {
        String expectedRepresentation = "Range[-1.0, 1.0]";
        assertEquals("The toString() method should return the correct representation",
                expectedRepresentation, exampleRange.toString());
    }
    
    
    @Test
    public void lowerBoundOfPositiveRange() {
        Range positiveRange = new Range(2, 5);
        assertEquals("The lower bound of a positive range from 2 to 5 should be 2",
                2, positiveRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundOfNegativeRange() {
        Range negativeRange = new Range(-5, -2);
        assertEquals("The lower bound of a negative range from -5 to -2 should be -5",
                -5, negativeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundOfSinglePointRange() {
        Range singlePointRange = new Range(7, 7);
        assertEquals("The lower bound of a single-point range with value 7 should be 7",
                7, singlePointRange.getLowerBound(), .000000001d);
    }

  
    @Test
    public void upperBoundOfLargePositiveRange() {
        Range largePositiveRange = new Range(1e12, 2e12);
        assertEquals("The lower bound of a large positive range should be the start value",
                1e12, largePositiveRange.getLowerBound(), .000000001d);
    }

    


    @Test
    public void lowerBoundWithNonIntegerValue() {
        Range nonIntegerRange = new Range(1.5, 4.5);
        assertEquals("The lower bound of a range with non-integer values should be the start value",
                1.5, nonIntegerRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundWithNonIntegerStartValue() {
        Range nonIntegerStartRange = new Range(1.5, 4.5);
        assertEquals("The lower bound of a range with non-integer start value should be the start value",
                1.5, nonIntegerStartRange.getLowerBound(), .000000001d);
    }

  
    @Test
    public void lowerBoundOfLargePositiveRange() {
        Range largePositiveRange = new Range(1e12, 2e12);
        assertEquals("The lower bound of a large positive range should be the start value",
                1e12, largePositiveRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lowerBoundOfLargeNegativeRange() {
        Range largeNegativeRange = new Range(-2e12, -1e12);
        assertEquals("The lower bound of a large negative range should be the start value",
                -2e12, largeNegativeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void lengthOfPositiveRangeShouldBeCorrect() {
        Range positiveRange = new Range(2, 5);
        assertEquals("The length of a positive range from 2 to 5 should be 3",
                3, positiveRange.getLength(), .000000001d);
    }

    @Test
    public void lengthOfNegativeRangeShouldBeCorrect() {
        Range negativeRange = new Range(-5, -2);
        assertEquals("The length of a negative range from -5 to -2 should be 3",
                3, negativeRange.getLength(), .000000001d);
    }

    @Test
    public void lengthOfSinglePointRangeShouldBeZero() {
        Range singlePointRange = new Range(7, 7);
        assertEquals("The length of a single-point range with value 7 should be 0",
                0, singlePointRange.getLength(), .000000001d);
    }

    @Test
    public void lengthOfLargePositiveRangeShouldBeCorrect() {
        Range largePositiveRange = new Range(1e12, 2e12);
        assertEquals("The length of a large positive range should be the difference between start and end values",
                1e12, largePositiveRange.getLength(), .000000001d);
    }

    @Test
    public void lengthOfLargeNegativeRangeShouldBeCorrect() {
        Range largeNegativeRange = new Range(-2e12, -1e12);
        assertEquals("The length of a large negative range should be the difference between start and end values",
                1e12, largeNegativeRange.getLength(), .000000001d);
    }
    
 // Existing tests...

    @Test
    public void lowerBoundShouldBeCorrectForNegativeRange() {
        Range negativeRange = new Range(-3, -1);
        assertEquals("The lower bound of the range from -3 to -1 should be -3",
                -3.0, negativeRange.getLowerBound(), .000000001d);
    }

    @Test
    public void upperBoundShouldBeCorrectForPositiveRange() {
        Range positiveRange = new Range(2, 5);
        assertEquals("The upper bound of a positive range from 2 to 5 should be 5",
                5.0, positiveRange.getUpperBound(), .000000001d);
    }

    @Test
    public void getLengthShouldBeZeroForSinglePointRange() {
        Range singlePointRange = new Range(7, 7);
        assertEquals("The length of a single-point range with value 7 should be 0",
                0.0, singlePointRange.getLength(), .000000001d);
    }

    @Test
    public void getLengthShouldBeCorrectForLargePositiveRange() {
        Range largePositiveRange = new Range(1e12, 2e12);
        assertEquals("The length of a large positive range should be the difference between start and end values",
                1e12, largePositiveRange.getLength(), .000000001d);
    }

    @Test
    public void testEqualsSameObject() {
        assertTrue("The Range should be equal to itself", exampleRange.equals(exampleRange));
    }

    @Test
    public void testEqualsEqualRanges() {
        Range equalRange = new Range(-1, 1);
        assertTrue("Equal ranges should be considered equal", exampleRange.equals(equalRange));
    }

    @Test
    public void testEqualsDifferentRanges() {
        Range differentRange = new Range(0, 2);
        assertFalse("Different ranges should not be considered equal", exampleRange.equals(differentRange));
    }

    @Test
    public void testEqualsDifferentObject() {
        assertFalse("A Range should not be equal to a different type of object", exampleRange.equals("Not a Range"));
    }

    @Test
    public void testEqualsNullObject() {
        assertFalse("A Range should not be equal to null", exampleRange.equals(null));
    }

    @Test
    public void testEqualsSymmetricProperty() {
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 3);

        assertTrue("The equals method should have symmetric property", range1.equals(range2) && range2.equals(range1));
    }

    @Test
    public void testEqualsTransitiveProperty() {
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 3);
        Range range3 = new Range(1, 3);

        assertTrue("The equals method should have transitive property",
                range1.equals(range2) && range2.equals(range3) && range1.equals(range3));
    }
   

    @Test
    public void testEqualsDifferentUpperBound() {
        Range equalLowerBoundRange = new Range(-1, 2);
        assertFalse("Ranges with different upper bounds should not be considered equal", exampleRange.equals(equalLowerBoundRange));
    }

    
    
    @Test
    public void testCombine() {
        Range range1 = new Range(1, 3);
        Range range2 = new Range(2, 4);

        Range combinedRange = Range.combine(range1, range2);

        assertEquals("Combining ranges [1,3] and [2,4] should result in [1,4]",
                new Range(1, 4), combinedRange);
    }
    
    @Test
    public void testCombineWithNullRange1() {
        Range range2 = new Range(2, 4);
        Range combinedRange = Range.combine(null, range2);
        assertEquals("Combining null range and [2,4] should result in [2,4]", range2, combinedRange);
    }

    @Test
    public void testCombineWithNullRange2() {
        Range range1 = new Range(1, 3);
        Range combinedRange = Range.combine(range1, null);
        assertEquals("Combining [1,3] and null range should result in [1,3]", range1, combinedRange);
    }

   
    
    @Test
    public void testGetLengthInvalidRange() {
        try {
            Range invalidRange = new Range(3, 1);
            invalidRange.getLength();
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            String expectedMessage = "Range(double, double): require lower (3.0) <= upper (1.0).";
            assertEquals(expectedMessage, e.getMessage());
        }
    }


    

    // Test for the branch where lower <= upper
    @Test
    public void testGetLengthValidRange() {
        Range validRange = new Range(1, 3);

        // This should not throw an exception
        double length = validRange.getLength();

        // You can add assertions to check the calculated length if needed
        assertEquals(2.0, length, .000000001d);
    }
    
    
    
    @Test
    public void testGetLowerBoundInvalidRange() {
        try {
            Range invalidRange = new Range(3, 1);
            invalidRange.getLowerBound();

            // Fail the test if no exception is thrown
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Check if the exception message is as expected
            String expectedMessage = "Range(double, double): require lower (3.0) <= upper (1.0).";
            assertEquals(expectedMessage, e.getMessage());
        }
    }







    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
