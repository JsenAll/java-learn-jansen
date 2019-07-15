package main.MultiThread.study4ThreadPool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Test01 {
    /**
     * ConcurrentLinkedQueue :非阻塞队列
     * poll()  出队并在队列中移除
     * peek()  出队,但不在队列中移除
     * size()  当前队列的大小
     *
     * @param args
     */
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();//无边界队列 没有长度限制
//        入队
        clq.add("java");
        clq.add("html");
        clq.add("css");
//        出队
        System.out.println(clq.poll());
        System.out.println(clq.size());
        System.out.println("-------------------");
        System.out.println(clq.peek());
        System.out.println(clq.size());


    }
}
