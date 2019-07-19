package main.MultiThread;

public class ProducerThread extends Thread {
    private Product product;

    public ProducerThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                product.setBrand("");
                product.setName("");
            } else {
                product.setBrand("");
                product.setName("");
            }

        }
        System.out.println("生产了" + product.toString());
    }
}
