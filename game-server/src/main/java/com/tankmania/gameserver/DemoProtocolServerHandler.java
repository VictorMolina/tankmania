package com.tankmania.gameserver;

import com.tankmania.gameserver.processors.TankManiaProcessor;
import com.tankmania.proto.TankManiaProtos;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DemoProtocolServerHandler extends SimpleChannelInboundHandler<TankManiaProtos.TankManiaRequest> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TankManiaProtos.TankManiaRequest msg)
            throws Exception {

        ctx.write(TankManiaProcessor.process(msg));
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
