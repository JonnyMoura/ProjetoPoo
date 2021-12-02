package com.company;
import java.util.ArrayList;

public class Sales {
    private ArrayList<Product> p;
    private int salePrice;
    private Client client;
    private Data saledate;

    public Sales(int salePrice, Client client, Data saledate) {
        this.client = client;
        p= new ArrayList<>();
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

    public int getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(int salePrice) {
        this.salePrice = salePrice;
    }
    public double saleprice(){
        double salepriceaux=0;
        int auxi=0;
        ArrayList<Product> aux=new ArrayList<>(p);
        for (Product prod:p) {
            for (int i=0;aux.size()>i;i++) {
                if(prod.getId()== aux.get(i).getId()) {
                    auxi++;
                    aux.remove(i);
                    i--;
                }
            }
            if (prod.getProm() == null) {
                salepriceaux +=prod.getUnitPrice()*auxi;
            }
            else{
                if(!verifyData(saledate,prod.getProm().getStartDate()) &&verifyData(saledate,prod.getProm().getFinalDate())){
                    salepriceaux += prod.getProm().calculaDesconto(prod.getUnitPrice(), auxi);
                }
                else salepriceaux +=prod.getUnitPrice()*auxi;
            }
            auxi=0;
        }
        return salepriceaux;
    }

    public int  transportCost(){
        int transportcost=0;
        for (Product i : p){
            //if(i.getDim()!=0){
            //transportcost +=i.costextra();}

        }
        if (client.isFrequentClient()) {
            if(saleprice()<=40){
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

    private boolean verifyData(Data dtsale, Data dtcomp) {
        if (dtsale.getYear() < dtcomp.getYear()) {
            return true;
        } else if (dtsale.getYear() == dtcomp.getYear() && dtsale.getMonth() < dtcomp.getMonth()) {
            return true;
        } else {
            return (dtsale.getYear() == dtcomp.getYear() && dtsale.getMonth() == dtcomp.getMonth() && dtsale.getDay() <= dtcomp.getDay());
        }
    }

    @Override
    public String toString() {
        return "Sales{" +
                "p=" + p+ "\n"+
                "salePrice -->"+saleprice()+"\n"+
                "transportcost -->"+ transportCost()+"\n"+
                "client=" + client +"\n"+
                "saledate=" + saledate +"\n"+
                '}';
    }

}


