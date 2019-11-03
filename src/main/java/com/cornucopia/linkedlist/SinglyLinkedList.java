package com.cornucopia.linkedlist;

import com.cornucopia.linkedlist.bean.Node;

/**
 * 单链表
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-02
 */
public class SinglyLinkedList<T> {

    //默认的容量
    private static final int DEFAULT_CAPACITY = 10;
    //长度
    private int length;
    //容量
    private int capacity;
    //头节点
    private Node<T> head;
    private Node<T> tail;


    public SinglyLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
    }

    public SinglyLinkedList(int capacity) {
        this.capacity = capacity;
    }


    /**
     * 增加元素
     *
     * @param data
     */
    public void add(T data) {
        add(length, data);
    }

    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
        } else if (index >= length) {
            addLast(data);
        } else {
            Node<T> tmp = findPreNodeByIndex(index);
            if (tmp == null) {
                throw new IllegalArgumentException("index必须大于0小于等于" + length);
            }
            Node<T> newNode = new Node<T>(data, tmp.getNext());
            tmp.setNext(newNode);
            length++;
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


}
