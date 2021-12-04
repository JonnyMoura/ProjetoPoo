package com.company;
import java.util.ArrayList;

public class Sales {
    private ArrayList<Product> p;
    private double salePrice;
    private Client client;
    private Data saledate;

    public Sales( ArrayList<Product> p,double salePrice, Client client, Data saledate) {
        this.client = client;
        this.p=p;
        this.salePrice=salePrice;
        this.saledate=saledate;
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


    public int  transportCost(){
        int transportcost=0;
        for (Product i : p){
            //if(i.getDim()!=0){
            //transportcost +=i.costextra();}

        }
        if (client.isFrequentClient()) {
            if(salePrice<=40){
                transportcost+=15;
            }
            else {
                transportcost +=0;
            }
        }
        else{
            transportcost +=20;
        }
        return transportcost;
    }


    @Override
    public String toString() {
        return "Sales{" +
                "p=" + p+ "\n"+
                "salePrice -->"+salePrice+"\n"+
                "transportcost -->"+ transportCost()+"\n"+
                "client=" + client.getName() +"\n"+
                "saledate=" + saledate +"\n"+
                '}';
    }

}


