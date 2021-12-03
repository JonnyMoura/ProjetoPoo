package com.company;

public abstract class Product  {
    private int id;
    private String name;
    private double unitPrice;
    private int stock;
    private Promotion prom;

    public Product(int id, String name, double unitPrice,int stock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
    public Product(Product another){
        this.id = another.id;
        this.name = another.name;
        this.unitPrice = another.unitPrice;
        this.stock = another.stock;
    }

    public Product(int id, String name, double unitPrice, int stock, Promotion prom) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.prom = prom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Promotion getProm() {
        return prom;
    }

    public void setProm(Promotion prom) {
        this.prom = prom;
    }


    public abstract int costextra();
    public abstract Product copy();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", stock=" + stock +
                ", prom=" + prom +
                '}';
    }


}
