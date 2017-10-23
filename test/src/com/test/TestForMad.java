package com.test;

import java.math.BigInteger;

/**
 * Created by ListenYoung on 16/8/18.
 */
public class TestForMad {

    public long calculate(int x){
        long temp = 1;
        long sum = 0;
        for (int i = 1 ;i <= x ; i++){
            for(int j = 1;j <= i ;j++){
                temp *= j ;
            }
            sum += temp ;
            temp = 1 ;
        }
        return sum ;
    }

        public String newCalculate(int x){
            BigInteger temp = new BigInteger("1");
            BigInteger sum = new BigInteger("0");
            for (int i = 1 ;i <= x ; i++){
                for(int j = 1;j <= i ;j++){

                    temp = temp.multiply(new BigInteger(new String(new Integer(j).toString())));
                }
                sum = sum.add(temp) ;
                temp = new BigInteger("1") ;
            }
            return sum.toString() ;
        }

    public static void main(String[] args){
        System.out.print(new TestForMad().newCalculate(-1));
    }
}
