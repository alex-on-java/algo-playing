package ru.buyanov.study.algo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author A.Buyanov 11.05.2017.
 */
public class PalindromeTest {
    private Palindrome palindrome;

    @Before
    public void startUp() {
        palindrome = new Palindrome();
    }

    @Test
    public void testCheck_nullString() {
        assertFalse(palindrome.check(null));
    }

    @Test
    public void testCheck_emptyString() {
        assertFalse(palindrome.check(""));
    }

    @Test
    public void testCheck_oneSymbol() {
        assertTrue(palindrome.check("a"));
    }

    @Test
    public void testCheck_twoDifferentSymbols() {
        assertFalse(palindrome.check("ab"));
    }

    @Test
    public void testCheck_twoSameSymbols() {
        assertTrue(palindrome.check("aa"));
    }

    @Test
    public void testCheck_palindromeOddSymbols() {
        assertTrue(palindrome.check("Madam, I’m Adam"));
    }

    @Test
    public void testCheck_palindromeEvenSymbols() {
        assertTrue(palindrome.check("Sum summus mus"));
    }

    @Test
    public void testCheck_palindromeWithMaxLength() {
        assertTrue(palindrome.check("Saippuakivikauppias"));
    }

    @Test
    public void testCheck_palindromeOfNumbers() {
        assertTrue(palindrome.check("12345654321"));
    }
}
