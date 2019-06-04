package com.njq.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: nijiaqi
 * @date: 2019/5/20
 */
public class Test {
    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        Set<Character> cset = new HashSet<>();
        for(String st :A){
            char[] aa = st.toCharArray();
            for (char v : aa) {
                cset.add(v);
            }
        }
        Map<Character,Integer> map = new HashMap<>();
        int maxValue = -1;
        int cValue = 0;
        for (Character c : cset) {
            for (String str : A) {
                cValue = completeNum(str,c);
                if(cValue == 0){
                    maxValue = -1;
                    break;
                }
                if(maxValue == -1||maxValue >= cValue){
                    maxValue = cValue ;
                }
            }
            if(maxValue != -1){
                map.put(c,maxValue);
            }
            maxValue = -1;
        }
        List<String> list =new ArrayList<>();
        for (Map.Entry<Character,Integer> v :map.entrySet()){
            for(int i = 0 ;i<v.getValue();i++){
                list.add(String.valueOf(v.getKey()));
            }
        }
//        return list;
        String aaa = "aaaa";

    }


    private static int completeNum(String str,char c){
        char[] chars = str.toCharArray();
        int num = 0;
        for (char c1 :chars){
            if(c1 == c){
                num++;
            }
        }
        return num;
    }

}
