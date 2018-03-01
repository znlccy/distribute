package com.znlccy.distribute.client;

import ch.qos.logback.core.net.SocketConnector;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ClientTcpIpNIO {

    public void createSocket() {
        try {
            /*SocketConnector socketConnector = new SocketConnector(Runtime.getRuntime().availableProcessors()+1, Executors.newCachedThreadPool());*/
            Socket socket = new Socket("127.0.0.1",9999);
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            //创建SocketChannel对象
            SocketChannel channel = SocketChannel.open();
            //设置为非阻塞模式
            channel.configureBlocking(false);
            //对于非阻塞模式，立刻返回false，表示连接正在建立中
            channel.connect(socketAddress);
            Selector selector = Selector.open();
            //向channel注册selector以及感兴趣的连接事件
            channel.register(selector, SelectionKey.OP_CONNECT);
            /*阻塞至有感兴趣的IO事件发生，或达到超时时间，如果希望一直等至有感兴趣的IO事件发生，可调用无参数的select方法，如果希望不阻塞直接返回
             * 目前是否有感兴趣的事件发生，可调用selectNow方法
             */
            int nKeys = selector.select();
            //如果nKeys大于零，说明有感兴趣的IO事件发生
            SelectionKey selectionKey = null;
            if (nKeys > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key:keys) {
                    //对于发生连接的事件
                    if (key.isConnectable()) {
                        SocketChannel sc = (SocketChannel) key.channel();
                        sc.configureBlocking(false);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
