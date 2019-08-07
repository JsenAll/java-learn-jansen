package main.internet;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**网络编程
 *  InetSocketAddress
 *  1:构造器
 *  new InetSocketAddress(地址｜域名,端口)；
 *  2：方法
 *  getAddress()
 *  getHostName()
 *  getPort()
 */
public class Study02_GetPort {
    public static void main(String[] args) throws UnknownHostException {
        InetSocketAddress socketAddress=new InetSocketAddress("127.0.0.1",8080);
        System.out.println("计算机名|域名->"+socketAddress.getHostName());
        System.out.println("ip->"+socketAddress.getAddress());

        InetAddress address2 = InetAddress.getByName("127.0.0.1");
        System.out.println("ip->" + address2.getHostAddress());
        System.out.println("计算机名|域名->" + address2.getHostName());


        InetSocketAddress inetSocketAddress=new InetSocketAddress("localhost",9000);
        System.out.println("ip->"+inetSocketAddress.getAddress());
        System.out.println("端口-->"+inetSocketAddress.getPort());
    }


}
