package SupplyChainManager;

import java.io.IOException;

class Product extends Good{
    private int quantity;

    public Product(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product(" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ')';
    }
}