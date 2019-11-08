package main.internet.study03_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 1:使用
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送启动中");
        //1:使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //2:准备数据 一定转成字节数组
        String data="我爱你";
        byte[] datas=data.getBytes();
        //3
        DatagramPacket packet =new DatagramPacket(datas,0,datas.length,new InetSocketAddress("local",9999));
        //4 发送包裹
    }
}
