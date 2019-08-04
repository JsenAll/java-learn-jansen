package main.MultiThread;

public class CustomerThread extends Thread {
    private Product product;

    public CustomerThread(Product product) {
        this.product = product;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            product.getProduct();

//            synchronized ("啊实打实"){
//
//            }
        }

    }
}
