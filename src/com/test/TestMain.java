package com.test;

import com.arraylist.ArrayBox;
import com.linkedlist.LinkedBox;

public class TestMain {

    public static void main(String[] args) {

        //测试ArrayBox
//        ArrayBox<Integer> arr1 = new ArrayBox<>();
//        arr1.add(1);
//        arr1.add(2);
//        arr1.add(3);
//        arr1.remove(1);
//       for(int i=0; i<arr1.size(); i++){
//           System.out.println(arr1.get(i));
//       }

        //测试LinkedBox
        LinkedBox arr2 = new LinkedBox();
        arr2.add(1);
        arr2.add(2);
        arr2.add(3);
        for(int i=0; i<arr2.size(); i++){
            System.out.println(arr2.get(i));
        }

    }
}
