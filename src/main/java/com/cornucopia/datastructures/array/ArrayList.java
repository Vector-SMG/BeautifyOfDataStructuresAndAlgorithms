package com.cornucopia.datastructures.array;

import java.util.Arrays;

/**
 * 1.支持动态扩容的线性表
 *
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-10-21
 */
public class ArrayList<E> {

    //transient修饰的成员属性不被序列化
    transient Object[] elementData;

    //空元素数据
    private static final Object[] EMPTY_ELEMENTDATA = {};

    //数据大小
    private int size;

    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    //最大数组size
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    //ArrayList构造方法
    public ArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity:" + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
    }

    public E get(int index){
       if(index>=size)
           throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
       return (E) elementData[index];

    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+",size: "+size;
    }

    public boolean add(E e){
        ensureCapacityInternal(size+1);
        elementData[size++]=e;
        return true;
    }


    private void ensureCapacityInternal(int minCapacity) {
        if(elementData==EMPTY_ELEMENTDATA){
            minCapacity=Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if(minCapacity-elementData.length>0){
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity=elementData.length;
        int newCapacity=oldCapacity+(oldCapacity>>1);
        if(newCapacity-minCapacity<0){
            newCapacity=minCapacity;
        }

        if(newCapacity-MAX_ARRAY_SIZE>0){
            newCapacity=hugeCapacity(minCapacity);
        }

        //创建一个1.5倍的数组大小，将elementData复制到这个数组中
        elementData= Arrays.copyOf(elementData,newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if(minCapacity<0)
            throw new OutOfMemoryError();
        return (minCapacity>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:
                MAX_ARRAY_SIZE;
    }


    public Object[] getElementData() {
        return elementData;
    }
}
