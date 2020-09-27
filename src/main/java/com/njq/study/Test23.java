package com.njq.study;

public class Test23 {


    public boolean stoneGame(int[] piles) {

        int left = 0;
        int right = piles.length - 1;
        int first = 0;
        int second = 0;
        int index = 1;
        while (left <= right) {
            if (index % 2 == 1) {
                first += piles[left] > piles[right] ? piles[left++] : piles[right--];
            } else {
                second += piles[left] > piles[right] ? piles[left++] : piles[right--];
            }
        }
        return first > second;

    }
}
