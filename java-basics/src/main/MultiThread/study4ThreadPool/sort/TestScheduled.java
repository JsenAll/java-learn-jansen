package main.MultiThread.study4ThreadPool.sort;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 类作用描述:定时线程池
 * @Author: JHS
 * @CreateDate: 2019/7/15 11:20
 * @UpdateDate: 2019/7/15 11:20
 * @UpdateRemark: 修改内容
 */
public class TestScheduled {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            ses.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }, 3, TimeUnit.SECONDS);
        }
        ses.shutdown();

    }
}
