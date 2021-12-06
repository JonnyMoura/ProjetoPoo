package com.company;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class client. Represents every client that has interaction with the store. It interacts directly with class Sales, since every customer
 * has its own associated purchases and with class Data since every customer has a birthdate.
 * It has 6 attributes: String name(name of the customer);  String address(customer´s address); String email(customer´s email); Data birthDate(customer´s birthdate); boolean frequentClient(used to check if it is a frequent customer or a regular one, sine frequent will have different features available)
 * and ArrayList<Sales> s which represents every purchase the customer has done.
 * Methods: addS()
 */
public class Client implements Serializable {
// Attributes

    private String name;
    private String address;
    private String email;
    private Data birthDate;
    private boolean frequentClient;
    private ArrayList<Sales> s;


//Constructors

    /**
     * Generates a new Client object.
     *
     * @param name           client name
     * @param address        client address
     * @param email          client email
     * @param birthDate      client birthdate
     * @param frequentClient client frequentClient
     */
    public Client(String name, String address, String email, Data birthDate, boolean frequentClient) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.frequentClient = frequentClient;
        s = new ArrayList<>();
    }


//Methods


    /**
     * Returns attribute name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets attribute name
     *
     * @param name client name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns attribute address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets attribute address
     *
     * @param address client address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns attribute email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets attribute email
     *
     * @param email client email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns attribute birthDate
     *
     * @return birthDate
     */
    public Data getBirthDate() {
        return birthDate;
    }

    /**
     * Sets attribute birthDate
     *
     * @param birthDate client birthdate
     */
    public void setBirthDate(Data birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Returns attribute frequentClient
     *
     * @return frequentClient
     */
    public boolean isFrequentClient() {
        return frequentClient;
    }

    /**
     * Sets attribute frequentClient
     *
     * @param frequentClient if client is frequent
     */
    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    /**
     * Returns attribute s
     *
     * @return s
     */
    public ArrayList<Sales> getS() {
        return s;
    }

    /**
     * Sets attribute s
     *
     * @param s Sales ArrayList
     */
    public void setS(ArrayList<Sales> s) {
        this.s = s;
    }

    /**
     * Adds new Sales type object to attribute ArrayList s;
     *
     * @param sal Sale
     */
    public void addS(Sales sal) {
        s.add(sal);
    }

    @Override
    /**
     * Returns Client attributes as a String.
     */
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", frequentClient=" + frequentClient +
                ", s=" + s +
                '}';
    }
}
