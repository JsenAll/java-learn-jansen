package main.MultiThread;

public class Product {
    private String brand;//品牌
    private String name;//名字

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
}
