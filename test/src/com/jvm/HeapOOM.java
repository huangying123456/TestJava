package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ListenYoung on 2017/10/25.
 */
public class HeapOOM {
    static class OOMObject{}

    /**
     * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args){
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
