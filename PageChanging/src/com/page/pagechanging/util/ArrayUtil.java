package com.page.pagechanging.util;

/**
 * 数组工具类
 * Created by ListenYoung on 15/9/1.
 */
public class ArrayUtil {

    /**
     * 将数组的所有元素向前位移一位，最后一位置为-1
     * @param array 需要位移的数组
     * @return 位移后的数
     *
     */
    public static int[] goForntABit(int[] array){
        int length = array.length - 1;
        for(int i = 0 ;  i < length ; i ++){
            array[i] = array[i + 1];
        }
        array[length + 1] = -1;
        return array;
    }
}
