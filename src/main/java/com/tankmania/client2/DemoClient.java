package com.tankmania.client2;

import com.tankmania.proto.StreetJamProtos;
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
            DemoClientAddHandler handleAdd = c.pipeline().get(DemoClientAddHandler.class);
            StreetJamProtos.StreetJamResponse respAdd = handleAdd.sendRequest();
            System.out.println("Got reponse msg from Server: " + respAdd);

            c.close();

        } finally {
            group.shutdownGracefully();
        }

    }
}