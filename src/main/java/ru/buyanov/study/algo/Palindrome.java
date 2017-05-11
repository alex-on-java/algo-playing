package ru.buyanov.study.algo;

/**
 * @author A.Buyanov 11.05.2017.
 */
public class Palindrome {

    /**
     *
     * @param s String that could be palindrome
     * @return {@code true} if {@code s} is a palindrome, false otherwise
     */
    public boolean check(String s) {
        if (s == null) {
            return false;
        }
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (s.isEmpty())
            return false;
        if (s.length() == 1) {
            return true;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
