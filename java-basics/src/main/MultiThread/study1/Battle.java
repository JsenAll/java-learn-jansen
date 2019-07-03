package main.MultiThread.study1;

/**
 * 创建类Battle，实现Runnable接口
 * 启动的时候，首先创建一个Battle对象，然后再根据该battle对象创建一个线程对象，并启动
 * <p>
 * Battle battle1 = new Battle(gareen,teemo);
 * new Thread(battle1).start();
 * <p>
 * <p>
 * battle1 对象实现了Runnable接口，所以有run方法，但是直接调用run方法，并不会启动一个新的线程。
 * 必须，借助一个线程对象的start()方法，才会启动一个新的线程。
 * 所以，在创建Thread对象的时候，把battle1作为构造方法的参数传递进去，这个线程启动的时候，就会去执行battle1.run()方法了。
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }
}
