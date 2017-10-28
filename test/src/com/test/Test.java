package com.test;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ListenYoung on 15/10/26.
 */
public class Test {

    public static String clearUri(String uri){
        if(!uri.startsWith("/")){
            return uri;
        }
        return uri.replaceAll("^/+", "/");
    }

    public static void main(String[] args) throws Exception {
        List<Long> idList = new ArrayList<>();
        idList.add(4L);
        idList.add(3L);
        idList.add(9L);
        idList.add(6L);

        idList.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if (o1 > o2){
                    return -1;
                }else if (o1 == o2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });

        idList.forEach(id -> {
            System.out.println(id);
        });

        System.out.println("dddddddddddddddd     " + (1 >>> 1));
        
    }
}



