package main.MultiThread.study1;

import org.junit.Test;

/**
 * 多线程的三种方法:
 * 1:集成Thred的类
 * 2:实现Runnable接口
 * 3:匿名类的方式
 * 4:实现Callable接口(这里不实现)
 */
public class TestThread {
    static Hero gareen = new Hero();
    static Hero teemo = new Hero();
    static Hero bh = new Hero();
    static Hero leesin = new Hero();

    public static void init() {
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
    }

    /**
     * 不使用多线程
     */
    @Test
    public void main() {
        init();
//        盖伦攻击提莫
        while (!teemo.isDead()) {
            gareen.attackHero(teemo);
        }
        System.out.println("adsfa");

        //赏金猎人攻击盲僧
        while (!leesin.isDead()) {
            bh.attackHero(leesin);
        }
    }

    /**
     * 继承Thread 使用多线程进行攻击
     */
    @Test
    public void main2() {
        KillThread killThread1 = new KillThread(gareen, teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh, leesin);
        killThread2.start();
        try {
            Thread.sleep(10000);//在测试方法中 测试方法结束所有的线程全部结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现Runnable接口 使用多线程进行攻击
     */
    @Test
    public void main3() {
        init();
        Battle battle1 = new Battle(gareen, teemo);
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();
        try {
            Thread.sleep(10000);//在测试方法中 测试方法结束所有的线程全部结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码
     * 匿名类的一个好处是可以很方便的访问外部的局部变量。
     * 前提是外部的局部变量需要被声明为final。(JDK7以后就不需要了)
     */
    @Test
    public void main4() {
        init();
        //匿名类
        Thread t1= new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
        try {
            Thread.sleep(10000);//在测试方法中 测试方法结束所有的线程全部结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
