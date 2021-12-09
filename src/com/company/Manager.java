package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Manager. It interacts directly with class Client, Product and Promotion managing interactions among them. It also handles operation with loading and writing on the database text and object files that contain information about available products,clients and promotions.
 * Manages three operations available to users: login, to make a new purchase and how to consult made purchases.
 * It has 3 attributes: ArrayList <Product> p(manages every product available on the store), ArrayList <Client> c(manages every client registered on the store) and ArrayList<Promotion> prom(every promotion the store offers).
 * Methods: loadData(String fClients, String fProducts, String fPromotions); readFile(String file); writeObj(File file); readObj(File file); login(); verifyData(Data dtSale, Data dtComp); salePrice(ArrayList<Product> products, Data d); buy(Client b, Data d);
 * consultSales(Client c); changeDate(); menu()
 */
public class Manager {
    //Attributes
    private ArrayList<Product> p;
    private ArrayList<Client> c;
    private ArrayList<Promotion> pro;


//Constructors

    /**
     * Generates a new Manager object.
     */
    public Manager() {
        p = new ArrayList<>();
        c = new ArrayList<>();
        pro = new ArrayList<>();
    }
//Methods

    /**
     * Main method, runs program application code
     */
    public static void main(String[] args) {
        Manager m = new Manager();
        m.loadData("Clients.obj", "Products.obj", "Promotions.obj");
        m.menu();
    }

    /**
     * Returns attribute p
     *
     * @return p
     */
    public ArrayList<Product> getP() {
        return p;
    }

    /**
     * Sets attribute p
     *
     * @param p products available on store ArrayList
     */
    public void setP(ArrayList<Product> p) {
        this.p = p;
    }

    /**
     * Returns attribute c
     *
     * @return c
     */
    public ArrayList<Client> getC() {
        return c;
    }

    /**
     * Sets attribute c
     *
     * @param c clients registered on store ArrayList
     */
    public void setC(ArrayList<Client> c) {
        this.c = c;
    }

    /**
     * Loads data into program from text files or object files. If it's the first time running the program it will load the needed data from the text files into matching ArrayList. Every other time loads from object file.
     *
     * @param fClients    name of the client object file
     * @param fProducts   name of the product object file
     * @param fPromotions name of the Promotions object file
     */
    public void loadData(String fClients, String fProducts, String fPromotions) {
        File fC = new File(fClients);
        File fP = new File(fProducts);
        File fPro = new File(fPromotions);
        if (fC.exists() && fP.exists() && fPro.exists()) {///checks if object files were already created
            readObj(fC);
            readObj(fP);
            readObj(fPro);

        } else {///reads from text files
            readFile("Clients.txt");
            readFile("Promotions.txt");
            readFile("Products.txt");
        }
    }

    /**
     * Reads text files and loads data into matching ArrayList
     *
     * @param file name of the text file to be read
     */
    private void readFile(String file) {
        File f = new File(file);
        if (f.exists() && f.isFile()) {// checks if file exists
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String[] split;
                String line;
                while ((line = br.readLine()) != null) { // while there's still lines to read
                    split = line.split(";");
                    if (split[0].equals("Client")) {// if the first string is 'client' it means it´s reading client info from text file
                        String[] splitdata = split[4].split("/");
                        Data d = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        Client cl = new Client(split[1], split[2], split[3], d, Boolean.parseBoolean(split[5]));
                        c.add(cl);
                    } else if (split[0].equals("Promotion")) {// if the first string is 'Promotion' it means it´s reading promotion info from text file
                        String[] splitdata; //promotion date
                        splitdata = split[2].split("/");
                        Data d1 = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        splitdata = split[3].split("/");
                        Data d2 = new Data(Integer.parseInt(splitdata[0]), Integer.parseInt(splitdata[1]), Integer.parseInt(splitdata[2]));
                        if (split[1].equals("PayLess")) { //if the second string is "PayLess" it means the Promotion PayLess
                            PayLess pl = new PayLess(d1, d2);
                            pro.add(pl);
                        } else {
                            ThreeTakeFour ttf = new ThreeTakeFour(d1, d2);
                            pro.add(ttf);
                        }
                    } else {
                        if (split[1].equals("Food")) {// if the first string is 'Food' it means it´s reading Product(subtype Food) info from text file
                            Food fd;
                            if (!(split[6].equals(""))) {
                                fd = new Food(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            } else {
                                fd = new Food(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Double.parseDouble(split[7]), Double.parseDouble(split[8]));
                            }
                            p.add(fd);
                        } else if (split[1].equals("Cleaning")) {// if the first string is 'Cleaning' it means it´s reading Product(subtype Cleaning) info from text file
                            Cleaning cl;
                            if (!(split[6].equals(""))) {
                                cl = new Cleaning(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Integer.parseInt(split[7]));
                            } else {
                                cl = new Cleaning(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Integer.parseInt(split[7]));
                            }
                            p.add(cl);
                        } else {// It´s reading Furniture type Product from text file
                            Furniture fur;
                            if (!(split[6].equals(""))) {
                                fur = new Furniture(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        pro.get(Integer.parseInt(split[6])), Double.parseDouble(split[7]), split[8]);// Promotion parameter
                            } else {
                                fur = new Furniture(Integer.parseInt(split[2]), split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]),
                                        Double.parseDouble(split[7]), split[8]);// without promotion parameter
                            }
                            p.add(fur);
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Error opening text file.");
            } catch (IOException ex) {
                System.out.println("Error reading text file.");
            }
        } else {
            System.out.println("File doesn't exist.");
        }
    }

    /**
     * Writes from ArrayLists into object files
     *
     * @param file file in which objects will be written
     */
    private void writeObj(File file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            if (file.getName().equals("Clients.obj")) {
                oos.writeObject(c);
            } else if (file.getName().equals("Promotions.obj")) {
                oos.writeObject(pro);
            } else {
                oos.writeObject(p);
            }
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("Error writing into file!");
        }
    }

    /**
     * Reads an object file and loads into ArrayLists
     *
     * @param file object file to be read
     */
    private void readObj(File file) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ///loads each file into matching ArrayList
            if (file.getName().equals("Clients.obj")) {
                c = (ArrayList<Client>) ois.readObject();
            } else if (file.getName().equals("Promotions.obj")) {
                pro = (ArrayList<Promotion>) ois.readObject();
            } else {
                p = (ArrayList<Product>) ois.readObject();
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening file!");
        } catch (IOException ex) {
            System.out.println("Error reading file!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error converting file!");
        }
    }

    /**
     * Allows new users to signup
     *
     * @return new client who has signed up
     */
    private Client signUp() {
        System.out.println("Insert your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Insert your address:");
        Scanner nc = new Scanner(System.in);
        String address = nc.nextLine();
        System.out.println("Insert your email");
        Scanner mc = new Scanner(System.in);
        String email = mc.nextLine();
        System.out.println("Insert your birthDate");
        Data d = changeDate();
        return new Client(name, address, email, d, false);


    }

    /**
     * Enables user to login. User has to input email to check if user is on the ArrayList of registered users.
     *
     * @return client that has logged in
     */
    private Client login() {
        System.out.print("Insert email :");
        Scanner sc = new Scanner(System.in);
        String em = sc.nextLine();
        for (Client i : c) {
            if ((i.getEmail()).equals(em)) {///Check if user is already registered
                System.out.println("Success!You have logged in\n");
                return i;
            }
        }
        System.out.println("Email not found");
        System.out.println("Insert 1 if you wish to signup or any number to insert a different email!");
        int n;
        Scanner nc = new Scanner(System.in);
        while (!nc.hasNextInt()) {//checks if the input is an integer
            System.out.println("Invalid data\nInsert number");
            nc.next();
        }
        n = nc.nextInt();
        if (n == 1) {
            Client b = signUp();
            c.add(b);///adds new client to store
            return b;

        } else {

            return login();
        }
    }

    /**
     * Verifies if a first date argument is before the second one one
     *
     * @param dtSale first argument
     * @param dtComp second argument
     * @return true if first date<=second date
     */
    private boolean verifyData(Data dtSale, Data dtComp) {
        if (dtSale.getYear() < dtComp.getYear()) {
            return true;
        } else if (dtSale.getYear() == dtComp.getYear() && dtSale.getMonth() < dtComp.getMonth()) {
            return true;
        } else {
            return (dtSale.getYear() == dtComp.getYear() && dtSale.getMonth() == dtComp.getMonth() && dtSale.getDay() <= dtComp.getDay());
        }
    }

    /**
     * Calculates the price of a sale cart(products bought)
     *
     * @param products products bought
     * @param d        date of the sale
     * @return double sale price
     */
    private double salePrice(ArrayList<Product> products, Data d) {
        double salePriceAux = 0;
        for (Product prod : products) {
            if (prod.getProm() == null) {// when there is no promotion to given product
                salePriceAux += prod.getUnitPrice() * prod.getStock();//price of each unit x units bought
            } else {
                if (!verifyData(d, prod.getProm().getStartDate()) && verifyData(d, prod.getProm().getFinalDate())) {//if there is promotions checks if promotions is still on
                    salePriceAux += prod.getProm().calculateDiscount(prod.getUnitPrice(), prod.getStock());
                } else salePriceAux += prod.getUnitPrice() * prod.getStock();
            }
        }
        return salePriceAux;
    }

    /**
     * Makes a new purchase for the new customer
     *
     * @param b customer who made the purchase
     * @param d date of the purchase
     * @return new Sale made by customer
     */
    private Sales buy(Client b, Data d) {
        ArrayList<Product> prod = new ArrayList<>();//temporary cart
        int option;
        do {
            System.out.println("Available products:");
            System.out.println("==================================================");
            for (Product i : p) {///prints available products
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
                if ((i.getName().equalsIgnoreCase(pr)) && i.getStock() > 0 && i.getStock() >= units) {///checks if products exists has available stock
                    aux += 1;
                    System.out.println("Succesfully added to the cart! ");
                    i.setStock(i.getStock() - units);//changes stock in store(Total units- units bought)
                    Product cpy = i.copy();
                    cpy.setStock(units);//copy of bought product with changed stock number(units bought by customer)
                    prod.add(cpy);


                }
            }
            if (aux == 1) {/// if the product was bought and already was in the cart it updates units bought
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
        Sales s = new Sales(prod, salePrice(prod, d), b, d);///finished shopping makes new sale
        System.out.println("Your purchase:\n");
        System.out.println(s);
        return s;

    }

    /**
     * Prints every purchase made
     *
     * @param c client to check Purchases
     */
    private void consultSales(Client c) {
        for (Sales s : c.getS()) {
            System.out.println(s);
        }
    }

    /**
     * Changes date
     *
     * @return new Date
     */
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

    /**
     * Manages user interaction. It manages three different options: make login, consult purchases and change current date.
     */
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
                    Sales m = buy(b, d);///Makes a new purchase
                    b.addS(m);

                }

                case 2 -> consultSales(b); //Makes consults purchases
                case 3 -> d = changeDate(); //Changes currrent date


            }
        } while (n == 1 || n == 2 || n == 3);
        writeObj(new File("Clients.obj"));
        writeObj(new File("Products.obj"));
        writeObj(new File("Promotions.obj"));
        System.exit(0);
    }
}