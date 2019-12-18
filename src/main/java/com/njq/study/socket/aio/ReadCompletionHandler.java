package com.njq.study.socket.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
    
    private AsynchronousSocketChannel channel;
    
    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null) {
            this.channel = channel;
        }
    }
 
    /**
     * 成功状态回调
     * @param result
     * @param attachment 
     */
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body);
            System.out.println("The time server receive order : " + req);
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req) 
                    ? new java.util.Date(System.currentTimeMillis()).toString() : "BAD ORDER";
            doWrite(currentTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 分离出写模块
     * @param response 
     */
    private void doWrite(String response) {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer, writeBuffer,
                new CompletionHandler<Integer, ByteBuffer>() {
                    
                    /**
                     * 成功状态回调
                     * @param result
                     * @param buffer 
                     */
                    @Override
                    public void completed(Integer result, ByteBuffer buffer) {
                        // 有可能写半包，若真如此则继续写
                        if (buffer.hasRemaining()) {
                            channel.write(buffer, buffer, this);
                        }
                    }
 
                    /**
                     * 失败状态回调
                     * @param exc
                     * @param attachment 
                     */
                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            channel.close();
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            );
        }
    }
 
    /**
     * 失败状态回调
     * @param exc
     * @param attachment 
     */
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
