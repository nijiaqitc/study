package com.njq.study;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: nijiaqi
 * @date: 2019/5/24
 */
public class Test2 {

    static class Frob {
    }

    ;

    static class Fnorkle {
    }

    static class Quark<Q> {
    }

    static class Particle<POSITION,MOMENTUM>{

    }
    //    class Particle<Position.mo>
    public class LostInfomation {


    }
    public static void main(String[] args) {
        List<Frob> list =new ArrayList<>();
        Map<Frob,Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long,Double>  p = new Particle<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
}
