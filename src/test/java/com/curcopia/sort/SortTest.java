package com.curcopia.sort;

import com.cornucopia.algorithms.sort.ISort;
import com.cornucopia.algorithms.sort.MergeSort;
import com.cornucopia.algorithms.sort.QuickSort;
import org.junit.Test;

/**
 * 排序测试.
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-05
 */
public class SortTest {

    @Test
    public void sort() {
        int a[] = {0, 1, 2, 3, 4, -100, -10,123,23,11,12,56,20};
//      printElementOfSort(new BubbleSort(),a,a.length);
//      printElementOfSort(new InsertionSort(),a,a.length);
//      printElementOfSort(new SectionSort(), a, a.length);
//        printElementOfSort(new MergeSort(), a, a.length);
        printElementOfSort(new QuickSort(), a, a.length);
    }


    /**
     * @param sort
     * @param a
     * @param length
     */
    private void printElementOfSort(ISort sort, int a[], int length) {
        System.out.println("排序前:");
        print(a, length);
        sort.sort(a, length);
        System.out.println("\n排序后:");
        print(a, length);
    }


    /**
     * 打印数组元素
     *
     * @param a
     * @param length
     */
    private void print(int a[], int length) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }


}
