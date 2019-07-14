package main.MultiThread.study1;

import org.junit.Test;

/**
 * 线程的状态
 */
public class TestThreadStatus {
    /**
     * Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响
     * Thread.sleep(1000); 会抛出InterruptedException 中断异常，因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException
     */
    public static void sleepTest() {

        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };

        t1.start();

    }

    /**
     * 首先解释一下主线程的概念
     * 所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。
     * 执行t.join，即表明在主线程中加入该线程。只有执行完t线程才可以干别的
     * 主线程会等待该线程结束完毕， 才会往下运行。
     */
    public static void joinTest() {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        Thread t1 = new Thread() {
            public void run() {
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        //代码执行到这里，一直是main线程在运行
        try {
            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };
        //会观察到盖伦把提莫杀掉后，才运行t2线程
        t2.start();

    }

    /**
     * 线程优先级
     * t1.setPriority(Thread.MAX_PRIORITY);
     * t2.setPriority(Thread.MIN_PRIORITY);
     */
    @Test
    public static void priorityTest() {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 6160;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 3000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 5000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 4505;
        leesin.damage = 1;

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {
                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();

    }

    /**
     * 线程让步 临时暂停
     * yield
     */
    public void yieldTest() {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 61600;
        gareen.damage = 1;

        final Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 30000;
        teemo.damage = 1;

        final Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 50000;
        bh.damage = 1;

        final Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 45050;
        leesin.damage = 1;

        Thread t1 = new Thread() {
            public void run() {

                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                while (!leesin.isDead()) {

                    //临时暂停，使得t1可以占用CPU资源
                    Thread.yield();

                    bh.attackHero(leesin);
                }
            }
        };

        t1.setPriority(5);
        t2.setPriority(5);
        t1.start();
        t2.start();

    }

    /**
     * 守护线程
     * 守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。
     * 就好像一个公司有销售部，生产部这些和业务挂钩的部门。
     * 除此之外，还有后勤，行政等这些支持部门。
     * 如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。
     * 守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。
     * 守护线程通常会被用来做日志，性能统计等工作。
     */
    @Test
    public static void daemonTest() {

        Thread t1 = new Thread() {
            public void run() {
                int seconds = 0;

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);

                }
            }
        };
        t1.setDaemon(true);//如果一个进程只剩下守护线程，那么进程就会自动结束。
        t1.start();


    }

    public static void main(String[] args) {
//        TestThreadStatus.daemonTest();
        TestThreadStatus.joinTest();
        TestThreadStatus.priorityTest();;


    }
}
