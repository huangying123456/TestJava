package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by ListenYoung on 2017/4/12.
 */

class FieldModel{
    private Long id;
    private Long id1;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class FieldTest {
    public static void main(String[] args){
        Class<FieldModel> fieldModelClass = FieldModel.class;
        try {
            Method method = fieldModelClass.getMethod("getId" + 1);
            FieldModel model = new FieldModel();
            model.setId(12L);
            model.setId1(23L);
            model.setName("wocao");
            System.out.println(method.invoke(model));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
