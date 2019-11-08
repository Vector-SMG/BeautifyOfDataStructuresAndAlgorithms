package com.cornucopia.algorithms.sort;

/**
 * 归并排序
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019/11/8
 */
public class MergeSort implements ISort {


    @Override
    public void sort(int[] array, int n) {
        mergeSort(array, 0, n - 1);
    }

    /**
     * 递归
     *
     * @param array
     * @param start
     * @param end
     */
    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);

    }
}
