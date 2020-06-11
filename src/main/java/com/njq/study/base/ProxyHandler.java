package com.njq.study.base;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: nijiaqi
 * @date: 2019/6/28
 */
public class ProxyHandler implements InvocationHandler {
    private TestInterface face;

    public ProxyHandler(TestInterface face) {
        this.face = face;
    }

    public TestInterface getProxy(){
        //此种方式，这个代理类是放在最外层，跟src层是同层
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //todo 注意：动态代理类的名称默认是$Proxy0  $Proxy1 $Proxy2 ... 此处重命名为AtmProxy
        saveClassFile(face.getClass(),"AtmProxy");
        return (TestInterface)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), face.getClass().getInterfaces(), this);
    }
    public void saveClassFile(Class clazz,String proxyName) {
        //生成class的字节数组，此处生成的class与proxy.newProxyInstance中生成的class除了代理类的名字不同，其它内容完全一致
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = clazz.getResource(".").getPath();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path + proxyName + ".class");
            fos.write(classFile);//保存到磁盘
            fos.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object invoke = method.invoke(face, args);
        System.out.println("after");
        return invoke;
    }


    public static void main(String[] args) {
        TestImpl impl = new TestImpl();
        ProxyHandler pr = new ProxyHandler(impl);
        TestInterface fa = pr.getProxy();
        fa.test1();
        fa.test2("2222");
    }
}
