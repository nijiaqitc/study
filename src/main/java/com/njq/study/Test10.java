package com.njq.study;

import javafx.print.Collation;
import jdk.nashorn.internal.runtime.GlobalFunctions;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.stream.Collectors;

public class Test10 {
    public static void main(String[] args) {
//        List<User> list = new ArrayList<>();
//        for(int i=0;i<10;i++){
//            User u = new User();
//            u.setName("AA"+i);
//            u.setAge(i+"");
//            list.add(u);
//        }
//        Collections.shuffle(list);
//        list.forEach(n->{
//            System.out.println(n.getName());
//        });
//        System.out.println("------------");
//        list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList()).forEach(n->{
//            System.out.println(n.getName());
//        });


//        Map<String,String> m = new HashMap<>();
//        m.put("111","222");
//        System.out.println(m.get(111L));
//        System.out.println(m.get("111"));
//        Long aaa = 111L;
//        System.out.println(aaa.equals("111"));
//        System.out.println(aaa.hashCode());
//        System.out.println("111".hashCode());
//        GlobalFunctions.encodeURIComponent()
//        List<String> a1 = new ArrayList<>();
//        a1.add("1");
//        a1.add("2");
//        a1.add("3");
//        a1.add("4");
//        List<String> a2 = new ArrayList<>();
//        a2.add("1");
//        a2.add("2");
//        a2.add("3");
//        System.out.println(a1.subList(a2.size()-1,a1.size()));
        Integer aa = null;
        System.out.println(aa==null||aa !=1 );
    }

    public static class User{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
