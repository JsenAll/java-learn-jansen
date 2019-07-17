package main.MultiThread.study2.jointest;

/**
 * @Description: 类作用描述:      地址链接:
 * @Author: JHS
 * @CreateDate: 2019/7/16 11:54
 * @UpdateDate: 2019/7/16 11:54
 * @UpdateRemark: 修改内容
 */
public class JoinTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "-------------" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                JoinTest jt = new JoinTest();
                jt.start();
                jt.join();
            }
            System.out.println(i + "-------------" + Thread.currentThread().getName());

        }

    }
}
