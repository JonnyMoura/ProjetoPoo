package com.company;

public class Cleaning extends Product {
    private int tox;

    public Cleaning(int id, String name, double unitPrice, int stock,int tox) {
        super(id, name, unitPrice, stock);
        this.tox = tox;
    }

    public Cleaning(int id, String name, double unitPrice, int stock, Promotion prom, int tox) {
        super(id, name, unitPrice, stock, prom);
        this.tox = tox;
    }

    public int getTox() {
        return tox;
    }

    public void setTox(int tox) {
        this.tox = tox;
    }

    @Override
    public String toString() {
        return "Cleaning{" +
                "tox=" + tox +
                "} " + super.toString();
    }

    @Override


    public int costextra(){
        return 0;
    }
}
