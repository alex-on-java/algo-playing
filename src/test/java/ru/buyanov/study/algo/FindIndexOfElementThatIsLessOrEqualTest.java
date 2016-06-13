package ru.buyanov.study.algo;

import org.junit.Before;
import org.junit.Test;
import ru.buyanov.study.algo.ArrayUnderThreshold;

import static org.junit.Assert.assertEquals;

/**
 * @author A.Buyanov 13.06.2016.
 */
public class FindIndexOfElementThatIsLessOrEqualTest {
    public static final int PLACEHOLDER = -1;
    ArrayUnderThreshold s;

    @Before
    public void setUp() {
        s = new ArrayUnderThreshold();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArray() {
        assertEquals(PLACEHOLDER, s.findIndexOfElementThatIsLessOrEqual(new int[]{}, PLACEHOLDER));
    }

    @Test
    public void testTwoElements_middle() {
        assertEquals(0, s.findIndexOfElementThatIsLessOrEqual(new int[]{1, 3}, 2));
    }

    @Test
    public void testTwoElements_leftEqual() {
        assertEquals(0, s.findIndexOfElementThatIsLessOrEqual(new int[]{1,2}, 1));
    }

    @Test
    public void testTwoElements_rightEqual() {
        assertEquals(1, s.findIndexOfElementThatIsLessOrEqual(new int[]{1,2}, 2));
    }

    @Test
    public void testGreaterThanRight() {
        assertEquals(3, s.findIndexOfElementThatIsLessOrEqual(new int[]{1,2,5,8}, 9));
    }

    @Test
    public void testLessThanLeft() {
        assertEquals(-1, s.findIndexOfElementThatIsLessOrEqual(new int[]{2,4,6,8}, 1));
    }

    @Test
    public void testSeveralEquals() {
        assertEquals(4, s.findIndexOfElementThatIsLessOrEqual(new int[]{1,2,5,5,5,6,7,8,9,10,11,12}, 5));
    }

    /*

    @Test
    public void t() {
        assertEquals(PLACEHOLDER, s.findIndexOfElementThatIsLessOrEqual(new int[]{}, PLACEHOLDER));
    }

     */
}
