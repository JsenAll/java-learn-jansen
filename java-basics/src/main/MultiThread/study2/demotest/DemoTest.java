package main.MultiThread.study2.demotest;

/**
 *
 */
public class DemoTest extends Thread {
    public DemoTest(String Name) {
        super.setName(Name);
    }

    @Override
    public void run() {


        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);

            if (i == 6) {
                Thread.yield();//进入就绪状态可能马上被调用,也可能等待被调用
            }
        }
    }

    public static void main(String[] args) {
        DemoTest demoTest = new DemoTest("线程1");
        demoTest.setDaemon(true);//设置成伴随线程 主线程挂了 这个线程也跟着挂掉
        demoTest.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);

        }


    }
}