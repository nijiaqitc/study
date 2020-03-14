package com.njq.study;

public class BitMap {
    private char[] bytes;
    private int nbits;

    public BitMap(int nbits) {
        this.nbits = nbits;
//      总共创建多少个byte 用来存储这个位状态
        this.bytes = new char[nbits / 8 + 1];
    }

    public void set(int k) {
        if (k > nbits) return;
        //1个bytes占8位，计算这个值K存储在哪个bytes上   k/8等价于k>>3
        int byteIndex = k / 8;
        //计算这个值K，存储在这个bytes上的第几位，1个bytes占8位   k%8等价于 k&7
        int bitIndex = k % 8;

        //设置第几个bytes上的第几位设置为true
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 8;
        int bitIndex = k % 8;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public char[] getBytes11(){
        return  bytes;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(20);
        bitMap.set(12);
        System.out.println(bitMap.get(13));
//        for (char c : bitMap.getBytes11()) {
//            System.out.println(c);
//        }
    }
}


