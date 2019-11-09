package com.cornucopia.algorithms.sort;

/**
 * 归并排序
 *
 *
 * 1.原理:将一个数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起，整个数组就有序了。
 * 2.归并排序是一种稳定的排序算法。
 * 3.复杂度
 *   3.1 时间复杂度分析
 *       如果a问题可以分解为b,c两个子问题，那么有
 *       T(a)=T(b)+T(c)+K，K是合并需要的时间
 *       =>
 *       T(1)=C;            n=1时，只需常量级的执行时间，所以表示为C。
 *       T(n)=2*T(n/2)+n;   n>1
 *       =>
 *       T(n)=2*T(n/2)+n
 *           =2*(2*T(n/4)+n/2)+n=4*T(n/4)+2*n
 *       =>
 *           =2^k*T(n/2^k)+k*n
 *       =>
 *           因为T(n/2^k)=T(1)
 *           n/2^k=1 =>k=log2(n)
 *           代入上述表达式
 *       T(n)=Cn+nlog2(n)。
 *       T(n)=O(nlog2(n))
 *
 *   3.2 空间复杂度
 *       应为合并操作，每次都需要申请额外的内存空间，合并完成之后，临时开辟的内存空间被释放掉了。在任意时刻，CPU只会有一个函数在执行，只会有一个临时
 *       的内存空间在使用。但是临时空间最大也不会超过n个数据的大小，所以空间复杂度是O(n)。
 *
 *
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-07
 */
public class MergeSort implements ISort {


    @Override
    public void sort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
    }


    public void mergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        //取到start和end之间的位置start
        int middle = (start + end) / 2;
        //分治递归
        mergeSort(array, start, middle);
        mergeSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }


    /**
     * 申请一个大小为(end-start+1)的数组，申请两个游标i,j将其分别指向两个子数组(array[start,middle],array[middle+,end])的第一个元素,
     * 然后比较array[i],array[j],如果array[i]<=array[j],则将array[i]放大tmp中，并且将i后移一位，否则将array[j]放入到数组tmp，j后移动
     * 一位。
     *
     * @param array
     * @param start
     * @param middle
     * @param end
     */
    private void merge(int[] array, int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int k = 0;

        int[] tmp = new int[end-start+1];
        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        //判断哪个子数组中剩余的数据
        int start_c = i;
        int end_c = middle;

        if (j <= end) {
            start_c = j;
            end_c = end;
        }
        //将剩余的数据加入到tmp中
        while (start_c <= end_c) {
            tmp[k++] = array[start_c++];
        }

        //最后将排序号的数据拷贝给array
        for (int z = 0; z <= end - start; z++) {
            array[start + z] = tmp[z];
        }

    }
}
