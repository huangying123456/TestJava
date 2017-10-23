package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ListenYoung on 2017/3/22.
 */
public class IteratorTest {
    public static void main(String[] args){
        List<Integer> all = new ArrayList<>();
        for(int i = 0 ; i < 20 ; i ++){
            all.add(i);
        }

        Iterator<Integer> iterator = all.iterator();
        while (iterator.hasNext()){
            int first = iterator.next();
            System.out.println("first list: " + first);
              if(first % 7 == 0){
                  iterator.remove();
              }
        }

        iterator = all.iterator();
        while (iterator.hasNext()){
            int second = iterator.next();
            System.out.println("second list: " + second);
            if(second % 5 == 0){
                iterator.remove();
            }
        }

        iterator = all.iterator();
        while (iterator.hasNext()){
            int third = iterator.next();
            System.out.println("third list: " + third);
            if(third % 3 == 0){
                iterator.remove();
            }
        }

        iterator = all.iterator();
        while (iterator.hasNext()){
            int fourth = iterator.next();
            System.out.println("fourth list: " + fourth);
            if(fourth % 2 == 0){
                iterator.remove();
            }
        }

        iterator = all.iterator();
        while (iterator.hasNext()){
            int last = iterator.next();
            System.out.println("last list: " + last);
        }
    }
}
