package com.njq.study.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Promise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * @author: nijiaqi
 * @date: 2019/12/18
 */
public class TimeServer {
    public void bind(int port) {
        try {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            try {
                ServerBootstrap b = new ServerBootstrap();
                b.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG, 1024)
                        .childHandler(new ChildChannelHandler());

                ChannelFuture f = b.bind(port).sync();
                f.channel().closeFuture().sync();
            } finally {
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
//            socketChannel.pipeline().addLast(new TimeServerHandler());
            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
            socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(1024, delimiter));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 56789;
        try {
            new Thread(() -> new TimeServer().bind(port)).start();
//            System.out.println(123123123123L);
//            TimeUnit.SECONDS.sleep(2);
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            String str;
//            System.out.println("Enter lines of text.");
//            System.out.println("Enter 'exit' to quit.");
//            do {
//                // 从控制台读取一行数据，返回值字符串
//                str = br.readLine();
//                System.out.println("--------------");
//                System.out.println(str);
//                ByteBuf echo1 = Unpooled.copiedBuffer(str.getBytes());
//                TimeServerHandler.map.get("123").writeAndFlush(echo1);
//            } while (!str.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

}
