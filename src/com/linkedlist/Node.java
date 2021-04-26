package com.linkedlist;

/**
 * 采用双向链表
 */
public class Node {

    public Node prev;  //上一个node节点对象
    public int item;   //当前节点中的值
    public Node next;  //下一个node节点对象

    public Node(Node prev, int item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
