package com.njq.study;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Test11 {

    public static void main(String[] args) {
//        String url = "http://localhost:5000/yh-anniversary/index.html?platform=wechatminiprogram&shareMember=380718139376871717&shareShopId=9D13&activitycode=tiantianlingxianjinaa1&subActivityId=null&needlocation=1&canShare=1&shopid=9D13&isShare=1";
//        System.out.println(url.substring(url.indexOf('?') + 1));
//        Map<String, String> urlMap = urlToMap(url.substring(url.indexOf('?')));
//        System.out.println(urlMap.get("shareMember"));
//        System.out.println(urlMap.get("shareShopId"));
//        System.out.println(urlMap.get("activitycode"));
//        System.out.println(urlMap.get("subActivityId"));
//        System.out.println(urlMap.get("shopid"));
//        int[] aa = new int[]{1,2,3,4,5};
//        reverse(aa);
//        for(int i = 0;i<aa.length;i++){
//            System.out.println(aa[i]);
//        }

//        Integer aaaa = 999;
//        int bbbb = 999;
//        System.out.println(aaaa == bbbb);
//        int[] aa = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] bbb = twoSum(aa, 9);
//        System.out.println(bbb);

//        int[] b1 = new int[]{1, 2, 3, 1};
//        System.out.println(completeMax(b1));

//        System.out.println(hammingWeight(13));
//        System.out.println(Math.ceil(2 / 1.4));
//        System.out.println(binarySearch(new int[]{1, 2}, 2));
        Test11 t = new Test11();
//        System.out.println(t.firstBadVersiona(2));
        System.out.println(t.minSteps(30));

    }


    public static Map<String, String> urlToMap(String notifyStr) {
        Map<String, String> map = new HashMap<>();
        try {
            String[] params = notifyStr.split("&");
            for (String kv : params) {
                if (kv.indexOf("=") != -1) {
                    String[] temp = kv.split("=");
                    map.put(temp[0], URLDecoder.decode(temp[1], "UTF-8"));
                }
            }
        } catch (Exception e) {
            return null;
        }
        return map;
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; ++i) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }


    public static void reverse(int[] arrays) {
        for (int i = 0; i < arrays.length / 2; i++) {
            int temp = arrays[arrays.length - i - 1];
            arrays[arrays.length - i - 1] = arrays[i];
            arrays[i] = temp;
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int maxSubArraya(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }


    public int maxSubArrayb(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public static int completeMax(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
                max = Math.max(max, dp[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println("------------");
        return max;
    }


    public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 4; i++) {
            if ((n & mask) != 0) {
                result++;
            }
            mask = mask << 1;
        }
        return result;
    }

    public static int binarySearch(int[] array, int des) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < des) {
                left = mid + 1;
            } else if (array[mid] == des) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public boolean isBadVersion(int n) {
        if (n == 2) {
            return true;
        }
        return false;
    }

    public int firstBadVersiona(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int firstBadVersionb(int n) {
        int left = 1;
        int right = n;
        int res = n;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (isBadVersion(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    /**
     * 650
     * 主要是 素数分解
     * 总数/2 就是要粘贴2次
     * 剩余数/3 就是粘贴3次
     * 总数/总数 就是总共粘贴总数次
     * 总共有A的数量= 2*3*总数 个A
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }


}
