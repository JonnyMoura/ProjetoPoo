package com.company;

public class Furniture extends Product {
    private double weight;
    private double dim;

    public Furniture(int id, String name, double unitPrice, int stock, double weight, double dim) {
        super(id, name, unitPrice, stock);
        this.weight = weight;
        this.dim = dim;
    }

    public Furniture(int id, String name, double unitPrice, int stock, Promotion prom, double weight, double dim) {
        super(id, name, unitPrice, stock, prom);
        this.weight = weight;
        this.dim = dim;
    }

    public Furniture(Furniture another){
        super(another);
        this.weight = another.weight;
        this.dim = another.dim;


    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDim() {
        return dim;
    }

    public void setDim(double dim) {
        this.dim = dim;
    }

    public String toString() {
        return "Furniture Product--->" +
                super.toString() +
                ", weight=" + weight +
                ", dim=" + dim;
    }

    @Override


    public int costextra(){
        if(weight>=15)return 10;
        else return 0;
    }

    @Override
    public Product copy(){
        return new Furniture(this);

    }
}
