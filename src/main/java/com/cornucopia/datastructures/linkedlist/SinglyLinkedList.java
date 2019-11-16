package com.cornucopia.datastructures.linkedlist;

import com.cornucopia.datastructures.linkedlist.bean.Node;

/**
 * 单链表
 * | data | next |  ---  | data | next | --- | data | null |
 *
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-02
 */
public class SinglyLinkedList<T> {

    //长度
    private int length;
    //头节点
    private Node<T> head;
    //尾节点
    private Node<T> tail;


    public SinglyLinkedList() {

    }

    /**
     * 增加元素
     *
     * @param data
     */
    public void add(T data) {
        add(length, data);
    }


    /**
     * 在index位置添加一个新元素
     *
     * @param index 元素下标
     * @param data  元素数据
     */
    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
        } else if (index >= length) {
            addLast(data);
        } else {
            Node<T> tmp = findPreNodeByIndex(index);
            if (tmp != null) {
                Node<T> newNode = new Node<T>(data, tmp.getNext());
                tmp.setNext(newNode);
                length++;
            }
        }
    }


    /**
     * 添加起始节点
     *
     * @param data
     */
    public void addFirst(T data) {
        if (head == null) {
            head = new Node<T>();
            head.setElement(data);
            tail = head;
        } else {
            Node<T> newNode = new Node<T>(data);
            newNode.setNext(head);
            head = newNode;
        }
        length++;
    }

    /**
     * 添加最后节点
     *
     * @param data
     */
    public void addLast(T data) {
        Node<T> tmp = head;
        if (tmp == null) {
            head = tail = new Node<T>(data, null);
        } else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Node<T> last = new Node<T>(data);
            tmp.setNext(last);
            tail = last;
        }
        length++;
    }

    /**
     * 根据index计算
     *
     * @param index
     * @return
     */
    public Node findPreNodeByIndex(int index) {
        if (head == null) {
            return null;
        }
        Node<T> tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i == index - 1) {
                return tmp;
            }
            tmp = tmp.getNext();
            i++;
        }
        return null;
    }


    /**
     * 打印元素
     */
    public void print() {
        if (head != null) {
            Node<T> tmp = head;
            while (tmp != null) {
                System.out.println(tmp.getElement());
                tmp = tmp.getNext();
            }
        }
    }


    /**
     * 删除数据对应的元素。todo 后续添加该方法
     *
     * @param data
     */
    public void delete(T data) {
    }


    /**
     * 删除index元素
     *
     * @param index
     */
    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
        } else if (index >= (length - 1)) {
            deleteLast();
        } else {
            Node<T> preNode = findPreNodeByIndex(index);
            if (preNode != null) {
                preNode.setNext(preNode.getNext().getNext());
                length--;
            }
        }
    }


    /**
     * 删除首节点
     */
    public void deleteFirst() {
        if (head != null) {
            head = head.getNext();
            length--;
        }
    }


    /**
     * 删除尾节点
     */
    public void deleteLast() {
        if (tail != null) {
            Node<T> preNodeOfLast = findPreNodeByIndex(length - 1);
            preNodeOfLast.setNext(null);
            tail = preNodeOfLast;
            length--;
        }
    }


}
