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
        Client cli = new Client("luisao", "cu de judas", "l@g.c", d, true);
        m.p.add(p);
        m.p.add(pq);
        m.p.add(f);


        m.c.add(cli);

        Client b = m.login();
        Sales s1 = m.buy(b, d2);
        b.setS(s1);
        //System.out.println(s1);
        //m.consultSales(b);


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
        System.out.print("Insert email :");
        Scanner sc = new Scanner(System.in);
        String em = sc.nextLine();
        for (Client i : c) {
            if ((i.getEmail()).equals(em)) {
                System.out.println("Success!You have logged in\n");
                return i;
            }
        }
        System.out.println("Email not found");
        return login();
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

    public double saleprice(ArrayList<Product> products,Data d) {
        double salepriceaux = 0;
        for (Product prod : products) {
            if (prod.getProm() == null) {
                salepriceaux += prod.getUnitPrice() * prod.getStock();
            } else {
                if (!verifyData(d, prod.getProm().getStartDate()) && verifyData(d, prod.getProm().getFinalDate())) {
                    salepriceaux += prod.getProm().calculaDesconto(prod.getUnitPrice(), prod.getStock());
                } else salepriceaux += prod.getUnitPrice() * prod.getStock();
            }
        }
        return salepriceaux;
    }

    public Sales buy(Client b, Data d) {
        ArrayList<Product> prod = new ArrayList<>();
        int option;
        do {
            System.out.println("Available products:\n");
            for (Product i : p) {
                System.out.println(i);
            }
            System.out.println("Select the product you wish to buy");
            Scanner nc = new Scanner(System.in);
            String pr = nc.nextLine();
            System.out.println("How many units?");
            int units = 0;
            Scanner mc = new Scanner(System.in);
            do {
                while (!mc.hasNextInt()) {//checks if the input is an integer
                    System.out.println("Invalid data\nInsert number");
                    mc.next();
                }
                units = mc.nextInt();
                if (units <= 0) {
                    System.out.println("Enter a number >0");
                }
            } while (units <= 0);
            int aux = 0;
            for (Product i : p) {
                if ((i.getName().equals(pr)) && i.getStock() > 0) {
                    aux += 1;
                    System.out.println("Succesfully added to the cart! \n");
                    i.setStock(i.getStock() - units);
                    Product cpy = i.copy();
                    cpy.setStock(units);
                    prod.add(cpy);


                }
            }
            if (aux == 1) {
                for (Product j : prod) {
                    if (pr.equals(j.getName())) {
                        j.setStock( units);
                    }
                }
            } else {
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
        Sales s = new Sales(prod,saleprice(prod,d),b, d);
        System.out.println("Your purchase:\n");
        System.out.println(s);
        return s;


    }


    public void consultSales(Client c) {
        for (Sales s : c.getS()) {
            System.out.println(s);
        }
    }


    private double dimensionCalc(double height, double length, double width) {
        return (height * length * width);
    }

    public void menu(Data d) {
        Client b = login();
        int n;

        do {
            System.out.println("Select an option");
            System.out.println("1 -Make a purchase");
            System.out.println("2 -View made purchases");
            System.out.println("Any number-Exit");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                sc.next();
            }
            n = sc.nextInt();


            switch (n) {
                case 1 -> {
                    buy(b, d);


                }

                case 2 -> {
                    //consultSales(b)
                }


            }
        } while (n == 1 || n == 2);
        System.exit(0);
    }
}