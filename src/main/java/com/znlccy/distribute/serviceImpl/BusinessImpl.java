package com.znlccy.distribute.serviceImpl;

import com.znlccy.distribute.service.Business;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 * @CreateTime:2018/3/1 16:42
 * @Author:Administrator
 * @Version:v-1.0.0
 * @Comment: WebService制定对外提供的WebService的名称和客户端生成的类名和包名
 */

@WebService(name = "Business",serviceName = "BusinessService",targetNamespace = "http://WebService.chapter1.book/client")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BusinessImpl implements Business{

    @Override
    public String echo(String message) {

        if ("quit".equalsIgnoreCase(message.toString())) {
            System.out.println("Server will be shutdown");
            System.exit(0);
        }

        System.out.println("Message from client: "+ message);

        return "Server response: " + message;
    }

    /**
     * @comment: main 发布WebService类
     * @param: [args]
     * @return: void
     */
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9527/BusinessService",new BusinessImpl());
        System.out.println("Server has beed started");
    }
}
