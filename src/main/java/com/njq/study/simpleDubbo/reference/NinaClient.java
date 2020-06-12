package com.njq.study.simpleDubbo.reference;

import com.njq.study.simpleDubbo.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by kai.yang on 2018/11/1.
 */
public class NinaClient {


    private static final NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup(Math.min(Runtime.getRuntime().availableProcessors() + 1, 32), new DefaultThreadFactory("NettyClientWorker", true));

    private Bootstrap bootstrap;

    private volatile Url url;

    private volatile Channel channel;

    KryoSerializer<Request> kryoSerializer=new KryoSerializer<>(Request.class);


    public NinaClient(Url url) {
        this.url = url;
        init();
        open();
    }

    public void init(){
        final DefaultNettyHandler nettyClientHandler = new DefaultNettyHandler(Response.class);
        bootstrap = new Bootstrap();
        bootstrap.group(nioEventLoopGroup)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                  .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535));

        bootstrap.handler(new ChannelInitializer() {

            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast(new ByteArrayDecoder());
                ch.pipeline().addLast(new ByteArrayEncoder());
                ch.pipeline().addLast(nettyClientHandler);
            }
        });
    }


    public Channel open(){
        ChannelFuture future = bootstrap.connect(url.getIp(), Integer.valueOf(url.getPort()));
        boolean ret = future.awaitUninterruptibly(3000, TimeUnit.MILLISECONDS);
        if(ret&&future.isSuccess()){
            if(channel!=null){
                channel.close();
            }
            channel=future.channel();
            return channel;
        }

        throw  new RuntimeException("开启通道信息异常");

    }

    public void destory(){
        if(channel!=null){
            channel.close();
        }
    }



    public boolean send(Object o){
        if(channel==null||!channel.isActive()) {
            try {
                if(channel!=null) {
                    channel.close();
                }
            } catch (Exception e) {
            }

            open();
        }

        byte[] serialize = kryoSerializer.serialize(o);
        ChannelFuture future = channel.writeAndFlush(serialize);
        Throwable cause = future.cause();
        if(cause!=null){
            cause.printStackTrace();
            throw new RuntimeException("发送消息失败");
        }
        return true;

    }

}
