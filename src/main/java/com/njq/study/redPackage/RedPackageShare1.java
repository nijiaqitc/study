package com.njq.study.redPackage;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: nijiaqi
 * @date: 2019/10/31
 */
public class RedPackageShare1 {
    /**
     * 核心思路是 1、剩余金额/剩余份数 取平均 然后扩大两倍
     * 2、随机生成一个小数  然后乘以 步骤1生成的值 即为金额
     * 3、剩余金额减去步骤2生成的金额，再按步骤1继续执行
     * 存在问题：从极端概率上讲  越到后面获取到的金额会越少
     * @param _leftMoneyPackage
     * @return
     */
    public static double getRandomMoney(LeftMoneyPackage _leftMoneyPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_leftMoneyPackage.remainSize == 1) {
            _leftMoneyPackage.remainSize--;
            return (double) Math.round(_leftMoneyPackage.remainMoney * 100) / 100;
        }
        Random r = new Random();
        double min = 0.01; //
        double max = _leftMoneyPackage.remainMoney / _leftMoneyPackage.remainSize * 2;
        if (max > 6) {
            max = 6;
        }
        double money = r.nextDouble() * max;
        money = money <= min ? 0.01 : money;
        money = Math.floor(money * 100) / 100;
        _leftMoneyPackage.remainSize--;
        _leftMoneyPackage.remainMoney -= money;
        return money;
    }

    public static void main(String[] args) {
        LeftMoneyPackage moneyPackage = new LeftMoneyPackage();
        moneyPackage.remainMoney = 40;
        moneyPackage.remainSize = 10;
        double[] tt = new double[10];
        int i = 0;
        while (moneyPackage.remainSize != 0) {
            tt[i++]=RedPackageShare1.getRandomMoney(moneyPackage);
        }
        double sum = 0;
        for(double t:tt){
            System.out.print(t+" ");
            sum += t;
        }
        System.out.println(sum);
    }
}
