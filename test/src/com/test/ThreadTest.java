package com.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ListenYoung on 2017/10/21.
 */

 class Ticket implements Runnable {

    private volatile int count = 10;

    @Override
    public void run() {
        while (count > 0) {
            synchronized (this){
               if (count > 0){
                    System.out.println("ticket left : " + --count);
               }
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args){
        Ticket ticket = new Ticket();
//        ticket.run();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
