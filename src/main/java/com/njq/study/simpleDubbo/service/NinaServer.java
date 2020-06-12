package com.njq.study.simpleDubbo.service;

import com.njq.study.simpleDubbo.DefaultNettyHandler;
import com.njq.study.simpleDubbo.Request;
import com.njq.study.simpleDubbo.Url;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
/**
 * Created by kai.yang on 2018/11/1.
 */
public class NinaServer {

    private Logger logger= LoggerFactory.getLogger(getClass());

    private Url url;

    ServerBootstrap serverBootstrap = null;

    volatile boolean isClosed;

    EventLoopGroup bossGroup = null;

    EventLoopGroup workerGroup = null;



    public NinaServer(Url url) {
        this.url = url;
    }

    public boolean isBound() {
        return false;
    }

    public NinaServer init() {
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                .childOption(ChannelOption.SO_REUSEADDR, Boolean.TRUE)
                .option(ChannelOption.RCVBUF_ALLOCATOR, new FixedRecvByteBufAllocator(65535))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ByteArrayDecoder());
                        socketChannel.pipeline().addLast(new ByteArrayEncoder());

                        socketChannel.pipeline().addLast(new DefaultNettyHandler<>(Request.class));


                    }
                });

        start();

        return this;
    }


    public boolean close() {
        if (isClosed) {
            return true;
        }
        isClosed = true;
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
        return true;
    }

    public NinaServer start() {
        ChannelFuture future = serverBootstrap.bind(Integer.valueOf(url.getPort())).addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                if (!future.isSuccess()) {
                    future.channel().eventLoop().schedule(() -> start(), 1, TimeUnit.SECONDS);
                } else {
                    logger.info("服务可用了");
                }
            }
        });

        return this;
    }

}
