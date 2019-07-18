package main.MultiThread.study3synchronized;

public class BuyTrainTicket2 implements Runnable {
    private int ticketNum = 10;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            synchronized (this)
//            如果此时再用this  三个线程使用的是三个对象   使用this 这不能对代码块的内容上锁
            synchronized (BuyTrainTicket.class) {
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
        BuyTrainTicket2 b1 = new BuyTrainTicket2();
        BuyTrainTicket2 b2 = new BuyTrainTicket2();
        BuyTrainTicket2 b3 = new BuyTrainTicket2();
        new Thread(b1, "窗口1").start();
        new Thread(b2, "窗口2").start();
        new Thread(b3, "窗口3").start();
    }
}