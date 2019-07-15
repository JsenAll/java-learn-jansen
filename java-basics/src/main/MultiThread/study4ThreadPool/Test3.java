package main.MultiThread.study4ThreadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {
        ThreadPoolExecutor pool =
                new ThreadPoolExecutor(2, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
//        for (int i = 0; i <100 ; i++) {
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
        pool.execute(new Test03tt());
//        }


        pool.shutdown();

    }

    static class Test03tt implements Runnable {

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName());
        }
    }
}
