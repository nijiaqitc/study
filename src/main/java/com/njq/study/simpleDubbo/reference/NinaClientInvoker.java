package com.njq.study.simpleDubbo.reference;


import com.njq.study.simpleDubbo.NinaInovker;
import com.njq.study.simpleDubbo.Request;
import com.njq.study.simpleDubbo.Response;
import com.njq.study.simpleDubbo.Url;

/**
 * Created by kai.yang on 2018/11/2.
 */
public class NinaClientInvoker implements NinaInovker {

    NinaClient ninaClient;

    Url url;

    public NinaClientInvoker(NinaClient ninaClient, Url url) {
        this.ninaClient = ninaClient;
        this.url = url;
    }

    @Override
    public Response invoke(Request request) throws Throwable {
        //发送消息
        System.out.println("调用服务"+url);

        boolean send = ninaClient.send(request);
        if (send){
            return new Response(30000, request.getId());
        }

        throw new RuntimeException("远程调用失败,发送消息异常");
    }

    @Override
    public boolean destory() throws Throwable {
        ninaClient.destory();
        return false;
    }


}
