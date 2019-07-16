package main.MultiThread.study2;

public class Rabbit extends Thread {
    public Rabbit(String name) {
        super.setName(name);

    }

    @Override
    public void run() {
        while (true) {
            System.out.println("我是" + this.currentThread().getName() + ":My Priority:" + this.getPriority());
        }

    }
}
