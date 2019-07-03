package main.MultiThread.study1;

import org.junit.Test;

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

    //
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
     * 使用多线程进行攻击
     */
    @Test
    public void main2() {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        KillThread killThread1 = new KillThread(gareen,teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh,leesin);
        killThread2.start();
    }
}
