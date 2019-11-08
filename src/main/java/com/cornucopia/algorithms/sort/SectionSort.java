package com.cornucopia.algorithms.sort;

/**
 * 选择排序(Selection Sort)
 * 1.原理:将数组分为已排序区间和未排序区间。每次会从为排序区间中找到最小的元素，将其放到已排序的末尾。
 * 2.复杂度
 *   2.1 空间复杂度为O(1)，是一种原地排序算法。
 *   2.2 最好，最坏，平均情况复杂度都为O(n^2)。
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019/11/7
 */
public class SectionSort implements ISort {

    @Override
    public void sort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n - 1; i++) {
            int value = a[i];
            int j = i;
            int tmp = j + 1;
            //取最小值的下标
            for (; j < n - 1; j++) {
                if (a[tmp] > a[j + 1]) {
                    tmp = j + 1;
                }
            }
            //交换
            if (a[i] > a[tmp]) {
                a[i] = a[tmp];
                a[tmp] = value;
            }
        }
    }
}
