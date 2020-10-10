package com.njq.study;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTest {

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        List<Future<Integer>> futureList = new ArrayList<>();
//
//        // 计算1000次1至1亿的和
//        for (int i = 0; i < 1000; i++) {
//            // 调度执行
//            futureList.add(executorService.submit(new Calc()));
//        }
//        System.out.println("耗时: " + (System.currentTimeMillis() - start));
//
//        for (int i = 0; i < 1000; i++) {
//            try {
//                Integer result = futureList.get(i).get();
//                System.out.println("第" + i + "个结果: " + result);
//            } catch (InterruptedException | ExecutionException e) {
//            }
//        }
//        System.out.println("耗时: " + (System.currentTimeMillis() - start));

        try {
            Calc cal = new Calc();
            System.out.println(cal.call());
            FutureTask<Integer> ft = new FutureTask<>(cal);
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    ft.run();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
            }).start();
            System.out.println(ft.get());
        } catch (Exception e) {
            System.out.println("-------:" + e.getMessage());
        }


    }

    public static class Calc implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return cal(10);
        }

        public static int cal(int num) {
            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += i;
            }
            return sum;
        }
    }
}