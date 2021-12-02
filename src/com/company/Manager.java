package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    private ArrayList<Product> p;
    private ArrayList<Client> c;
    private ArrayList<Sales> s;

    public static void main(String[] args) {
        Data d=new Data(10,12,2020);
        Data d1=new Data(12,12,2020);
        Data d2=new Data(11,12,2020);
        PayLess pro=new PayLess(d,d1);
        ThreeTakeFour pra =new ThreeTakeFour(d,d1);
        Food p = new Food(12345,"banana",1,12,pro,12,12);
        Furniture f =new Furniture(123,"cadeira",1,10,15,10);
        Cleaning pq = new Cleaning(1234,"banana",1,12,pra,8);
        Manager m=new Manager();
        Client c = new Client("luisao","cu de judas","luisao@gmail.com",d,true);
        m.p.add(p);
        //m.p.add(p);
        //m.p.add(pq);
        Sales s=new Sales(12, c, d2);
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
        String email= sc.nextLine();
        for(Client i: c){
            if(Objects.equals(i.getEmail(), email)){
                System.out.println("Success!You have logged in");
                return i;




            }
            else{
                System.out.println("Email not found!");
            }
        }




        return null;

    }

    public Sales buy(Client b, Data d) {
        ArrayList<Product> p= new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int option;
        while (!sc.hasNextInt()) {//checks if the input is an integer
            System.out.println("Invalid data\nInsert number");
            sc.next();
        }
        option=sc.nextInt();
        System.out.println("Insert 0 to finish buying or 1 to start or continue \n");
       // while()
        switch(option){
            case 1:

                System.out.println("Select the product you wish to buy");
                Scanner nc= new Scanner(System.in);
                String prod= sc.nextLine();
                for( Product i:p){
                    if(Objects.equals(i.getName(), prod)  && i.getStock()!=0){
                        p.add(i);
                        i.setStock(i.getStock()-1);

                    }



                }
                break;
            case 0:
                //return new Sales(p,saleprice(),b,d);
                return new Sales(null,null,null);

        }


    }

    public void consultSales() {

    }




    private double dimensionCalc(){
        return 0;
    }
}
