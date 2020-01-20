package com.njq.study.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: nijiaqi
 * @date: 2019/12/21
 */
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'exit' to quit.");
        do {
            // 从控制台读取一行数据，返回值字符串
            str = br.readLine();
            System.out.println(str);

        } while (!str.equals("exit"));
    }
}
