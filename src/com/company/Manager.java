package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    private ArrayList<Product> p;
    private ArrayList<Client> c;
    private ArrayList<Promotion> pro;

    public static void main(String[] args) {
        Manager m = new Manager();
        m.readFile("promotion.txt");
        m.readFile("producs.txt");
        m.readFile("clients.txt");
        m.writeProducs(m.p, new File("producs.obj"));
        m.writePromotions(m.pro, new File("promotions.obj"));
        m.writeClients(m.c, new File("clients.obj"));
        m.pro = m.readPromotion(new File("promotions.obj"));
        m.p = m.readProducs(new File("producs.obj"));
        m.c = m.readClients(new File("clients.obj"));
        m.menu();


    }

    public Manager() {
        p = new ArrayList<>();
        c = new ArrayList<>();
        pro = new ArrayList<>();

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

    public void readFile(String file) {
        File f = new File(file);
        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String[] split;
                String line;
                while ((line = br.readLine()) != null) {
                    split = line.split(";");
                    if (split[0].equals("Client")) {
                        String[] splitdata = split[4].split("/");
                        Data d = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        Client cl = new Client(split[1], split[2], split[3], d, Boolean.parseBoolean(split[5]));
                        c.add(cl);
                    } else if (split[0].equals("Promotion")) {
                        String[] splitdata;
                        splitdata = split[2].split("/");
                        Data d1 = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        splitdata = split[3].split("/");
                        Data d2 = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        if (split[1].equals("PayLess")) {
                            PayLess pl = new PayLess(d1, d2);
                            pro.add(pl);
                        } else {
                            ThreeTakeFour ttf = new ThreeTakeFour(d1, d2);
                            pro.add(ttf);
                        }
                    } else {
                        if (split[1].equals("Food")) {
                            Food fd;
                            if (!(split[6].equals(""))) {
                                fd = new Food(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            } else {
                                fd = new Food(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            }
                            p.add(fd);
                        } else if (split[1].equals("Cleaning")) {
                            Cleaning cl;
                            if (!(split[6].equals(""))) {
                                cl = new Cleaning(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Integer.parseInt(split[7]));
                            } else {
                                cl = new Cleaning(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Integer.parseInt(split[7]));
                            }
                            p.add(cl);
                        } else {
                            Furniture fur;
                            if (!(split[6].equals(""))) {
                                fur = new Furniture(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            } else {
                                fur = new Furniture(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            }
                            p.add(fur);
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }

    public void writeProducs(ArrayList<Product> produtos, File ficheiro) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ficheiro));
            oos.writeObject(produtos);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao ler ou criar ficheiro ");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar o objeto no ficheiro");
        }
    }

    public void writePromotions(ArrayList<Promotion> promotions, File fich) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
            oos.writeObject(promotions);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao ler ou criar ficheiro ");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar o objeto no ficheiro");
        }
    }

    public void writeClients(ArrayList<Client> clients, File fich) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
            oos.writeObject(clients);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao ler ou criar ficheiro ");
        } catch (IOException ex) {
            System.out.println("Erro ao gravar o objeto no ficheiro");
        }
    }

    public ArrayList<Product> readProducs(File ficheiro) {
        ArrayList<Product> produtos = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ficheiro));
            produtos = (ArrayList<Product>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return produtos;
    }

    public ArrayList<Promotion> readPromotion(File fich) {
        ArrayList<Promotion> promotions = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
            promotions = (ArrayList<Promotion>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return promotions;
    }

    public ArrayList<Client> readClients(File fich) {
        ArrayList<Client> clients = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
            clients = (ArrayList<Client>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return clients;
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

    public double saleprice(ArrayList<Product> products, Data d) {
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
            System.out.println("Available products:");
            System.out.println("==================================================");
            for (Product i : p) {
                System.out.println(i);
            }
            System.out.println("===================================================");
            System.out.println("Select the product you wish to buy");
            Scanner nc = new Scanner(System.in);
            String pr = nc.nextLine();
            System.out.println("How many units?");
            int units;
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
                if ((i.getName().equalsIgnoreCase(pr)) && i.getStock() > 0 && i.getStock() >= units) {
                    aux += 1;
                    System.out.println("Succesfully added to the cart! ");
                    i.setStock(i.getStock() - units);
                    Product cpy = i.copy();
                    cpy.setStock(units);
                    prod.add(cpy);


                }
            }
            if (aux == 1) {
                for (Product j : prod) {
                    if (pr.equals(j.getName())) {
                        j.setStock(units);
                    }
                }
            } else {
                System.out.println("Product not available or out of stock!");


            }
            System.out.println("Your cart until this moment:");
            System.out.println("=============================================");
            for (Product i : prod) {
                System.out.println(i);
            }
            System.out.println("=============================================");
            System.out.println("Insert -1 to finish buying or any number to continue ");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                sc.next();
            }
            option = sc.nextInt();

        } while (option != -1);
        System.out.println(prod);
        Sales s = new Sales(prod, saleprice(prod, d), b, d);
        System.out.println("Your purchase:\n");
        System.out.println(s);
        return s;


    }


    public void consultSales(Client c) {
        for (Sales s : c.getS()) {
            System.out.println(s);
        }
    }

    private Data changeDate() {
        System.out.println("Insert day:");

        Scanner dc = new Scanner(System.in);
        while (!dc.hasNextInt()) {//checks if the input is an integer
            System.out.println("Invalid data\nInsert number");
            dc.next();
        }
        int day = dc.nextInt();

        System.out.println("Insert month");

        Scanner mc = new Scanner(System.in);
        while (!mc.hasNextInt()) {
            System.out.println("Invalid data\nInsert number");
            mc.next();
        }

        int month = mc.nextInt();

        System.out.println("Insert year");

        Scanner yc = new Scanner(System.in);
        while (!yc.hasNextInt()) {
            System.out.println("Invalid data\nInsert number");
            yc.next();
        }
        int year = yc.nextInt();

        return new Data(day, month, year);
    }


    public void menu() {
        Data d = changeDate();
        Client b = login();
        int n;

        do {
            System.out.println("=============================MENU==========================");
            System.out.println("1 -Make a purchase");
            System.out.println("2 -View made purchases");
            System.out.println("3-Change current date");
            System.out.println("Any number-Exit");
            System.out.println("===========================================================");
            Scanner sc = new Scanner(System.in);
            while (!sc.hasNextInt()) {//checks if the input is an integer
                System.out.println("Invalid data\nInsert number");
                sc.next();
            }
            n = sc.nextInt();


            switch (n) {
                case 1 -> {
                    Sales m = buy(b, d);
                    b.addS(m);

                }

                case 2 -> consultSales(b);
                case 3 -> d = changeDate();


            }
        } while (n == 1 || n == 2 || n == 3);
        writeProducs(p, new File("producs.obj"));
        writePromotions(pro, new File("promotions.obj"));
        writeClients(c, new File("clients.obj"));
        System.exit(0);
    }
}