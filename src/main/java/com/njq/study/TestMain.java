package com.njq.study;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/6/20
 */
public class TestMain {

    public static void main(String[] args) {
//        int[] ll = {1, 2, 3, 1, 1};
//        System.out.println(TestMain.test(11, 3));
//        System.out.println(TestMain.pivotIndex(ll));
//        Integer abc = 11;
//        System.out.println(number/1000);
//        double number = 12266;
//        double aa = number/1000;
//        DecimalFormat decimalFormat = new DecimalFormat("#.##");
//        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
//        System.out.println(decimalFormat.format(aa));

//        System.out.println(TestMain.shipWithinDays(ll, 4));

//        String aa = "http://test-activity.yonghuivip.com/newstage/h5/yh-weixin-mall/#/presale/isuper/yushoulalal?sellerid=2&needlocation=1";
//        try {
//            System.out.println(URLEncoder.encode(aa, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        List<String> list = new ArrayList<>();
//        list.add("1");
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        List<String> xx = new ArrayList();
//        xx.add("11");
//        xx.add("22");
//        xx.add("33");
//        System.out.println(MessageFormat.format("aaa{0},bbb,ccc{2}", xx.toArray()));
//

        String aa = "1.1";
        System.out.println(new BigDecimal(aa).intValue());
    }

    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    public static int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        if (D <= 1) {
            return sum;
        }
        int left = 1;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            if (valid(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean valid(int[] weights, int D, int c) {
        int d = 0;
        int now = 0;
        while (now < weights.length) {
            d++;
            if (d > D) {
                return false;
            }
            int sum = 0;
            while (now < weights.length && sum + weights[now] <= c) {
                System.out.print(weights[now]+ " ");
                sum += weights[now];
                now++;
            }
            System.out.println();
        }
        return true;
    }


    public static int pivotIndex(int[] nums) {
        int i = 1, j = nums.length - 2;
        int leftSumValue = nums[i - 1];
        int rightSumValue = nums[j + 1];
        while (i < j) {
            if (leftSumValue <= rightSumValue) {
                leftSumValue += nums[i++];
            } else {
                rightSumValue += nums[j--];
            }
        }
        if (leftSumValue == rightSumValue) {
            return i;
        } else {
            return -1;
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list_total = new ArrayList<>();
        funcR(nums, used, list, list_total);
        return list_total;
    }

    private static void funcR(int[] nums, int[] used, List<Integer> list_in, List<List<Integer>> list_total) {
        if (list_in.size() == nums.length) {
            list_total.add(new ArrayList<>(list_in));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 0) {
                list_in.add(nums[i]);
                used[i] = 1;
                funcR(nums, used, list_in, list_total);
                used[i] = 0;
                list_in.remove(list_in.size() - 1);
            }
        }

    }

}
