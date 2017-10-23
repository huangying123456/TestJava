package com.service;

import com.model.Person;

/**
 * Created by ListenYoung on 15/8/11.
 */
public class MakeAMan {
    public void makeAMan(){
        Person person  = new Person("123456" , "China,Hangzhou,Yuhang,Wenyixilu");
        person.name = "Zhucheng";
        person.age = 24;
        person.id = "000821";
        person.tel = "1862343232212";
        System.out.println(person.toString());

    }
}
