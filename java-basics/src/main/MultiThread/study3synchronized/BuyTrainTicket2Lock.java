package main.MultiThread.study3synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock 进行加锁
 */
public class BuyTrainTicket2Lock implements Runnable {
    private static int ticketNum = 10;
    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + ticketNum--);
                }
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        BuyTrainTicket2Lock b1 = new BuyTrainTicket2Lock();
        BuyTrainTicket2Lock b2 = new BuyTrainTicket2Lock();
        BuyTrainTicket2Lock b3 = new BuyTrainTicket2Lock();
        new Thread(b1, "窗口1").start();
        new Thread(b2, "窗口2").start();
        new Thread(b3, "窗口3").start();
    }
}