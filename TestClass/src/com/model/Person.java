package com.model;

/**
 * Created by ListenYoung on 15/8/11.
 */
public class Person {
    public String name;
    public String id;
    public int age;
    public String tel;

    private String password;
    private String address;

    public Person(String password, String address) {
        this.password = password;
        this.address = address;
    }

    public Person() {
    }

    public String getPassword() {
        return password;
    }

    public String getaddress() {
        return address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
