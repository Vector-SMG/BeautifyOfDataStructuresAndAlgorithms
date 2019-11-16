package com.curcopia.linkedlist;

import com.cornucopia.datastructures.linkedlist.LRULinkedList;
import org.junit.Test;

/**
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-01
 */
public class LRULinkedListTest {

    @Test
    public void test(){

        LRULinkedList<String> lruLinkedList=new LRULinkedList();
        lruLinkedList.add("1");
        lruLinkedList.add("2");
        lruLinkedList.add("3");
        lruLinkedList.add("4");
        lruLinkedList.add("5");
        lruLinkedList.add("6");
        lruLinkedList.printAll();
    }


}
