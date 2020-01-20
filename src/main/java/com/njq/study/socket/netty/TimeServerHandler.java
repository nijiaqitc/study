package com.njq.study.socket.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    public static Map<String, ChannelHandlerContext> map = new HashMap();

    int counter = 0;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        map.put("123", ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        String currentTime = "".equals(body) ? String.valueOf(new Date().getTime()) : "BAD ORDER\r\n";
//        System.out.println("receive:"+body+(++counter));
//        String currentTime = "ERROR";
//        if (body.equals("abc\r\n")) {
//            currentTime = String.valueOf(System.currentTimeMillis());
//        }
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.write(resp);
//        ctx.flush();

        String body = (String)msg;
        System.out.println("The time server receive order:" + (++counter) + body);
        body += "$_";
        System.out.println("write str:"+body);
        ByteBuf echo =Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
//
//
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        System.out.println("Enter lines of text.");
//        System.out.println("Enter 'exit' to quit.");
//        do {
//            // 从控制台读取一行数据，返回值字符串
//            str = br.readLine();
//            System.out.println(str);
//            ByteBuf echo1 =Unpooled.copiedBuffer(str.getBytes());
//            ctx.writeAndFlush(echo1);
//        } while (!str.equals("exit"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
