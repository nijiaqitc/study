package com.njq.study.simpleDubbo;

import com.njq.study.simpleDubbo.service.ServiceBean;
import com.njq.study.simpleDubbo.test.TestApi;
import com.njq.study.simpleDubbo.test.TestApiImpl;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class TestMain2 {

    public static void main(String[] args) throws Exception {

        TestApi testApi = new TestApiImpl();
        ServiceBean<TestApi> testApiServiceBean = new ServiceBean<>(testApi, TestApi.class,9000);
        testApiServiceBean.export();
        System.in.read();


    }
}
