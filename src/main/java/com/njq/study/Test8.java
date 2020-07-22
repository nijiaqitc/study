package com.njq.study;

import java.util.Base64;

public class Test8 {
    public static void main(String[] args) {
//        int[] array = new int[]{1,3,5,6};
//        System.out.println(findIndex(array,5));
        System.out.println(new String(Base64.getDecoder().decode("eyJzdWIiOiJzc3NlIiwiZXhwIjoxNTk1MjU4NDQzLCJjcmVhdGVkIjoxNTk1MjE1MjQzMTY3LCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5Ijoic3lzOnVzZXI6YWRkIn0seyJhdXRob3JpdHkiOiJzeXM6dXNlcjpkZWxldGUifSx7ImF1dGhvcml0eSI6InN5czp1c2VyOmVkaXQifSx7ImF1dGhvcml0eSI6InN5czp1c2VyOnZpZXcifV19")));


    }

    public static int findIndex(int[] array,int val){
        for(int i=0;i<array.length;i++){
            if(val <= array[i]){
                return i;
            }
        }
        return array.length;
    }
}
