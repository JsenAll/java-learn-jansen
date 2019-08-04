package main.MultiThread;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product();
        CustomerThread customerThread = new CustomerThread(product);
        customerThread.setName("消费者1");
        customerThread.start();

        CustomerThread customerThread2 = new CustomerThread(product);
        customerThread2.setName("消费者2");
        customerThread2.start();

        ProducerThread producerThread = new ProducerThread(product);
        producerThread.start();
    }
}
