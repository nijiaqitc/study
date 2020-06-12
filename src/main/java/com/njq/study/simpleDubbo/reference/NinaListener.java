package com.njq.study.simpleDubbo.reference;

/**
 * Created by kai.yang on 2018/11/2.
 */
public interface NinaListener {

    int ADD_OPTION=1;

    int REMOVE_OPTION=-1;

    int UPDATE_OPTION=2;


    void doNotify(int Option, String date) throws Exception;
}
