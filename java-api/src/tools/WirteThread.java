package tools;

import java.io.IOException;

public class WirteThread extends Thread {

    public void run() {
        int i = 0;
        while (i++ < 1000) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Thread.currentThread().getName() + "\r\n");
            try {
                Txtfile.createFile("D:/Filetest/fileOK", "data25", stringBuffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
