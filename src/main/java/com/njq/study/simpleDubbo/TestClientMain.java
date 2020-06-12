package com.njq.study.simpleDubbo;

import com.njq.study.simpleDubbo.reference.RefeneceBean;
import com.njq.study.simpleDubbo.test.TestApi;

import java.io.IOException;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class TestClientMain {

    public static void main(String[] args) throws IOException {
        RefeneceBean<TestApi> refeneceBean=new RefeneceBean(TestApi.class);
        TestApi testApi = refeneceBean.get();
        for (int i = 0; i <4 ; i++) {
            System.out.println(testApi.setInt(90));

        }
    }
}
