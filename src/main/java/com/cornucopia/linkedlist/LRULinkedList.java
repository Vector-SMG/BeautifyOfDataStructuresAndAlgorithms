package com.cornucopia.linkedlist;

/**
 * 基于单链表LRU算法
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 *    2.1 如果此数据没有在缓存链表中，又可以分为两种情况：如果此时缓存未满，则将此结点直接插入到链表的头部；
 *    2.2 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *
 * @author cornucopia
 * @version 1.0
 * @since 2019-11-01
 */
public class LRULinkedList<T> {

    /**
     * 默认容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;
    /**
     * 头结点
     */
    private Node<T> first;
    /**
     * 链表长度
     */
    private int length;
    /**
     * 链表容量
     */
    private int capacity;


    public LRULinkedList() {
        this.first = new Node<T>();
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRULinkedList(Integer capacity) {
        this.first = new Node<T>();
        this.capacity = capacity;
    }

    /**
     * 添加节点
     */
    public void add(T data) {
        //查找`data`的头节点
        Node preNode = findPreNode(data);
        //链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElement(preNode);
            insertElementToBegin(data);
        }else{
            if(length>=this.capacity){
                deleteElementOfEnd();
            }
            insertElementToBegin(data);
        }
    }




    /**
     * 寻找data对应的前驱
     *
     * @param data 数据
     * @return
     */
    private Node findPreNode(T data) {
        Node node = first;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除节点
     * @param preNode
     */
    private void deleteElement(Node preNode) {
        Node temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 将该节点插入起始位置
     * 头节点一般没有数据
     *
     * @param data
     */
    private void insertElementToBegin(T data) {
        Node next=first.getNext();
        first.setNext(new Node(data,next));
    }


    /**
     * 删除尾节点
     */
    private void deleteElementOfEnd(){
        Node firstTemp=first;
        if(firstTemp.getNext()==null){
            return;
        }
        while(firstTemp.getNext().getNext()!=null){
            firstTemp=firstTemp.getNext();
        }

        Node tmp=firstTemp.getNext();
        firstTemp.setNext(null);
        tmp=null;
        length--;
    }

    public  void printAll(){
        Node node=first.getNext();
        while (node!=null){
            System.out.println(node.getElement());
            node=node.getNext();
        }
    }


}
