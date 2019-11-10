package com.cornucopia.algorithms.sort.utils;

/**
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-10
 */
public class SortUtils {


    /**
     * 分区方法，来自快排
     * 将最后一个元素当做分区点，并且使用游标i,j都指向start位置的元素，并将j往后移动，比较a[i]和pivot分区大小，如果a[i]<pivot，则
     * 将a[i]和a[j]交换。最后，将a[i]和a[end]交换。最终将pivot移动到中间位置
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public static int parition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        int j = start;
        for (; j < end + 1; j++) {
            if (a[j] < pivot) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[end];
        a[end] = tmp;
        return i;
    }


}
