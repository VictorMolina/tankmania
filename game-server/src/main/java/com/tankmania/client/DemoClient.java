package com.tankmania.client;

import com.tankmania.proto.TankManiaProtos;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class DemoClient {

    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "8463"));
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new DemoClientInitializer());

            // Create connection
            Channel c = bootstrap.connect(HOST, PORT).sync().channel();

            // Get handle to handler so we can send message
            DemoClientVersionRequestHandler handle = c.pipeline().get(DemoClientVersionRequestHandler.class);
            TankManiaProtos.TankManiaResponse resp = handle.sendRequest();
            c.close();

            System.out.println("Got reponse msg from Server: " + resp);

        } finally {
            group.shutdownGracefully();
        }

    }
}