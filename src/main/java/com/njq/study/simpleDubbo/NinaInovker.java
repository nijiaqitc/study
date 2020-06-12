package com.njq.study.simpleDubbo;

/**
 * Created by kai.yang on 2018/11/1.
 */
public interface NinaInovker {

    /**
     * 调用
     * @param request
     * @return
     * @throws Throwable
     */
    Response invoke(Request request) throws Throwable;

    /**
     * 销毁
     * @return
     * @throws Throwable
     */
    boolean destory()throws Throwable;
}
