package com.njq.study.simpleDubbo;

import com.njq.study.simpleDubbo.test.TestApi;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Created by kai.yang on 2018/11/1.
 */
public class Url {

    private static final String URL_PRE="nina:";

    String ip;

    String port;

    String interfaceType;

    String[] methods;

    public Url(String ip, String port, String interfaceType, String[] methods) {
        this.ip = ip;
        this.port = port;
        this.interfaceType = interfaceType;
        this.methods = methods;
    }



    public Url(String urlStr) {
        //nina://127.0.0.1:8098?interface=testdubbo.test.TestApi&methods=sayHello,goBack
        if(!StringUtils.isEmpty(urlStr)){
            String split = urlStr.replace(URL_PRE,"");
            String[] split1 = split.split("\\?"); //127.0.0.1:8098     interface=testdubbo.test.TestApi&methods=sayHello,goBack
            String[] s = split1[0].split(":"); //127.0.0.1:8098
            ip=s[0];
            port=s[1];
            String[] split2 = split1[1].split("&");// interface=testdubbo.test.TestApi&methods=sayHello,goBack
            for (String params:split2) {
                String[] split3 = params.split("=");
                if(split3[0].equals("interface")){
                    interfaceType=split3[1];
                }else if(split3[0].equals("methods")){
                    methods= split3[1].split(",");
                }
            }

        }
    }

    public Url(String ip, String port, Class interceType) {
        this.ip = ip;
        this.port = port;
        if(interceType!=null){
            interfaceType = interceType.getName();
            Method[] declaredMethods = interceType.getDeclaredMethods();
            if(declaredMethods!=null){
                methods=new String[declaredMethods.length];
                for (int i = 0; i <declaredMethods.length ; i++) {
                    methods[i]=declaredMethods[i].getName();
                }
            }else{
                throw new RuntimeException("错误的url,缺少可用方法定义");

            }
        }else{
            throw new RuntimeException("错误的url,缺少接口定义");
        }


    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder(URL_PRE);
        sb.append(ip).append(":").append(port).append("?interface=").append(interfaceType);
        String methodsStr="";
        if(methods!=null&&methods.length>0){
             methodsStr="&methods=";
            for (int i = 0; i < methods.length; i++) {
                if(i!=0){
                    methodsStr+=","+methods[i];
                }else {
                    methodsStr+=methods[i];
                }
            }

        }

        return sb.append(methodsStr).toString();

    }

    public static void main(String[] args) {
        Url url = new Url("127.0.0.1", "8098", TestApi.class);
        System.out.println(url.toString());
        Url url1 = new Url(url.toString());
        System.out.println(url1);
        System.out.println(url.equals(url1));
    }


    public String getIp() {
        return ip;
    }

    public Url setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getPort() {
        return port;
    }

    public Url setPort(String port) {
        this.port = port;
        return this;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public Url setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
        return this;
    }

    public String[] getMethods() {
        return methods;
    }

    public Url setMethods(String[] methods) {
        this.methods = methods;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Url url = (Url) o;

        if (ip != null ? !ip.equals(url.ip) : url.ip != null) return false;
        if (port != null ? !port.equals(url.port) : url.port != null) return false;
        if (interfaceType != null ? !interfaceType.equals(url.interfaceType) : url.interfaceType != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(methods, url.methods);

    }

    @Override
    public int hashCode() {
        int result = ip != null ? ip.hashCode() : 0;
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (interfaceType != null ? interfaceType.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(methods);
        return result;
    }
}
