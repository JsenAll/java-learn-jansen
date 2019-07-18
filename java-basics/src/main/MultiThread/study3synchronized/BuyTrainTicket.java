package main.MultiThread.study3synchronized;

/**
 * 同步代码块:
 * synchronized (this) 括号里面的文件必须是引用类型的
 */


public class BuyTrainTicket implements Runnable {
    private int ticketNum = 10;


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//this 是指当前的对象 , 三个线程 公用的是一个对象 buyTrainTicket
//
            synchronized (this) {
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "---" + ticketNum--);
                }
            }
        }
    }


    public static void main(String[] args) {
        BuyTrainTicket buyTrainTicket = new BuyTrainTicket();
        new Thread(buyTrainTicket, "窗口1").start();
        new Thread(buyTrainTicket, "窗口2").start();
        new Thread(buyTrainTicket, "窗口3").start();
    }
}