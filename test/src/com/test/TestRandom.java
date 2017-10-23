package com.test;

/**
 * Created by ListenYoung on 2017/10/20.
 */
public class TestRandom {

    //base nanotime of hashcode
    public static int xorShift(int y) {
        y ^= (y << 6);
        y ^= (y >>> 21);
        y ^= (y << 7);

        return y;
    }

    public static void main(String[] args){
        System.out.print(TestRandom.xorShift(new Long(System.nanoTime()).intValue()));
    }
}
