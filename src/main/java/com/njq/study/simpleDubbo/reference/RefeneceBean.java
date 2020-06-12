package com.njq.study.simpleDubbo.reference;

import com.njq.study.simpleDubbo.NinaInovker;
import com.njq.study.simpleDubbo.Request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Created by kai.yang on 2018/11/1.
 */
public class RefeneceBean<T> {

    private Class<T> interfaceType;

    private T proxy;


    public RefeneceBean(Class<T> interfaceType) {
        this.interfaceType=interfaceType;
    }

    public T get(){

        return (T)createProxy();
    }

    /**
     * 创建代理
     * @return
     */
    private T createProxy()  {
        try {
            if(proxy==null){
                //创建目录invokers
                NinaDirectory ninaDirectory = new NinaDirectory(interfaceType);

                //包装代理
                proxy=(T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{interfaceType},new referenceInvocationHandler(interfaceType,ninaDirectory));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用服务初始化失败");
        }

        return proxy;
    }



    private static class referenceInvocationHandler implements InvocationHandler{

        private Class interfaceType;

        private NinaInovker ninaInovker;



        public referenceInvocationHandler(Class interfaceType,NinaInovker ninaInovker) {
            this.interfaceType=interfaceType;
            this.ninaInovker=ninaInovker;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("toString")){
                return proxy.toString();
            }
            if(method.getName().equals("equals")){
                return false;
            }


            Request request=new Request();
            request.setClassType(interfaceType.getName());
            request.setMethod(method.getName());
            request.setParams(args);
            return ninaInovker.invoke(request).get();
        }
    }



}
