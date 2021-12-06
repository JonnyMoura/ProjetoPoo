package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class Sales represents every sale made by the store(a purchase by the customer), it has direct interaction with class Client, since every pruchase is associated with a client,
 * with class Product since every purchase is made of one or multiple products and class Data since one of the attributes is the date of sale.
 * It has 4 attributes: ArrayList<Product> p(list of purchased items); double salePrice(price of the various products), Client client(client who made the purchase) and Data saledate(date when the purchase was made).
 * Methods: transportCost(), addP()
 */
public class Sales implements Serializable {
    private ArrayList<Product> p;
    private double salePrice;
    private Client client;
    private Data saleDate;

    /**
     * Generates a new Client object.
     *
     * @param p
     * @param salePrice
     * @param client
     * @param saledate
     */
    public Sales(ArrayList<Product> p, double salePrice, Client client, Data saledate) {
        this.client = client;
        this.p = p;
        this.salePrice = salePrice;
        this.saleDate = saledate;
    }

    /**
     * Returns attribute p
     *
     * @return p
     */
    public ArrayList<Product> getP() {
        return p;
    }

    public void setP(ArrayList<Product> p) {
        this.p = p;
    }

    /**
     * Returns attribute salePrice
     *
     * @return salePrice
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Sets attribute salePrice
     *
     * @param salePrice
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Returns attribute client
     *
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets attribute client
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Returns attribute saleDate
     *
     * @return
     */
    public Data getSaleDate() {
        return saleDate;
    }

    /**
     * Sets attribute saleDate
     *
     * @param saleDate
     */
    public void setSaleDate(Data saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * Calculates the transport cost of the sale, if a customer is a frequent one he will pay only 20, if the sale costs less then 40 while an regular one will pay 20 in every circumstance
     *
     * @return transport cost
     */
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

    /**
     * adds a product to the product ArrayList associated with the sale.
     *
     * @param prod
     */
    public void addP(Product prod) {
        p.add(prod);
    }

    @Override
    /**
     * Returns Sales attributes as a String.
     */
    public String toString() {
        return "Sale:\n" +
                "Products purchased=" + p + "\n" +
                "salePrice-->" + salePrice + "\n" +
                "transportcost -->" + transportCost() + "\n" +
                "Client=" + client.getName() + "\n" +
                "saledate=" + saleDate + "\n";
    }

}


