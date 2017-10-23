package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ListenYoung on 2017/10/12.
 */
public class TestMap {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");

        System.out.print(map.get("5"));
    }
}
