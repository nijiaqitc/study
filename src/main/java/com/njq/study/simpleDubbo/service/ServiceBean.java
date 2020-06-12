package com.njq.study.simpleDubbo.service;

import com.njq.study.simpleDubbo.Url;
import com.njq.study.simpleDubbo.ZkUtils;
import org.springframework.beans.factory.DisposableBean;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kai.yang on 2018/11/1.
 */
public class ServiceBean<T>  implements DisposableBean {

    private T ref;

    private Class type;

    private int port=DEFAULT_PORT;

    private static final int DEFAULT_PORT=52066;

    private Url url;

    private static final String PROVIDER_PATH="providers";

    private static final Map<String,NiniServerInvoker> invokersMap=new ConcurrentHashMap<>();

    private NinaServer nettyServer;

    public static Map<String, NiniServerInvoker> getInvokersMap() {
        return invokersMap;
    }

    public ServiceBean(T ref, Class type, int port) {
        this.ref = ref;
        this.type = type;
        this.port=port;
    }


    public ServiceBean(T ref, Class type) {
        this.ref = ref;
        this.type = type;
    }

    /**
     * 发布服务
     */
    public void export() throws Exception {
        //获取本地ip
        String hostIp = findHostIp();

        //生成要发布的url
        Url url = new Url(hostIp, Integer.valueOf(port).toString(), type);

        this.url=url;


        //生成对应调用invoker
        invokersMap.putIfAbsent(type.getName(),new NiniServerInvoker(ref,type));

        //注册
        ZkUtils.createNode(type.getName());
        ZkUtils.createNode(type.getName()+"/"+PROVIDER_PATH);
        ZkUtils.createNode(type.getName()+"/"+PROVIDER_PATH+"/"+url.toString());

        //开启服务
        nettyServer = new NinaServer(url).init().start();

    }



    /**
     * 获取本地ip
     * @return
     */
    public static String findHostIp(){
        try {
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            return hostAddress;
        } catch (UnknownHostException e) {
            throw new RuntimeException("获取本地ip失败");
        }
    }


    @Override
    public void destroy() throws Exception {
        invokersMap.remove(url.toString());
        ZkUtils.revomeNode("/"+type.getName()+"/providers/"+url.toString());
        nettyServer.close();
    }
}
