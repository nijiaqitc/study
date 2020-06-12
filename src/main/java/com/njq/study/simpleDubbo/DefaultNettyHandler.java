package com.njq.study.simpleDubbo;


import com.njq.study.simpleDubbo.service.NiniServerInvoker;
import com.njq.study.simpleDubbo.service.ServiceBean;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;

/**
 * Created by kai.yang on 2018/11/1.
 */
@io.netty.channel.ChannelHandler.Sharable
public class DefaultNettyHandler<T> extends ChannelDuplexHandler {

    KryoSerializer recivedSerializer;

    KryoSerializer respSer=new KryoSerializer(Response.class);

    Class<T> serializerType;


    public DefaultNettyHandler(Class serializerType) {
        this.serializerType = serializerType;
        recivedSerializer=new KryoSerializer(serializerType);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接收消息");
        Object deserialize = null;
        try {
            deserialize = recivedSerializer.deserialize((byte[]) msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(deserialize instanceof Response){
            Response.received((Response) deserialize);
        }else if(deserialize instanceof Request){
            Request request=(Request)deserialize;
            Map<String, NiniServerInvoker> invokersMap = ServiceBean.getInvokersMap();
            NiniServerInvoker niniServerInvoker = invokersMap.get(request.getClassType());
            Response response=new Response(request.getId());
            try {
                response = niniServerInvoker.invoke(request);
            } catch (Throwable throwable) {
                response.setE(throwable);
            }
            byte[] serialize = respSer.serialize(response);
            ctx.writeAndFlush(serialize);
        }else{
            throw new RuntimeException("非法请求参数");
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }


}
