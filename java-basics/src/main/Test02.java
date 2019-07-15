package main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * BlockingQueue 阻塞队列
 * add() 往队列中添加数据
 * 当队列满了,再往里面添加则会爆出异常 Queue full
 * offer()  往里面添加数据
 * bq.offer("oracle",3, TimeUnit.SECONDS); //三秒 添加不了就不添加了
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new LinkedBlockingQueue<String>(3);
        bq.offer("java");
        bq.offer("html");
        bq.offer("css");
        bq.offer("oracle", 3, TimeUnit.SECONDS); //三秒 添加不了就不添加了
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());

    }
}
