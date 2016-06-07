package ru.buyanov.study.coursera;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author A.Buyanov 02.06.2016.
 */
public class ArrayUnderThresholdTest {
    public static final int PLACEHOLDER = -1;
    ArrayUnderThreshold s;

    @Before
    public void setUp() {
        s = new ArrayUnderThreshold();
    }

    @Test
    public void testBlankArray() {
        assertEquals(0, s.calc(new int[0], 0));
    }

    @Test
    public void testAllElementsAreOverThreshold() {
        assertEquals(0, s.calc(new int[]{5,6,7,8}, 4));
    }

    @Test
    public void testTwoElementsUnderThreshold() {
        assertEquals(0, s.calc(new int[]{3,4,6,7,8}, 5));
    }

    @Test
    public void testOnlyOneElementUnderHalfOfThresholdOthersAreGreaterThanThreshold() {
        assertEquals(0, s.calc(new int[]{2,5,8,6,7}, 4));
    }

    @Test
    public void testOnlyTwoElementsUnderHalfOfThresholdOthersAreGreaterThanThreshold() {
        assertEquals(1, s.calc(new int[]{1,2,6,7,8,9}, 5));
    }

    @Test
    public void testAllAreUnderHalfOfThreshold() {
        assertEquals(6, s.calc(new int[]{1,2,3,4}, 9));
    }

    @Test
    public void testOneElementInEachQuarter() {
        assertEquals(2, s.calc(new int[]{2,4,6,8}, 9));
    }

    @Test
    public void testOneElementInEachEighth() {
        assertEquals(12, s.calc(new int[]{2,4,6,8,10,12,14,16}, 17));
    }

    /*
    @Test
    public void test() {
        assertEquals(, s.calc(new int[]{}, ));
    }
    */
}
