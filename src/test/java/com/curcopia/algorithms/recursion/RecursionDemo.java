package com.curcopia.algorithms.recursion;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * 迭代例子
 *
 * 1.递归的三个条件
 *   1.1 一个问题的解可以分解为多个子问题的解。
 *   1.2 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样。
 *   1.3 存在递归的终止条件
 *
 * 2.总结
 *   写递归代码的关键就是找到如何将大问题分解为小问题的规律，并且基于此写出递推公式，然后再推敲终止条件，最后将递推公式和终止条件翻译成代码。
 *
 * 3.避免思维误区
 *   编写递归代码的关键是，只要遇到递归，我们就把它抽象成一个递推公式，不用想一层层的调用关系，不要试图用人脑去分解递归的每个步骤。
 *
 * 4.注意事项
 *   4.1 递归代码要警惕堆栈溢出
 *   4.2 递归代码要警惕重复计算
 *   4.3
 *
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-04
 */
public class RecursionDemo {

    private static HashMap<Integer,Integer> map=new HashMap();


    public static void main(String[] args) {
        System.out.println(demo(3));
    }

    /**
     * 递归问题的引出
     *
     * 假设有n个台阶，每次可以跨1个台阶或2个台阶，请问有多少种走法
     * 如果有7个台阶，你可以2 2 2 1或者1 2 1 1 2
     * =>
     * f(1)=1
     * f(2)=2
     * f(n)=f(n-1)+f(n-2)
     */
    public static int demo(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return demo(n-1)+demo(n-2);
    }


    /**
     * 递归问题避免重复计算问题
     */
    public static int demo1(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        if(map.containsKey(n)){
            return map.get(n);
        }
        int ret=demo1(n-1)+demo1(n-2);
        map.put(n,ret);
        return ret;
    }

    /**
     * 将递归问题修改为非递归的实现方式
     */
    public static int demo2(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int ret=0;
        int pre=2;
        int prepre=1;
        for(int i=3;i<=n;i++){
            ret=pre+prepre;
            prepre=pre;
            pre=ret;
        }
        return ret;
    }




}
