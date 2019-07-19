package main.MultiThread;

public class CustomerThread extends Thread {
    private Product product;

    public CustomerThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("消费了" + product.toString());

        }
    }
}
