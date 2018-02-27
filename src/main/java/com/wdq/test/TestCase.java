package com.wdq.test;

import com.wdq.client.ConnectManage;
import com.wdq.inter.IHelloService;
import com.wdq.proxy.ProxyClient;
import org.springframework.util.StopWatch;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class TestCase {
    public static void main(String[] args) throws UnknownHostException {
        try {
            ConnectManage.getInstance().connectServerNode(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8000));
            Thread.sleep(5000);
            StopWatch stopWatch = new StopWatch();
            IHelloService iHelloService = ProxyClient.create(IHelloService.class);
            stopWatch.start();
            for (int i = 0; i < 100000; i++) {
                String name = iHelloService.hello("wdq");
                System.out.println(name);
            }
            stopWatch.stop();
            System.out.println(stopWatch.getTotalTimeSeconds());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
