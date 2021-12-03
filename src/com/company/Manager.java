package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    private ArrayList<Product> p;
    private ArrayList<Client> c;
    private ArrayList<Sales> s;

    public static void main(String[] args) {
        Manager mg= new Manager();
        Data d=new Data(10,12,2020);
        Data d1=new Data(12,12,2020);
        Data d2=new Data(11,12,2020);
        PayLess pro=new PayLess(d,d1);
        ThreeTakeFour pra =new ThreeTakeFour(d,d1);
        Food p = new Food(12345,"banana",1,12,pro,12,12);
        Furniture f =new Furniture(123,"cadeira",1,10,15,10);
        Cleaning pq = new Cleaning(1234,"banana",1,12,pra,8);
        Manager m=new Manager();
        Client cli = new Client("luisao","cu de judas","luisao@gmail.com",d,true);
        m.p.add(p);
        //m.p.add(p);
        //m.p.add(pq);
        Sales s=new Sales(12, cli, d2);
        s.setP(f);
        s.setP(p);
        s.setP(p);
        s.setP(p);
        s.setP(p);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);
        s.setP(pq);

        System.out.println(s);
        mg.c.add(cli);
        Client b=mg.login();
        mg.buy(b,d);


    }

    public Manager() {
        p = new ArrayList<>();
        c = new ArrayList<>();
        s = new ArrayList<>();

    }

    public ArrayList<Product> getP() {
        return p;
    }

    public void setP(ArrayList<Product> p) {
        this.p = p;
    }

    public ArrayList<Client> getC() {
        return c;
    }

    public void setC(ArrayList<Client> c) {
        this.c = c;
    }

    public ArrayList<Sales> getS() {
        return s;
    }

    public void setS(ArrayList<Sales> s) {
        this.s = s;
    }

    public Client login() {
        System.out.println("Insert email \n");
        Scanner sc = new Scanner(System.in);
        String em= sc.nextLine();
        for(Client i: c) {
            if((i.getEmail()).equals(em)){
                System.out.println("Success!You have logged in\n");
                return i;




            }
            else if(!((i.getEmail()).equals(em)) || c.isEmpty()){
                System.out.println("Email not found!\n");
            }
        }
        return null;
        }



    private void showProducts(ArrayList<Product> prod){
        for(Product i:prod){
            System.out.println("Item:"+i.getName()+" Available Stock:"+i.getStock()+" Unit price:"+i.getUnitPrice()+"Promotion:"+ i.getProm());
        }

    }

    public boolean verifyData(Data dtsale, Data dtcomp) {
        if (dtsale.getYear() < dtcomp.getYear()) {
            return true;
        } else if (dtsale.getYear() == dtcomp.getYear() && dtsale.getMonth() < dtcomp.getMonth()) {
            return true;
        } else {
            return (dtsale.getYear() == dtcomp.getYear() && dtsale.getMonth() == dtcomp.getMonth() && dtsale.getDay() <= dtcomp.getDay());
        }
    }
    public double saleprice(Data d){
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
                if(!verifyData(d,prod.getProm().getStartDate()) &&verifyData(d,prod.getProm().getFinalDate())){
                    salepriceaux += prod.getProm().calculaDesconto(prod.getUnitPrice(), auxi);
                }
                else salepriceaux +=prod.getUnitPrice()*auxi;
            }
            auxi=0;
        }
        return salepriceaux;
    }

    public Sales buy(Client b, Data d) {
        ArrayList<Product> prod = new ArrayList<>();
        int option;
        do {
            System.out.println("Available products:\n");
            showProducts(p);
            System.out.println("Select the product you wish to buy");
            Scanner nc = new Scanner(System.in);
            String pr = nc.nextLine();
            for (Product i : p) {
                if (Objects.equals(i.getName(), pr) && i.getStock() >= 0) {
                    p.add(i);
                    i.setStock(i.getStock() - 1);

                } else {
                    System.out.println("Product not available or out of stock!\n");
                }
            }
            System.out.println("Your cart until this moment:\n");
            showProducts(prod);
            System.out.println("Insert -1 to finish buying or any number to continue \n");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                sc.next();
            }
            option = sc.nextInt();

        } while (option != -1);
        Sales s= new Sales(saleprice(d), b, d);
        System.out.println("Your purchase:\n");
        System.out.println(s.toString());
        return new Sales(saleprice(d), b, d);



    }



    public void consultSales() {

    }




    private double dimensionCalc(){
        return 0;
    }
}
