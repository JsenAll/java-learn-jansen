package main.MultiThread.study3synchronized;

import org.junit.Test;

/**
 * 使用多个不同的线程对象  使用synchronized加在方法上是不能实现同步
 * 使用一个线程对像,可以使用synchronized加在方法上
 */
public class BuyTrianTicket3 implements Runnable {
    static private int ticketNum = 10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            add();
        }
    }

    public synchronized void add() {
        if (ticketNum > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNum--);
        }
    }

    /**
     * 使用多个不同的线程对象  使用synchronized加在方法上是不能实现同步
     */
    @Test
    public void test01() {
        BuyTrianTicket3 b1 = new BuyTrianTicket3();
        BuyTrianTicket3 b2 = new BuyTrianTicket3();
        BuyTrianTicket3 b3 = new BuyTrianTicket3();
        new Thread(b1, "窗口1").start();
        new Thread(b2, "窗口2").start();
        new Thread(b3, "窗口3").start();
    }

    /**
     * 使用一个线程对像,可以使用synchronized加在方法上
     */
    @Test
    public void test02() {
        BuyTrianTicket3 buyTrainTicket2 = new BuyTrianTicket3();
        new Thread(buyTrainTicket2, "窗口1").start();
        new Thread(buyTrainTicket2, "窗口2").start();
        new Thread(buyTrainTicket2, "窗口3").start();
    }

    public static void main(String[] args) {
//     new BuyTrianTicket3().   test02();
        new BuyTrianTicket3().test01();
    }

}
