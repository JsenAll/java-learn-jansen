package main.MultiThread;

/**
 * 生产者
 */
public class ProducerThread extends Thread {
    private Product product;

    public ProducerThread(Product product) {
        this.product = product;
    }
    @Override
    public  void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                product.setProduct("好时", "巧克力");
            } else {
                product.setProduct("青岛", "啤酒");
            }
        }
    }
}
