package com.company;
import java.util.ArrayList;

public class Client {
    private String name;
    private String address;
    private String email;
    private Data birthDate;
    private boolean frequentClient;
    final private ArrayList<Sales> s;

    public Client(String name, String address, String email, Data birthDate, boolean frequentClient) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
        this.frequentClient = frequentClient;
        s = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Data birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isFrequentClient() {
        return frequentClient;
    }

    public void setFrequentClient(boolean frequentClient) {
        this.frequentClient = frequentClient;
    }

    public ArrayList<Sales> getS() {
        return s;
    }

    public void setS(Sales sal) {
        s.add(sal);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", frequentClient=" + frequentClient +
                ", s=" +s+
                '}';
    }
}
