package com.jvm;

/**
 * Created by ListenYoung on 2017/10/26.
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public void isAlive(){
        System.out.println("yes, I'm still alive.");
    }

    /**
     * 对象不可达后会将有覆盖finalize并从没有执行过的对象放入F-queue中，等待执行finalize方法（但并不保证一定会执行完）
     * 对象可以在被GC时自救，但也只能在finalize方法中最多自救一次（finalize方法最多也只会执行一次）
     * 别用
     * 别用
     * 别用
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        //第一次自救
        SAVE_HOOK = null;
        System.gc();
        //finalize 方法优先级很低，等他一会
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("oh, it has dead");
        }

        //第二次自救，显然没救了
        SAVE_HOOK = null;
        System.gc();
        //finalize 方法优先级很低，等他一会
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("oh, it has dead");
        }
    }
}
