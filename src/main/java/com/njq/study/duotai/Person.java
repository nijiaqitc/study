package com.njq.study.duotai;

import javax.xml.bind.SchemaOutputResolver;

public class Person {
    public  Parent p ;

    public Person() {
        p=new Children();
        System.out.println("------:"+ p.name1);
    }


    public void getName(){
        p.getName();
        System.out.println(p.name2);
        System.out.println(p.getC());
    }


    public static void main(String[] args) {
        Person pp = new Person();
        pp.getName();
//        System.out.println(pp.name1);

    }
}
