package com.njq.study.duotai;

public class Parent {
    public String name = "i am parent";
    public String name1 ="parent";
    public String name2 = getC();

    public void getName(){
        System.out.println(name);
    }

    public String getC(){
        return "ppp";
    }
}
