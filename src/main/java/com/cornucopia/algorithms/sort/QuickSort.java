package com.cornucopia.algorithms.sort;

/**
 * 快速排序
 * 1.原理:如果排序的数组中下标从p到r之间的一组数据，我们选择p到r之间的任意一个数据作为pivot(分区点).遍历p到r之间的数据
 * 将小于pivot的放到左边，将大于pivot的放到右边，将pivot放到中间。可以用递归排序下标从p到q-1之间的数据和下标从q+1到r之间的数据
 * 直到区间缩减为1，所有数据都有序了。
 * 2.快速排序是不稳定的。
 * 3.复杂度
 *   3.1 如果每次分区操作，都能正好把数组分成大小接近相等的两个区间，那么快排的时间复杂度递推求解公式跟归并相同，快排的时间复杂度
 *   O(nlogn)。如果分配不均，时间复杂度为O(n*n)。
 *   todo 递归树对递归的时间复杂度进行分析，暂时得出结论，大部分情况下时间复杂度都可以做到O(nlogn)，极小概率退化到O(n*n)。并且有很多方法将这个
 *   todo 概率降到很低。
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-09
 */
public class QuickSort implements ISort {


    @Override
    public void sort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }


    /**
     * 快速排序
     *
     * @param a
     * @param start
     * @param end
     */
    private void quickSort(int[] a, int start, int end) {
        if (start >= end) return;

        int pivot = parition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private int parition(int[] a, int start, int end) {
        int pivot = a[end];
        int i = start;
        int j = start;
        for (; j < end+1; j++) {
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
