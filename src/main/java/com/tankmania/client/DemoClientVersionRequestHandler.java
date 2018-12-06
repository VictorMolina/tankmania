package com.tankmania.client;

import com.tankmania.proto.TankManiaProtos;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class DemoClientVersionRequestHandler extends SimpleChannelInboundHandler<TankManiaProtos.TankManiaResponse> {

    private Channel channel;
    private TankManiaProtos.TankManiaResponse resp;
    BlockingQueue<TankManiaProtos.TankManiaResponse> resps = new LinkedBlockingQueue<>();
    public TankManiaProtos.TankManiaResponse sendRequest() {
        TankManiaProtos.TankManiaRequest req = TankManiaProtos.TankManiaRequest.newBuilder()
                .setVersionRequest(TankManiaProtos.VersionRequest.newBuilder().build())
                .build();

        // Send request
        channel.writeAndFlush(req);

        // Now wait for response from server
        boolean interrupted = false;
        for (;;) {
            try {
                resp = resps.take();
                break;
            } catch (InterruptedException ignore) {
                interrupted = true;
            }
        }

        if (interrupted) {
            Thread.currentThread().interrupt();
        }

        return resp;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) {
        channel = ctx.channel();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TankManiaProtos.TankManiaResponse msg)
            throws Exception {
        resps.add(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}