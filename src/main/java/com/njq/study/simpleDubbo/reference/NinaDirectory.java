package com.njq.study.simpleDubbo.reference;

import com.njq.study.simpleDubbo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class NinaDirectory implements NinaInovker, NinaListener {



    private final String PROVIDER_PATH;

    Class type;

    //urlstring--->invoker
    Map<String, NinaInovker> inovkerMap = new ConcurrentHashMap<>();

    List<NinaInovker> invokers = new ArrayList<>();

    AtomicInteger count = new AtomicInteger(0);

    public NinaDirectory(Class type) throws Exception {
        this.type = type;
        PROVIDER_PATH="/"+this.type.getName()+"/providers";
        subscribe();
    }

    @Override
    public Response invoke(Request request) throws Throwable {

        //选择-->此处简写只有轮询
        if (invokers.size() == 0) {
            throw new RuntimeException("远程调用失败,无可用服务" + request.getClassType());
        }
        int postion = (count.getAndIncrement() % invokers.size());
        NinaInovker ninaInovker = invokers.get(postion);
        //调用选择出的invoker，进行调用
        return ninaInovker.invoke(request);

    }


    public NinaDirectory subscribe() throws Exception {
        //启动时首次获取所有path，直接初识化
        List<String> nodes = ZkUtils.getNodes(PROVIDER_PATH);
        if(nodes!=null){
            for (String url:nodes) {
                refreshInvokers(url,1);
            }
        }


        //从zk中订阅服务,获取目录下的url
        ZkUtils.subscribe(PROVIDER_PATH,this);
        return this;
    }


    public void refreshInvokers(String urlStr,int option) {

        switch (option) {
            case NinaListener.ADD_OPTION:
                Url url = new Url(urlStr);
                NinaInovker oldInvoker = inovkerMap.get(urlStr);
                if(oldInvoker==null) {
                    NinaClientInvoker ninaClientInvoker = new NinaClientInvoker(new NinaClient(url), url);
                    inovkerMap.put(urlStr, ninaClientInvoker);
                    invokers.add(ninaClientInvoker);
                }
                break;
            case NinaListener.REMOVE_OPTION:
                //需要删除的服务
                NinaInovker ninaInovker = inovkerMap.get(urlStr);
                if (ninaInovker != null) {
                    inovkerMap.remove(ninaInovker);
                    invokers.remove(ninaInovker);
                    try {
                        ninaInovker.destory();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }

                break;
            case NinaListener.UPDATE_OPTION:
                // TODO: 2018/11/2
                break;
        }


    }



    @Override
    public boolean destory() throws Throwable {
        if(invokers!=null){
            for (NinaInovker invoker:invokers
                 ) {
                invoker.destory();
            }
        }
        inovkerMap.clear();
        invokers.clear();
        return true;
    }


    @Override
    public void doNotify(int option,String url) throws Exception {
        System.out.println("监听到数据变化"+url+",type="+option);

        switch (option){
            case NinaListener.ADD_OPTION:
                refreshInvokers(url,NinaListener.ADD_OPTION);
                break;
            case NinaListener.REMOVE_OPTION:
                refreshInvokers(url,NinaListener.REMOVE_OPTION);

                break;
            case NinaListener.UPDATE_OPTION:
                refreshInvokers(url,NinaListener.UPDATE_OPTION);
                break;
        }

    }
}
