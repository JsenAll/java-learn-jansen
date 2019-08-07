package main.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**网络编程
 * InetAddress
 * 1:getLocalHost()
 * 2:getByName():根据域名|IP
 *
 * 两个成员方法:
 * 1:address2.getHostAddress()
 * 2:address2.getHostName()
 */
public class Study01_GetLocalIP {
    public static void main(String[] args) {
        try {
            //使用getLocalHost()方法创建 InetAddress对象
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("本地ip->" + address.getHostAddress());
            System.out.println("本地计算机名->" + address.getHostName());

            //根据域名得到InetAddress对象
            InetAddress address2 = InetAddress.getByName("www.163.com");
            System.out.println("ip->" + address2.getHostAddress());
            System.out.println("计算机名|域名->" + address2.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
