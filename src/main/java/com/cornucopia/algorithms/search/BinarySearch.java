package com.cornucopia.algorithms.search;

/**
 * 二分查找
 *
 *
 *
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-12
 */
public class BinarySearch {


    /**
     * 二分查找
     *
     * @param a
     * @param n
     * @param value
     */
    public static int search(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (a[middle] == value) {
                return middle;
            } else if (a[middle] < value) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }


    /**
     * 递归实现二分查找
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int recursionSearch(int a[], int n, int value) {
        return coreRecursionSearch(a, 0, n - 1, value);

    }


    public static int coreRecursionSearch(int a[], int low, int high, int value) {
        if (low > high) return -1;
        int middle = low + ((high - low) >> 1);
        if (a[middle] == value) {
            return middle;
        } else if (a[middle] > value) {
            return coreRecursionSearch(a, low, middle - 1, value);
        } else {
            return coreRecursionSearch(a, middle+1, high, value);
        }

    }


    public static void main(String args[]) {
        int a[] = {1, 290, 291, 1000, 100000};
//        int result = search(a, a.length, -1);
        int result = recursionSearch(a, a.length, 290);
        System.out.println(result);
    }


}
