package com.njq.study.base;

import com.njq.study.ConvertMain;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ClassPrintTest {

//    public static void main(String[] args) throws ClassNotFoundException {
////        String name;
////        if (args.length > 0) {
////            name = args[0];
////        } else {
////            Scanner in = new Scanner(System.in);
////            System.out.println("enter class name(e.g java.util.Date)");
////            name = in.next();
////        }
//
//
//
//
//        try {
//            byte[] bytes;
//            ByteArrayOutputStream bo = new ByteArrayOutputStream();
//            ObjectOutputStream oo = new ObjectOutputStream(bo);
//            oo.writeObject(ConvertMain.class);
//            bytes = bo.toByteArray();
//            String path = ConvertMain.class.getResource(".").getPath();
//            FileOutputStream fos = new FileOutputStream(path + "Aaaabb" + ".class");
//            fos.write(bytes);//保存到磁盘
//            fos.flush();
//            fos.close();
//
////            Class c1 = Class.forName(name);
//
////            Class c1 =ConvertMain.class;
////            Class superClass = c1.getSuperclass();
////            //获取类的修饰符
////            String modifiers = Modifier.toString(c1.getModifiers());
////            if (modifiers.length() > 0) {
////                System.out.print(modifiers + " ");
////            }
////            System.out.print("class " + c1.getName());
////
////            if (superClass != null && superClass != Object.class) {
////                System.out.print(" extends " + superClass.getName());
////            }
////
////            //\n表示换行
////            System.out.print("\n{\n");
////            //打印构造器
////            printConstractors(c1);
////            System.out.println();
////            //打印类的方法
////            printMethods(c1);
////
////            System.out.println();
////            //打印域
////            printFields(c1);
////
////            System.out.println("}");
//
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//    }
//
//
//    private static void printFields(Class c1) {
//        // TODO Auto-generated method stub
//        Field[] fields = c1.getDeclaredFields();
//        for (Field field : fields) {
//            Class type = field.getType();
//            String name = field.getName();
//            System.out.print("  ");
//            String modifiers = Modifier.toString(field.getModifiers());
//            if (modifiers.length() > 0) {
//                System.out.print(modifiers + " ");
//            }
//            System.out.println(type.getName() + " " + name + ";");
//        }
//    }
//
//
//    private static void printMethods(Class c1) {
//        // TODO Auto-generated method stub
//        //获取当前类的所有方法
//        Method[] methods = c1.getDeclaredMethods();
//        for (Method m : methods) {
//            Class returnType = m.getReturnType();
//            String methodName = m.getName();
//            String modifiers = Modifier.toString(m.getModifiers());
//            if (modifiers.length() > 0) {
//                System.out.print("  " + modifiers + " ");
//            }
//            System.out.print(returnType.getName() + " " + methodName + "(");
//
//            //打印方法参数
//            Class[] paramTypes = m.getParameterTypes();
//            for (int i = 0; i < paramTypes.length; i++) {
//                if (i > 0) {
//                    System.out.print(",");
//                }
//                System.out.print(paramTypes[i].getName());
//            }
//            System.out.println(");");
//        }
//    }
//
//
//    private static void printConstractors(Class c1) {
//        // TODO Auto-generated method stub
//        //得到当前类的所有构造器，包括受保护的和私有的，不包含超类的
//        Constructor[] constructors = c1.getDeclaredConstructors();
//        for (Constructor constructor : constructors) {
//            System.out.print("  ");
//            String name = constructor.getName();
//            String modifiers = Modifier.toString(constructor.getModifiers());
//            if (modifiers.length() > 0) {
//                System.out.print(modifiers + " ");
//            }
//            System.out.print(name + "(");
//
//            //打印构造器的参数
//            Class[] paramsTypes = constructor.getParameterTypes();
//            for (int i = 0; i < paramsTypes.length; i++) {
//                if (i > 0) {
//                    System.out.print(",");
//                }
//                System.out.print(paramsTypes[i].getName());
//            }
//            System.out.println(");");
//        }
//    }
}
