package com.page.pagechanging.util;

/**
 * 二进制工具类
 * Created by ListenYoung on 15/8/26.
 */
public class BinaryUtil {
    /**
     * 将二进制数转化为十进制数
     * @param binary 需要转化的二进制数
     * @return 转化完成的十进制数
     */
    public static int parseInt(int binary){
        int result = 0;
        if(binary < 0){
            result = -1;
        }else{
            int time = 1;
            while(binary > 0){
                int temp = binary % 10;
                if(temp > 1){
                    result = -1;
                    break;
                }
                result += temp * time;
                time *= 2;
                binary /= 10;
            }
        }
        return result;
    }

    /**
     * 将一个0，1组成的一维数组转化为十进制数
     * @param arr
     * @return
     */
    public static int parseInt(int[] arr){
        int result = 0;
        if(arr == null || arr.length < 1){
            result = -1;
        }else{
            int time = 1;
            int length = arr.length - 1;
            for(int i = length ; i >= 0 ; i -- ){
                if(arr[i] > 1){
                    result = -1;
                    break;
                }else{
                    result += arr[i] * time;
                    time *= 2;
                }
            }
        }

        return result;
    }

    /**
     * 得到一个十六位的二进制数
     * @return 一个十六位的二进制数(String类型)
     */
    public static String getSixteenBinary(){
        StringBuilder sb = new StringBuilder();
        double check = 0;
        for(int i = 0 ; i < 16 ; i ++){
            check = Math.random();
            if(check > 0.5){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }

        return sb.toString();
    }
}
