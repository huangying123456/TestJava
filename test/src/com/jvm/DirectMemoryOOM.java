package com.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by ListenYoung on 2017/10/25.
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM Args : -Xmx20M -XX:MaxDirectMemorySize=10M
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
