package com.njq.study.simpleDubbo;

import com.njq.study.simpleDubbo.service.ServiceBean;
import com.njq.study.simpleDubbo.test.TestApi;
import com.njq.study.simpleDubbo.test.TestApiImpl;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        //测试方法，没有调用销毁，每次启动删除原有注册服务
        ZkUtils.revomeAllChildNode("/kai.test.nina.test.TestApi");


        TestApi testApi = new TestApiImpl();
        ServiceBean<TestApi> testApiServiceBean = new ServiceBean<>(testApi, TestApi.class);
        testApiServiceBean.export();
        System.in.read();


    }
}
