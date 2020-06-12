package com.njq.study.simpleDubbo;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kai.yang on 2018/11/1.
 */
public class Response implements Serializable{

    private static final long serialVersionUID = -4355285085441000005L;

    String id;

    Object result;

    Throwable e;

    long timeout;

    private final Lock lock = new ReentrantLock();

    private final Condition done = lock.newCondition();

    private static ConcurrentHashMap<String,Response> RESULTS=new ConcurrentHashMap<>();

    public Response(long timeout,String id) {
        this.timeout = timeout;
        this.id=id;
        RESULTS.putIfAbsent(id,this);
    }

    public Response(String id) {
        this.id = id;
    }

    /**
     * 接收消息通知
     * @param response
     */
    public static void received(Response response){
        Response responseResult = RESULTS.get(response.getId());
        responseResult.doReceived(response);
    }



    public  void doReceived(Response response){
        try{
            lock.lock();
            if(response!=null){
                this.setResult(response.getResult());
                this.setE(response.getE());
                this.done.signal();
            }
        }finally {
            lock.unlock();
        }

    }


    public Object get()throws Throwable{

        try {
            lock.lock();
            if(result==null&&e==null){
                boolean await = done.await(timeout, TimeUnit.MILLISECONDS);
                if(!await){
                    throw  new RuntimeException("远程调用超时");
                }
            }

            if(result!=null){
                return result;
            }

            if(e!=null){
                throw e;
            }

        }catch (RuntimeException re){
            throw re;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("远程调用异常");
        }finally {
            lock.unlock();
        }

        return null;
    }


    public String getId() {
        return id;
    }

    public Response setId(String id) {
        this.id = id;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public Response setResult(Object result) {
        this.result = result;
        return this;
    }

    public Throwable getE() {
        return e;
    }

    public Response setE(Throwable e) {
        this.e = e;
        return this;
    }

    public long getTimeout() {
        return timeout;
    }

    public Response setTimeout(long timeout) {
        this.timeout = timeout;
        return this;
    }






}
