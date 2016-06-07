package ru.buyanov.study.coursera;

/**
 * @author A.Buyanov 02.06.2016.
 */
public class ArrayUnderThreshold {
    /**
     * Первый проход - выкидываем(?) все элементы больше threshold
     * Подумать, если можно сделать лучше чем переносить их в конец массива
     * Выкидываем все дубликаты
     * Нач

     */
    public int calc(int[] arr, int threshold) {
        if (arr.length == 0)
            return 0;
        int cnt = 0;
        double divider = 2;
        double delimiter = threshold / divider;
        if (delimiter < 1)
            return 0;
        int right, left = 0;
        for (int e : arr) {
            if (e <= delimiter)
                left++;
        }
        cnt += c_from_n_to_k(left);
        for (int i = 2;; i++) {
            divider = Math.pow(2, new Integer(i).doubleValue());
            delimiter = threshold / divider;
            if (delimiter < 1)
                break;
            left = 0;
            right = 0;
            for (int e : arr) {
                if (e <= delimiter)
                    left++;
                else
                    right++;
            }
        }

        return cnt;
    }

    private int c_from_n_to_k(int cnt) {
        if (cnt == 0)
            return 0;
        int r = 0;
        for (int i = 1; i < cnt; i++) {
            r += i;
        }
        return r;
    }
    //private
    /**
     * t == 16
     * iter1 {
     *       i = 8
     *       if arr[j] <= 8
     *       cnt++
     *       }
     * iter2 {
     *     i = 4
     *     if arr[j] < 4
     *      cnt_1++
     *     if arr[j] > 8 <= 12
     *       cnt_2++
     * }
     * iter3 {
     *     i = 2
     *     if arr[j] < 2
     *       cnt_a_1++
     *     if arr[j] > 14 && arr[j] <= 16
     *       cnt_a_2++
     *     if arr[j] > 4 && arr[j] < 6
     *       cnt_b_1++
     *     if arr[j] > 12 && arr[j] <= 14
     *       cnt_b_2++
     * }
     */
}
