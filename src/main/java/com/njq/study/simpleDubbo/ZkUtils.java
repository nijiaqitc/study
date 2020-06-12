package com.njq.study.simpleDubbo;

import com.njq.study.simpleDubbo.reference.NinaListener;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kai.yang on 2018/9/13.
 */
public class ZkUtils {

    private static CuratorFramework client=null;


    private static final String NAME_SPACE="nina";

    static{
        try {
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.builder().namespace(NAME_SPACE).retryPolicy(retryPolicy)
                    .sessionTimeoutMs(5000).connectionTimeoutMs(3000).connectString("118.25.12.143:2181").build();
            client.start();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void subscribe( String subcribePath,final NinaListener... listeners) throws Exception{
        ExecutorService pool = Executors.newCachedThreadPool();
        PathChildrenCache childrenCache = new PathChildrenCache(client,subcribePath, true);
        PathChildrenCacheListener childrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                ChildData data = event.getData();
                switch (event.getType()) {
                    case CHILD_ADDED:
                        doNotify(new String(data.getPath()),NinaListener.ADD_OPTION,listeners);
                        break;
                    case CHILD_REMOVED:
                        doNotify(new String(data.getPath()),NinaListener.REMOVE_OPTION,listeners);
                        break;
                    case CHILD_UPDATED:
                        doNotify(new String(data.getPath()),NinaListener.UPDATE_OPTION,listeners);
                        break;
                    default:
                        break;
                }
            }
        };
        childrenCache.getListenable().addListener(childrenCacheListener);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

    }


    public static void doNotify(String date,int option,NinaListener... ninaListeners){
        if(ninaListeners!=null&&ninaListeners.length>0){
            for (NinaListener listener:ninaListeners ) {
                try {
                    listener.doNotify(option,date.substring(date.lastIndexOf("/")+1,date.length()));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }



    public static void createNode(String nodePath) throws Exception {

        Stat stat = client.checkExists().forPath(getNodePath(nodePath));
        if(stat==null) {
            client.create().forPath(getNodePath(nodePath), null);
        }else{
            System.out.println("节点已存在");
        }
    }

    public static void revomeNode(String nodePath) throws Exception {
        client.delete().forPath( getNodePath(nodePath));
    }

    public static void revomeAllChildNode(String nodePath) throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath( getNodePath(nodePath));
    }

    public static void updateeNode(String nodePath,String data) throws Exception {
        client.setData().forPath(getNodePath(nodePath),data.getBytes());
    }


    public static List<String> getNodes(String nodePath) throws Exception {

       return client.getChildren().forPath(getNodePath(nodePath));
    }



    public static String getNodePath(String nodePath){
        return nodePath.startsWith("/")?nodePath:"/"+nodePath;
    }

    public static void main(String[] args) throws Exception {
//        createNode("/providers/ddsdfsddddf");
        NinaListener ninaListener = new NinaListener(){

            @Override
            public void doNotify(int Option, String date) throws Exception {
                System.out.println("监听到数据变化"+date+",type="+Option);

            }
        };
        subscribe("/providers",ninaListener);
        System.in.read();
    }


}
