package com.njq.study;

public class Test18 {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            public int compare(Integer m, Integer n) {
//                System.out.println("----" + m + "----" + n);
//                return m - n;
//            }
//        });
//        queue.add(1);
//        queue.add(3);
//        queue.add(2);
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());

        int[] num = {56, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
//        sort(num,0 ,num.length-1);
        Test18 t = new Test18();
        t.sort(num, 0, num.length - 1);
        System.out.println(arrayToString(num));
    }

    private static String arrayToString(int[] arr) {
        String str = "";
        for (int a : arr) {
            str += a + "\t";
        }
        return str;
    }

    private void sort(int[] arrays, int left, int right) {
        System.out.println(Test18.arrayToString(arrays));
        if (left >= right) {
            return;
        }
        int temp = arrays[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arrays[j] >= temp) {
                j--;
            }
            while (i < j && arrays[i] <= temp) {
                i++;
            }


//            System.out.println(i + "--------" + j);

            int t = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = t;
        }

        arrays[left] = arrays[i];
        arrays[i] = temp;
        this.sort(arrays, left, i - 1);

        this.sort(arrays, i + 1, right);
    }

}
