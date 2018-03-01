package com.znlccy.distribute.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @CreateTime:2018/3/1 10:46
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: 消息方式的系统间通信
 */

public class ClientTcpIpBIO {

    public void createSocket() {
        try {
            /**
             * 创建连接，如果域名解析不了会抛出UnKnownHostException，当连接不上时会抛出IOException，如果希望控制建立连接的超时，可选用new Socket(),
             * 然后调用socket.connect(SocketAddress)类型的目标地址，以毫秒为单位的超时时间
             */
            Socket socket = new Socket("localhost", 8888);

            /**
             * 创建读取服务器返回流的BufferedReader
             */
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            /**
             * 创建向服务器写入流的PrintWriter
             */
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            /**
             * 向服务器端发送字符串信息，要注意的是，此处即使写入失败也不会抛出异常信息，并且一直会阻塞到写入操作系统或网络IO出现异常为止
             */
            out.println("Hello");

            /**
             * 阻塞读取服务端返回的信息，一下代码会阻塞到服务器端返回信息或网络IO出现异常为止，如果希望在超过一段时间后就不阻塞，那么要在创建
             * Socket对象后调用socket.setToTimeOut(以毫秒为单位的超时时间)
             */
            in.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
