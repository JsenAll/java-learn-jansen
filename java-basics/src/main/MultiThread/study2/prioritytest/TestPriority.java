package main.MultiThread.study2.prioritytest;

public class TestPriority {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit("小白兔");
        rabbit.start();
        rabbit.setPriority(10);
        Tortoise tortoise = new Tortoise("小绿龟");
        tortoise.start();
    }
}
