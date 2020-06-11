package com.njq.study.duotai;

public class Children extends Parent {
    public String name = "i am children";
    public String name1 = "children";
    public String name2 = getC();

    @Override
    public void getName() {
        System.out.println(name);
    }

    @Override
    public String getC() {
        return "ccc";
    }
}
