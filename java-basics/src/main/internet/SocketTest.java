package main.internet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {
//        try {
//            Socket socket = new Socket("time-a.nist.gov", 13);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        while (true) {
            Socket socket = new Socket("time-a.nist.gov", 13);
            socket.setSoTimeout(100000);
            Scanner in = new Scanner(socket.getInputStream(), "UTF-8");
            if (!in.hasNext())
                continue;
            while (in.hasNext()){
                String line = in.nextLine();
                System.out.println("asdas" + line);
            }

        }
//        Socket s=new Socket();
//        s.connect(new InetSocketAddress("time-a.nist.gov", 13),1000);


    }
}
