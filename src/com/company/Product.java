package com.company;

import java.io.Serializable;

/**
 * Abstract superclass Product represents any kind of product. It has three subclasses: Furniture,Cleaning and Food.
 * This class has 5 attributes: integer id(product identifier); String name(product name); double unitPrice(price of each product unit);stock(units available);prom(promotion attached to product)
 * Methods: copy(),costExtra()
 */
public abstract class Product implements Serializable {
//Attributes


    protected int id;
    protected String name;
    protected double unitPrice;
    protected int stock;
    protected Promotion prom;

//Constructors
    /**
     * Generates a new Product object.
     *
     * @param id product identifier
     * @param name product name
     * @param unitPrice product price for unit
     * @param stock available product stock
     * @param prom product promotion
     */
    public Product(int id, String name, double unitPrice, int stock, Promotion prom) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.prom = prom;
    }

    /**
     * Generates a new Product object without prom parameter
     * @param id product identifier
     * @param name product name
     * @param unitPrice product price for unit
     * @param stock available product stock
     */
    public Product(int id, String name, double unitPrice, int stock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    /**
     * This copy constructor generates a new Product object based on the attributes of another object. It will be used on buy(Client b, Data d)
     * on class Manager.
     *
     * @param another new product object
     */
    public Product(Product another) {
        this.id = another.id;
        this.name = another.name;
        this.unitPrice = another.unitPrice;
        this.stock = another.stock;
        this.prom = another.prom;
    }
//Methods
    /**
     * Returns attribute id
     *
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Sets attribute id
     *
     * @param id product identifier
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns attribute unitPrice
     *
     * @return unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets attribute unitPrice
     *
     * @param unitPrice product price for unit
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Returns attribute stock
     *
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets attribute stock
     *
     * @param stock available product stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Returns attribute prom
     *
     * @return prom
     */
    public Promotion getProm() {
        return prom;
    }

    /**
     * Sets attribute prom
     *
     * @param prom product promotion
     */
    public void setProm(Promotion prom) {
        this.prom = prom;
    }

    /**
     * abstract method costExtra(). Will be defined on subclasses Furniture, Food and Cleaning.
     * Calculates the extra cost if the product type is Furniture.
     *
     * @return integer value
     */
    public abstract int costExtra();

    /**
     * Abstract method copy(). It generates a copy of a given object based on the copy constructor.
     * It will be defined on subclasses Furniture, Food and Cleaning.
     *
     * @return new Object
     */
    public abstract Product copy();

    @Override
    /**
     * Returns Product attributes as a String.
     */
    public String toString() {
        return "Name=" + name +
                ", UnitPrice=" + unitPrice +
                ", stock= " + stock +
                ", prom= "+ prom;
    }


}
