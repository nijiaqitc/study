package com.njq.study.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimerClientHandler extends ChannelInboundHandlerAdapter {
    private final ByteBuf firstMessage;

    public TimerClientHandler() {
        byte[] req = "abc\r\n".getBytes();
        this.firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(firstMessage);
        String echoReq = "Hi,welcom to netty.$_";
        for (int i = 0; i < 20; i++) {
            if(i == 19){
                echoReq = echoReq.replace("_", "+");
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer(echoReq.getBytes()));
        }

        Thread.sleep(2000);
        ctx.writeAndFlush(Unpooled.copiedBuffer("nnnnnn.$_".getBytes()));
    }

    int counter;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        System.out.println("now is :" + (++counter) + ":" + body);


        String body = (String)msg;
        System.out.println("now is :" + (++counter) + ":" + body);

//        ByteBuf msg1 = Unpooled.wrappedBuffer("msg hello world".getBytes());
//        ctx.writeAndFlush(msg1);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
