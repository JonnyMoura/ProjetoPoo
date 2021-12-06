package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Sales represents every sale made by the store(a purchase by the customer), it has direct interaction with class Client, since
 */
public class Sales implements Serializable {
    private ArrayList<Product> p;
    private double salePrice;
    private Client client;
    private Data saledate;

    public Sales(ArrayList<Product> p, double salePrice, Client client, Data saledate) {
        this.client = client;
        this.p = p;
        this.salePrice = salePrice;
        this.saledate = saledate;
    }

    public void setP(Product prod) {
        p.add(prod);
    }

    public ArrayList<Product> getP() {
        return p;
    }

    public Data getSaledate() {
        return saledate;
    }

    public void setSaledate(Data saledate) {
        this.saledate = saledate;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }


    public int transportCost() {
        int transportcost = 0;
        if (client.isFrequentClient()) {
            if (salePrice <= 40) {
                transportcost += 15;
            } else {
                transportcost += 0;
            }
        } else {
            transportcost += 20;
        }
        return transportcost;
    }


    @Override
    public String toString() {
        return "Sale:\n" +
                "Products purchased=" + p + "\n" +
                "salePrice-->" + salePrice + "\n" +
                "transportcost -->" + transportCost() + "\n" +
                "Client=" + client.getName() + "\n" +
                "saledate=" + saledate + "\n";
    }

}


