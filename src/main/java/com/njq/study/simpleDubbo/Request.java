package com.njq.study.simpleDubbo;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by kai.yang on 2018/11/1.
 */
public class Request implements Serializable{

    private static final long serialVersionUID = -4355285085441000005L;

    String id= UUID.randomUUID().toString();

    String method;

    String classType;

    Object[] params;



    public String getId() {
        return id;
    }


    public String getMethod() {
        return method;
    }

    public Request setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getClassType() {
        return classType;
    }

    public Request setClassType(String classType) {
        this.classType = classType;
        return this;
    }

    public Object[] getParams() {
        return params;
    }

    public Request setParams(Object[] params) {
        this.params = params;
        return this;
    }
}
