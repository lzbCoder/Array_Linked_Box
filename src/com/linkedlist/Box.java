package com.linkedlist;

public interface Box {

    //添加元素
    public boolean add(int element);
    //获取元素
    public int get(int index);
    //删除元素
    public int remove(int index);
    //获取有效元素个数
    public int size();

}
