package com.jvm;

/**
 * Created by ListenYoung on 2017/10/25.
 */
public class JVMStackOverFlow {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    /**
     * VM Args : -Xss160k
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable{
        JVMStackOverFlow jvmStackOverFlow = new JVMStackOverFlow();
        try {
            jvmStackOverFlow.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length : " + jvmStackOverFlow.stackLength);
            throw e;
        }
    }
}
