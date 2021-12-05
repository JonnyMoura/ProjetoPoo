package com.company;

public class Cleaning extends Product {
    private int tox;

    public Cleaning(int id, String name, double unitPrice, int stock, Promotion prom, int tox) {
        super(id, name, unitPrice, stock, prom);
        this.tox = tox;
    }
    public Cleaning(int id, String name, double unitPrice, int stock, int tox) {
        super(id, name, unitPrice, stock);
        this.tox = tox;
    }

    public Cleaning(Cleaning another){
        super(another);
       this.tox = another.tox;

   }

    public int getTox() {
        return tox;
    }

    public void setTox(int tox) {
        this.tox = tox;
    }

    @Override
    public String toString() {
        return "Cleaning product---->" +
                super.toString() +
                ", tox=" + tox;
    }

    @Override


    public int costextra(){
        return 0;
    }

    @Override
    public Product copy(){
        return new Cleaning (this);
    }
}
