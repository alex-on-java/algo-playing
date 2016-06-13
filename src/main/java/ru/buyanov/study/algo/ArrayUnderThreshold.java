package ru.buyanov.study.algo;

import java.util.Arrays;

/**
 * @author A.Buyanov 02.06.2016.
 */
public class ArrayUnderThreshold {
    /**
     *
     * @param arr given array
     * @param threshold threshold
     * @return number of distinct pairs, such as x + y <= threshold
     */
    public int calc(int[] arr, int threshold) {
        int numberOfPairs = 0;
        if (arr.length <= 1)
            return numberOfPairs;
        Arrays.sort(arr); // O(n * log(n))
        int bound = findIndexOfElementThatIsLessOrEqual(arr, threshold / 2);
        if (bound == -1)
            return numberOfPairs;
        int countOfDuplicates = 0;
        for (int i = 0; i <= bound; i++) {
            if (i + 1 != arr.length && arr[i] == arr[i+1]) {
                countOfDuplicates++;
            }
        }
        numberOfPairs += c_from_n_to_k(bound + 1 - countOfDuplicates);
        int startForLess = bound;
        for (int j = bound + 1; j < arr.length; j++) {
            int greater = arr[j];
            if (arr[j - 1] == greater) {
                continue;
            }
            for (int i = startForLess; i >= 0 ; i--) {
                int less = arr[i];
                if (less == arr[i + 1]) { //TODO: check bound
                    countOfDuplicates--;
                    continue;
                }
                long sum = (long)less + (long)greater;
                if (sum <= (long)threshold) {
                    numberOfPairs += (i + 1 - countOfDuplicates);
                    startForLess = i;
                    break;
                }
            }
        }
        return numberOfPairs;
    }

    public int findIndexOfElementThatIsLessOrEqual(int[] arr, int num) {
        return findIndexOfElementThatIsLessOrEqual(arr, 0, arr.length, num);
    }

    /**
     * O(log(n))
     *
     * @param arr - array, in which we are looking for the most right element, that is less or equal than num. Must be sorted
     * @param leftBound - included
     * @param rightBound - excluded
     * @param num - number, that 
     * @return index of the element, that is less or equal than the num
     */

    protected int findIndexOfElementThatIsLessOrEqual(int[] arr, int leftBound, int rightBound, int num) {
        if (arr.length == 0)
            throw new IllegalArgumentException("Input array must contain at least 1 element");
        int diff = rightBound - leftBound;
        if (diff == 1) {
            return arr[leftBound] <= num ? leftBound : -1;
        }
        int index = leftBound + (diff) / 2 - 1;
        if (arr[index] == num) {
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] > num)
                    return --i;
            }
        }
        if (arr[index] > num) {
            return findIndexOfElementThatIsLessOrEqual(arr, leftBound, index + 1, num);
        }
        else { // arr[index] < num 
            if (arr[index + 1] > num)
                return index;
            return findIndexOfElementThatIsLessOrEqual(arr, index + 1, rightBound, num);
        }
    }

    protected int c_from_n_to_k(int cnt) {
        if (cnt == 0)
            return 0;
        int r = 0;
        for (int i = 1; i < cnt; i++) {
            r += i;
        }
        return r;
    }
}
