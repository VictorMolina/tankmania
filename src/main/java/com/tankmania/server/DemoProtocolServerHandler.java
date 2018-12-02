package com.streetjam.server;

import com.streetjam.game.processor.StreetJamProcessor;
import com.streetjam.proto.StreetJamProtos;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DemoProtocolServerHandler extends SimpleChannelInboundHandler<StreetJamProtos.StreetJamRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StreetJamProtos.StreetJamRequest msg)
            throws Exception {

        ctx.write(StreetJamProcessor.process(msg));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
