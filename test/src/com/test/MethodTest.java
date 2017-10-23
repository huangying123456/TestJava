package com.test;

import java.lang.reflect.Method;

/**
 * Created by ListenYoung on 2017/4/14.
 */

class MayClass{
    private Long id;
    private long mayId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMayId() {
        return mayId;
    }

    public void setMayId(long mayId) {
        this.mayId = mayId;
    }
}

public class MethodTest {
    public static void main(String[] args) throws Exception {
        Class<MayClass> mClass = MayClass.class;
        MayClass mayClass = new MayClass();
        mayClass.setMayId(123);
        Method method = mClass.getMethod("setMayId", long.class);
        method.invoke(mayClass, 345L);
        System.out.print(mayClass.getMayId());
    }
}
