package com.cornucopia.algorithms.search;

/**
 * 二分查找以及二分查找的变种.
 *
 * 2.二分查找的四种变种
 *   2.1 查找第一个值等于给定值的元素
 *   2.2 查找最后一个值等于给定值的元素
 *   2.3 查找第一个大于等于给定值的元素
 *   2.4 查找最后一个小于等于给定值的元素
 *
 * 3.如何快速定位IP地址所在地?
 *   3.1 如果IP区间与归属地的对应关系不经常更新。
 *   3.2 预先处理12万条数据,IP地址可以转化为32位的整形数。
 *   3.3 然后转化为在有序数组中，查找最后一个小于等于给定值的元素了。
 *
 * 4.二分查找的优势
 *   4.1 凡是二分查找能解决的，绝大部分我们更加倾向于用散列表或者二叉查找树。
 *   4.2 二分查找更加适合近似查找问题。但是散列表，二叉树就很难实现了。
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-12
 */
public class BinarySearch {


    public static void main(String args[]) {
//      int a[] = {290, 290, 290, 290, 291, 1000, 100000};
//      int result = search(a, a.length, -1);
//        int result = recursionSearch(a, a.length, 290);
        int a1[] = {1, 1, 1, 1, 5, 6, 7, 8, 9, 10};
//        int result = findFirst(a1, a1.length, 2);
//        int result = findLast(a1, a1.length, 1);
        int result = findLastOfSmaller(a1, a1.length, 1);
        System.out.println(result);
    }


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
            return coreRecursionSearch(a, middle + 1, high, value);
        }
    }


    /**
     * 寻找有重复元素的有序数组中第一个出现{value}元素的位置。例如: 1,2,2,4,5,6,7,8,9,10,第一个出现2的位置是1。
     * 0 1 2 3 4 5 6 7 8 9
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int findFirst(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 寻找有重复元素的有序数组中最后一个出现{value}元素的位置。例如: 1,2,2,4,5,6,7,8,9,10,第一个出现2的位置是1。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int findLast(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 寻找有重复元素的有序数组中,第一个大于等于{value}的给定元素。例如: 1,2,2,4,5,6,7,8,9,10,大于1的第一个元素下标1。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int findFirstOfGreater(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 寻找有重复元素的有序数组中,最后一个小于或者等于{value}的给定元素。例如: 1,2,2,4,5,6,7,8,9,10,大于1的第一个元素下标1。
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int findLastOfSmaller(int a[], int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }


}
