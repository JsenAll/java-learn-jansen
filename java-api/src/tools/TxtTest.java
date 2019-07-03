package tools;

import java.io.IOException;

public class TxtTest {


    public static void main(String[] args) throws IOException {
        WirteThread wirteThread = new WirteThread();
        WirteThread wirteThread1 = new WirteThread();
        WirteThread wirteThread2 = new WirteThread();

        wirteThread.start();
        wirteThread2.start();
        wirteThread1.start();

    }
}
