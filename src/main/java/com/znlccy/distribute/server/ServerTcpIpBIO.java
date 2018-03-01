package com.znlccy.distribute.server;

import org.apache.tomcat.jni.Socket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @CreateTime:2018/3/1 11:02
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment:
 */
public class ServerTcpIpBIO {

    public void accpetSocket() {
        try {
            /**
             * 创建本地制定端口的监听，如果端口冲突则抛出SocketException,其他网络IO方面的异常则抛出IOException
             */
            ServerSocket ss = new ServerSocket(8888);

            /**
             * 接受客户端连接的请求，并返回Socket对象，以便和客户端进行交互，交互的方式和客户端相同，也是通过Socket.getInputStream和Socket.getOutputStream
             * 来进行读写操作，此方法会一直阻塞到客户端发送建立连接的请求，如果希望此方法最多阻塞一定时间，则要在创建ServerSocket后调用其setSoTimeout(以毫秒为单位)
             */
            ss.accept();
            /*ss.setSoTimeout(3000);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
