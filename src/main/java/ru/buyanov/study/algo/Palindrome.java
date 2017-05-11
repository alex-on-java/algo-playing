package ru.buyanov.study.algo;

import java.util.stream.IntStream;

/**
 * @author A.Buyanov 11.05.2017.
 */
public class Palindrome {

    /**
     * This method uses chars to check the string.
     * Should remove insignificant characters from the input before call.
     * @param s String that could be palindrome
     * @return {@code true} if {@code s} is a palindrome, false otherwise
     */
    public boolean check(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() < 2) {
            return s.length() == 1;
        }
        char[] charArray = s.toCharArray();
        return IntStream.rangeClosed(0, charArray.length / 2)
                .allMatch(i -> charArray[i] == charArray[charArray.length - i - 1]);
    }
}
