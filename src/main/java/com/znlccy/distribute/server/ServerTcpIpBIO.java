package com.znlccy.distribute.server;

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
             *
             */
            ServerSocket ss = new ServerSocket(8888);

            /**
             *
             */
            ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
