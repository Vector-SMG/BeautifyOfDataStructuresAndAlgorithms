package com.cornucopia.algorithms.sort;

/**
 * 排序接口
 *
 * 1.如何分析一个"排序算法"?
 *   1.1  最好情况、最坏情况、平均情况时间复杂度。
 *   1.2  时间复杂度的系数、常数 、低阶。
 *   1.3  比较次数和交换次数。
 *
 * 2.排序算法的内存消耗
 *   原地排序，特指空间复杂度是O(1)的排序算法。
 *
 * 3.排序算法的稳定性
 *   3.1 经过某种算法，相同值前后顺序没有改变。称为稳定的排序算法。反之，为不稳定的排序算法。
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-05
 */
public interface ISort {

    void sort(int[] a,int n);

}
