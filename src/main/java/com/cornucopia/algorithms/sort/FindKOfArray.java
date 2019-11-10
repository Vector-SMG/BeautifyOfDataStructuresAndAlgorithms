package com.cornucopia.algorithms.sort;

import com.cornucopia.algorithms.sort.utils.SortUtils;

/**
 * O(n)时间复杂度内求无序数组中的第K大元素，比如:4,2,5,12,3这样一组数据，第三大元素就是4
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-10
 */
public class FindKOfArray {


    public int find(int a[], int n, int k) {
        if (a == null) {
            throw new IllegalArgumentException("数组不能为空!");
        }

        if (k > n - 1 || k <= 0) {
            throw new IllegalArgumentException("k值必须大于0且小于等于" + n);
        }

        return findK(a, 0, n - 1, k);
    }

    /**
     * 寻找无序数组中第k大的元素.寻找分区点pivot.并将数组划分为(start,pivot-1)以及(pivot+1,end)
     * pivot+1和k的比较，当k小于pivot+1，应该寻找(start,pivot-1);当k大于pivot+1,应该寻找(pivot+1,end)
     * 直到pivot+1=k
     *
     * @param a     数组
     * @param start
     * @param end
     */
    private int findK(int[] a, int start, int end, int k) {
        int pivot = SortUtils.parition(a, start, end);
        while (pivot + 1 != k) {
            if (pivot + 1 > k) {
                findK(a, start, pivot - 1, k);
            } else {
                findK(a, pivot + 1, end, k);
            }
        }
        return a[pivot];
    }


}
