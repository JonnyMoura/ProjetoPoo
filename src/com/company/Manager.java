package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Manager {
    private ArrayList<Product> p;
    private ArrayList<Client> c;


    public static void main(String[] args) {
        Data d = new Data(10, 12, 2020);
        Data d1 = new Data(12, 12, 2020);
        Data d2 = new Data(11, 12, 2020);
        PayLess pro = new PayLess(d, d1);
        ThreeTakeFour pra = new ThreeTakeFour(d, d1);
        Food p = new Food(12345, "banana", 1, 12, pro, 12, 12);
        Furniture f = new Furniture(123, "cadeira", 1, 10, 15, 10);
        Cleaning pq = new Cleaning(1234, "limpador", 1, 12, pra, 8);
        Manager m = new Manager();
        Client cli = new Client("luisao", "cu de judas", "luisao@gmail.com", d, true);
        m.p.add(p);
        m.p.add(pq);
        m.p.add(f);
        Sales sal = new Sales(12, cli, d2);
        sal.setP(f);
        sal.setP(p);
        sal.setP(p);
        sal.setP(p);
        sal.setP(p);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);
        sal.setP(pq);

        System.out.println(sal);
        m.c.add(cli);

        Client b = m.login();
        Sales s1=m.buy(b, d);
        b.setS(sal);
        m.consultSales(b);



    }

    public Manager() {
        p = new ArrayList<>();
        c = new ArrayList<>();


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





    public Client login() {
        System.out.println("Insert email \n");
        Scanner sc = new Scanner(System.in);
        String em = sc.nextLine();
        for (Client i : c) {
            if ((i.getEmail()).equals(em)) {
                System.out.println("Success!You have logged in\n");
                return i;


            } else if (!((i.getEmail()).equals(em)) || c.isEmpty()) {
                System.out.println("Email not found!\n");
                login();
            }
        }
        return null;
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

    public double saleprice(Data d) {
        double salepriceaux = 0;
        int auxi = 0;
        ArrayList<Product> aux = new ArrayList<>(p);
        for (Product prod : p) {
            for (int i = 0; aux.size() > i; i++) {
                if (prod.getId() == aux.get(i).getId()) {
                    auxi++;
                    aux.remove(i);
                    i--;
                }
            }
            if (prod.getProm() == null) {
                salepriceaux += prod.getUnitPrice() * auxi;
            } else {
                if (!verifyData(d, prod.getProm().getStartDate()) && verifyData(d, prod.getProm().getFinalDate())) {
                    salepriceaux += prod.getProm().calculaDesconto(prod.getUnitPrice(), auxi);
                } else salepriceaux += prod.getUnitPrice() * auxi;
            }
            auxi = 0;
        }
        return salepriceaux;
    }

    public Sales buy(Client b, Data d) {
        ArrayList<Product> prod = new ArrayList<>();
        int option;
        do {
            System.out.println("Available products:\n");
            for (Product i : p) {
                System.out.println(i.toString());
            }
            System.out.println("Select the product you wish to buy");
            Scanner nc = new Scanner(System.in);
            String pr = nc.nextLine();
            System.out.println("How many units?");
            Scanner mc = new Scanner(System.in);
            while (!mc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                mc.next();
            }
            int units = mc.nextInt();
            int aux = 0;
            for (Product i : p) {
                if ((i.getName().equals(pr)) && i.getStock() > 0) {
                    aux += 1;
                    System.out.println("Succesfully added to the cart! \n");
                    i.setStock(i.getStock() - units);
                    Product cpy = i.copy();
                    cpy.setStock(0);
                    prod.add(cpy);


                }
            }
            if (aux == 1) {
                for (Product j : prod) {
                    if (pr.equals(j.getName())) {
                        j.setStock(j.getStock()+units);
                    }
                }
            }


            else {
                System.out.println("Product not available or out of stock!\n");


            }
            System.out.println("Your cart until this moment:\n");
            for (Product i : prod) {
                System.out.println(i.toString());
            }
            System.out.println("Insert -1 to finish buying or any number to continue \n");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                sc.next();
            }
            option = sc.nextInt();

        } while (option != -1);
        Sales s = new Sales(saleprice(d), b, d);
        System.out.println("Your purchase:\n");
        System.out.println(s);
        return new Sales(saleprice(d), b, d);


    }


    public void consultSales(Client c) {
        for (Sales s : c.getS()) {
            System.out.println(s);
        }
    }


    private double dimensionCalc() {
        return 0;
    }
}
