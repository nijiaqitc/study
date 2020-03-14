package com.njq.study;

public class Test4 {



    public int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int[] arrays = new int[chars.length];
        for(int i=0 ;i<chars.length;i++){
            switch (chars[i]){
                case 'I':
                    break;
                case 'D':
                    break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        String cd = "0050001703";
        String cd = "0050001703";
        String code ="";
        for (int i = 0; i < cd.length(); i++) {
            System.out.println(cd.charAt(i));
            if(48 != (int)cd.charAt(i)){
                code = cd.substring(i,cd.length());
                break;
            }

        }
        System.out.println(code);
    }
}
