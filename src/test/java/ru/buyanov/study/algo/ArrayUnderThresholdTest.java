package ru.buyanov.study.algo;

import org.junit.Before;
import org.junit.Test;
import ru.buyanov.study.algo.ArrayUnderThreshold;

import static java.lang.Integer.*;
import static org.junit.Assert.assertEquals;

/**
 * @author A.Buyanov 02.06.2016.
 */
public class ArrayUnderThresholdTest {
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

    @Test
    public void testAllDuplicates() {
        assertEquals(0, s.calc(new int[]{5,5,5,5,5,5,5}, 12));
    }

    @Test
    public void testAllDuplicatesExceptOne() {
        assertEquals(1, s.calc(new int[]{5,5,5,4,5,5,5}, 12));
    }

    @Test
    public void testBorders() {
        int[] arr = {MIN_VALUE, MIN_VALUE, MIN_VALUE + 1, 0, MAX_VALUE - 1, MAX_VALUE, MAX_VALUE};
        assertEquals(2, s.calc(arr, MIN_VALUE));
        assertEquals(7, s.calc(arr, 0));
        assertEquals(9, s.calc(arr, MAX_VALUE));
    }

    /*
    @Test
    public void test() {
        assertEquals(, s.calc(new int[]{}, ));
    }
    */
}
