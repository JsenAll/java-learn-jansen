package main.MultiThread;

import com.oracle.jrockit.jfr.Producer;

public class Product {
    private String brand;//品牌
    private String name;//名字
   static boolean flag = false;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public  synchronized void getProduct() {
//        System.out.println("消费前1"+ flag);
        if (flag == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("消费前2"+ flag);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "消费了" + this.toString());
        flag = false;
//        System.out.println("消费厚" + flag);

        notify();
    }

    public synchronized void setProduct(String brand, String name) {
        if (flag == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.setName(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setBrand(brand);
        System.out.println("生产了" + this.toString());
        flag = true;
        notifyAll();
    }
}
