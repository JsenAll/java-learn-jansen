package main.MultiThread.study2.prioritytest;

public class Tortoise extends Thread {
    public Tortoise(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("我是" + this.currentThread().getName() + ":My Priority:" + this.getPriority());
        }
    }

}
