package main.MultiThread.study4ThreadPool.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 类作用描述:可缓存
 * @Author: JHS
 * @CreateDate: 2019/7/15 11:20
 * @UpdateDate: 2019/7/15 11:20
 * @UpdateRemark: 修改内容
 */
public class TestCached {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });

        }
        es.shutdown();
    }

}
