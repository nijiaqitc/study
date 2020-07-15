package com.njq.study;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Test7 {
    public static Map<String, Integer> m = new HashMap<>();

    public static void main(String[] args) {
//        ArrayList<String> list1 = new ArrayList();
//        list1.add("1"); //编译通过
//        list1.add(1); //编译错误
//        String str1 = list1.get(0); //返回类型就是String
//
//        ArrayList list2 = new ArrayList<String>();
//        list2.add("1"); //编译通过
//        list2.add(1); //编译通过
//        Object object = list2.get(0); //返回类型就是Object
//
//        new ArrayList<String>().add("11"); //编译通过
//        new ArrayList<String>().add(22); //编译错误
//
//        String str2 =         new ArrayList<String>().get(0); //返回类型就是String
//BigDecimal aa  = new BigDecimal(0);
//        System.out.println(aa.add(new BigDecimal(1)).add(new BigDecimal(2)));
        Test7.fillMap();

        Point p = MouseInfo.getPointerInfo().getLocation();
        System.out.println(p.getX() + "---" + p.getY());
        change(0, 1300, 615);
        Robot robot = onclickSB("left");
        outText(robot, "abc");

//        double x = 0, y = 0;
//        boolean flag = false;
//        while (true) {
//            Point point = MouseInfo.getPointerInfo().getLocation();
//            if (x != point.getX()) {
//                x = point.getX();
//                flag = true;
//            }
//            if (y != point.getY()) {
//                y = point.getY();
//                flag = true;
//            }
//            if(flag){
//                System.out.println(x + " , " + y);
//            }
//            flag = false;
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//            }
//        }


    }

    public static void change(int type, int x, int y) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int width = (int) p.getX() + x;
        int heigh = (int) p.getY() + y;
        if (type == 0) {
            width = x;
            heigh = y;
        }
        Robot robot;
        try {
            robot = new Robot();
            robot.mouseMove(width, heigh);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // 模拟鼠标左键右键
    public static Robot onclickSB(String lr) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        if (lr.equals("right")) {
            robot.mousePress(InputEvent.BUTTON3_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_MASK);
        } else {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        return robot;
    }

    private static void outText(Robot robot, String text) {
        String[] tt = text.split("");
        for (int i = 0; i < tt.length; i++) {
            robot.keyPress(m.get(tt[i]));
        }

    }

    private static void fillMap() {
        m.put("a", KeyEvent.VK_A);
        m.put("b", KeyEvent.VK_B);
        m.put("c", KeyEvent.VK_C);
        m.put("d", KeyEvent.VK_D);
        m.put("e", KeyEvent.VK_E);
        m.put("f", KeyEvent.VK_F);
        m.put("g", KeyEvent.VK_G);
        m.put("h", KeyEvent.VK_H);
        m.put("i", KeyEvent.VK_I);
        m.put("j", KeyEvent.VK_J);
        m.put("k", KeyEvent.VK_K);
        m.put("l", KeyEvent.VK_L);
        m.put("m", KeyEvent.VK_M);
        m.put("n", KeyEvent.VK_N);
        m.put("o", KeyEvent.VK_O);
        m.put("p", KeyEvent.VK_P);
        m.put("q", KeyEvent.VK_Q);
        m.put("r", KeyEvent.VK_R);
        m.put("s", KeyEvent.VK_S);
        m.put("t", KeyEvent.VK_T);
        m.put("u", KeyEvent.VK_U);
        m.put("v", KeyEvent.VK_V);
        m.put("w", KeyEvent.VK_W);
        m.put("x", KeyEvent.VK_X);
        m.put("y", KeyEvent.VK_Y);
        m.put("z", KeyEvent.VK_Z);
    }
}
