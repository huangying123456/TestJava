package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ListenYoung on 2017/10/25.
 */
public class RuntimeConstantPoolOOM {
    /**
     * VM Args : -XX:PermSize=10M -XX:MaxPermSize=10M
     * @param args
     */
    public static void main(String[] args){
        //-----有趣的测试-------//
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);//true 因为常量池里没有，str1会存入并返回其引用
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);//false 因为常量池有了java字符，intern返回的是常量池的而不是这个str2
        //-----有趣的测试-------//


        //使用list保持常量池引用，避免fullGC回收常量池行为
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
