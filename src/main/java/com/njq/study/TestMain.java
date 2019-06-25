package com.njq.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/6/20
 */
public class TestMain {

    public static void main(String[] args) {
        int[] ll = {1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
//        [1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3]
//        516
        System.out.println(TestMain.addToArrayForm(ll, 516));

    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        long v = 0;
        for (int i : A) {
            v = v * 10 + i;
        }
        v += K;
        List<Integer> ll = new ArrayList<>();
        if(v==0){
            ll.add(0);
            return ll;
        }
        List<Long> list = new ArrayList<>();
        while (v > 0) {
            System.out.println((int) v % 10);
            list.add(v % 10);
            v /= 10;
        }
        Collections.reverse(list);

        for (long i : list) {
            ll.add((int) i);
        }
        return ll;
    }


}
