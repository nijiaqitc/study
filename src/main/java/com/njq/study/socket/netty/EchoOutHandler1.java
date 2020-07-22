package com.njq.study.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

import java.net.SocketAddress;
import java.util.Date;

public class EchoOutHandler1 extends ChannelOutboundHandlerAdapter {

    @Override
    // 向client发送消息
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("out1");
        /*System.out.println(msg);*/

        String response = "\nI am ok!\n";
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());

        String currentTime = new Date(System.currentTimeMillis()).toString();
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(resp);
        ctx.writeAndFlush(encoded);
        ctx.flush();
    }

    public void read(ChannelHandlerContext ctx) throws Exception {
        ctx.read();
        System.out.println("读取数据.........");
    }

    @Override
    public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress,
                        SocketAddress localAddress, ChannelPromise promise) throws Exception {
        ctx.connect(remoteAddress, localAddress, promise);
        System.out.println("--------------:" + ctx.name() + " is connect in " + localAddress.toString() + " in client " + remoteAddress.toString() + " in " + promise.toString());
    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.name() + " handlerAdded = = " + ctx.name());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.name() + " handlerRemoved = = " + ctx.name());
    }

    @Override
    public void bind(ChannelHandlerContext ctx, SocketAddress localAddress,
                     ChannelPromise promise) throws Exception {
        ctx.bind(localAddress, promise);
        System.out.println(ctx.name() + " is bind in " + localAddress.toString() + " in " + promise.toString());
    }
}
