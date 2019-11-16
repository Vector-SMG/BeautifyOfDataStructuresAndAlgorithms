package com.curcopia.linkedlist;

import com.cornucopia.datastructures.linkedlist.SinglyLinkedList;
import org.junit.Test;

/**
 * 单链表
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-02
 */
public class SinglyLinkedListTest {


    @Test
    public void test() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("1");
        singlyLinkedList.add("2");
        singlyLinkedList.add("3");
        singlyLinkedList.add("4");
        singlyLinkedList.add("5");
        singlyLinkedList.add(5, "0");

        singlyLinkedList.print();

    }

}
