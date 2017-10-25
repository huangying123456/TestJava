package com.jvm;

/**
 * Created by ListenYoung on 2017/10/25.
 */
public class StackOOM {
    private void loop(){
        while (true){
        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    loop();
                }
            });
            thread.start();
        }
    }

    /**
     * VM Args : -Xss2M
     * don't try to run, may be down.
     * @param args
     */
    public static void main(String[] args){
        StackOOM stackOOM = new StackOOM();
        stackOOM.stackLeakByThread();
    }
}
