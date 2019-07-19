package main.MultiThread.study2.yieldtest;

/**
 * yield:暂停当前线程,使线程进入到就就绪状态(不是阻塞,是就绪)
 */
public class YieldTest extends Thread {
    public YieldTest(String Name) {
        super.setName(Name);
    }

    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);

            if (i == 6) {
                Thread.yield();//进入就绪状态可能马上被调用,也可能等待被调用
            }
        }
    }

    public static void main(String[] args) {
        new YieldTest("线程1").start();
        new YieldTest("线程2").start();

    }
}
