package com.company;

/**
 * Subclass of Product Food
 * It represents objects of the type Food which has two different attributes from its superclass: double nCalorie(food number of calories)
 * and double fatPercent(percentage of fat)
 * Methods: copy(),costExtra()
 */
public class Food extends Product {
    //Attributes
    private double nCalorie;
    private double fatPercent;

    /**
     * Generates a new Food object.
     *
     * @param id         product identifier
     * @param name       product name
     * @param unitPrice  product price for unit
     * @param stock      available product stock
     * @param prom       product promotion
     * @param nCalorie   number of calories
     * @param fatPercent fat percentage
     */
// Constructors
    public Food(int id, String name, double unitPrice, int stock, Promotion prom, double nCalorie, double fatPercent) {
        super(id, name, unitPrice, stock, prom);
        this.nCalorie = nCalorie;
        this.fatPercent = fatPercent;
    }

    /**
     * Generates a new Food object without prom parameter
     *
     * @param id         product identifier
     * @param name       product name
     * @param unitPrice  product price for unit
     * @param stock      available product stock
     * @param nCalorie   number of calories
     * @param fatPercent fat percentage
     */
    public Food(int id, String name, double unitPrice, int stock, double nCalorie, double fatPercent) {
        super(id, name, unitPrice, stock);
        this.nCalorie = nCalorie;
        this.fatPercent = fatPercent;
    }

    /**
     * This copy constructor generates a new Food object based on the attributes of another object. It will be used on buy(Client b, Data d)
     * on class Manager.
     *
     * @param another new Food object
     */
    public Food(Food another) {
        super(another);
        this.nCalorie = another.nCalorie;
        this.fatPercent = another.fatPercent;

    }
//Methods

    /**
     * Returns attribute nCalorie
     *
     * @return nCalorie
     */
    public double getnCalorie() {
        return nCalorie;
    }

    /**
     * Sets attribute nCalorie
     *
     * @param nCalorie number of calories
     */
    public void setnCalorie(double nCalorie) {
        this.nCalorie = nCalorie;
    }

    /**
     * Returns attribute fatPercent
     *
     * @return fatPercent
     */
    public double getFatPercent() {
        return fatPercent;
    }

    /**
     * Sets attribute fatPercent
     *
     * @param fatPercent fat percentage
     */
    public void setFatPercent(double fatPercent) {
        this.fatPercent = fatPercent;
    }

    @Override
    /**
     * Returns Food attributes as a String.
     */
    public String toString() {
        return "Food Product--->" +
                super.toString() +
                ", nCalorie=" + nCalorie +
                ", fatPercent=" + fatPercent;
    }

    @Override
    /**
     * Implementation of costExtra. This product isn´t of type Furniture so it will return 0
     * @return 0
     */
    public int costExtra() {
        return 0;
    }

    @Override
    /**
     * Returns new Food object based on the copy constructor. It will generate a copy of a given object.
     * @return new Food Object
     */
    public Product copy() {
        return new Food(this);
    }


}


