package com.arraylist;

import com.exception.BoxIndexOutOfBoundsException;

public class ArrayBox<E> {

    //初始容量大小为10
    private static final int DEFAULT_CAPACITY = 10;
    //定义一个数组
    private Object[] elementData;
    //有效数组长度
    private int size = 0;

    public ArrayBox(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public ArrayBox(int capacity){
        elementData = new Object[capacity];
    }

    //小A：确保数组的容量
    //参数(条件):我们所需要存储的最小容量
    private void ensureCapacityInternal(int minCapacity){
        if (minCapacity - elementData.length > 0) {
            //说明我们所需的最小容量比数组容量还要大，需要扩容
            //扩容：小B
            this.grow(minCapacity);
        }
    }

    //小B：扩容
    private void grow(int minCapacity){
        //获取原数组的长度
        int oldCapacity = elementData.length;
        //算出扩容之后新数组的长度，即：扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //如果扩容之后的长度还不够，那么直接将所需的minCapacity作为扩容的长度
        if(newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }
        //执行到这，最终获取到一个合理的长度：newCapacity
        //按照这个长度来创建一个新数组，并将原数组中的数据也放入新数组中
        //小C：创建一个新数组，并将原数组中的数据也放入新数组中
        elementData = this.copyOf(elementData,newCapacity);
    }

    //小C：创建新数组
    private Object[] copyOf(Object[] oldArray,int newCapacity){
        //创建新数组
        Object[] newArray = new Object[newCapacity];
        //将旧数组中的数据放入新数组
        for(int i=0; i<oldArray.length; i++){
            newArray[i] = oldArray[i];
        }
        //返回新数组
        return newArray;
    }

    //小D：判断数组索引index是否合法
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new BoxIndexOutOfBoundsException("Index:"+index+",Size:"+size);
        }
    }


    /**
     * 新增元素
     * @param element
     * @return
     */
    public boolean add(E element){
        //1.确保我们属性数组的内部容量
        this.ensureCapacityInternal(size + 1);
        //如果上面的这一行代码可以执行完毕  elementData中肯定有空间
        //我想把element存入elementData里  有效元素个数多记录一个
        //2.将元素存入属性数组中
        elementData[size++] = element;
        //3.告知用户，存储成功
        return true;
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    public E get(int index){
        //1.确保index下标合法
        this.rangeCheck(index);
        //2.返回要取得值
        return (E) elementData[index];
    }

    /**
     * 删除一个元素
     * @param index
     * @return
     */
    public E remove(int index){
        //1.确保index下标合法
        this.rangeCheck(index);
        //如果这行代码可以执行过去  没有异常  index合法
        //将index位置的旧值保存起来
        E oldValue = (E) elementData[index];
        //10 20 30 40 50 60 0 0 0 0--->有效元素
        //30数字删掉     box.remove(2);
        //10 20 40 50 60 0 0 0 0 0--->size  5个
        for(int i=index; i<size-1; i++){
            //从index开始 至size-1为止 将后面位置元素依次前移覆盖
            elementData[i] = elementData[i+1];
        }
        //末尾元素清空
        elementData[size--] = null;
        //将旧值返回给用户
        return oldValue;
    }

    /**
     * 获取ArrayBox集合中的有效元素个数
     * @return
     */
    public int size(){
        return this.size;
    }




}
