package com.test;

/**
 * Created by ListenYoung on 2017/3/23.
 */
public class StringTest {

    public static String removeSpace(String str){
        str = str.replaceAll(" +","");
        return str;
    }

    public static String[] spilt(String str){
        return str.split(",");
    }

    public static void main(String[] args){
        String[] strings = spilt("123,123,123,");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0 ; i < strings.length ; i ++){
            stringBuffer.append(strings[i]).append(",");
        }
        System.out.print(stringBuffer.toString().substring(0, stringBuffer.length() - 1));

        System.out.println("---------------------------------");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("12345");
        stringBuilder.delete(4,5);
        System.out.println(stringBuilder.toString());
    }
}
