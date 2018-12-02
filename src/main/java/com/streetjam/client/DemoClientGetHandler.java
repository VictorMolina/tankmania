package com.streetjam.client;

import com.streetjam.proto.StreetJamProtos;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class DemoClientGetHandler extends SimpleChannelInboundHandler<StreetJamProtos.StreetJamResponse> {

    private Channel channel;
    private StreetJamProtos.StreetJamResponse resp;
    BlockingQueue<StreetJamProtos.StreetJamResponse> resps = new LinkedBlockingQueue<>();
    public StreetJamProtos.StreetJamResponse sendRequest() {
        StreetJamProtos.StreetJamRequest req = StreetJamProtos.StreetJamRequest.newBuilder()
                .setAddressBookRequest(StreetJamProtos.AddressBookRequest.newBuilder().setId(1L).build())
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
    protected void channelRead0(ChannelHandlerContext ctx, StreetJamProtos.StreetJamResponse msg)
            throws Exception {
        resps.add(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}