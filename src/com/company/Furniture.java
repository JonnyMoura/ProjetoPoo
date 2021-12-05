package com.company;

/**
 * Subclass of Product Furniture
 * It represents objects of the type Furniture which has two different attributes from its superclass: double weight(product weight) and String dim(dimension of product(heightxwidthxlength))
 * Methods: copy(),costExtra()
 */
public class Furniture extends Product {
    private double weight;
    private String dim;

    /**
     * Generates a new Furniture object.
     *
     * @param id
     * @param name
     * @param unitPrice
     * @param stock
     * @param prom
     * @param weight
     * @param dim
     */
    public Furniture(int id, String name, double unitPrice, int stock, Promotion prom, double weight, String dim) {
        super(id, name, unitPrice, stock, prom);
        this.weight = weight;
        this.dim = dim;
    }

    /**
     * This copy constructor generates a new Furniture object based on the attributes of another object. It will be used on buy(Client b, Data d)
     * on class Manager.
     *
     * @param another
     */
    public Furniture(Furniture another) {
        super(another);
        this.weight = another.weight;
        this.dim = another.dim;


    }

    /**
     * Returns attribute weight
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets attribute weight
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns attribute dim
     *
     * @return dim
     */
    public String getDim() {
        return dim;
    }

    /**
     * Sets attribute dim
     *
     * @param dim
     */
    public void setDim(String dim) {
        this.dim = dim;
    }

    /**
     * Returns Furniture attributes as a String.
     */
    public String toString() {
        return "Furniture Product--->" +
                super.toString() +
                ", weight=" + weight +
                ", dim=" + dim;
    }

    @Override
    /**
     * Returns the extra price the product(type furniture only) will cost if its weight is over 15
     * @return 10 or 0
     */
    public int costExtra() {
        if (weight >= 15) return 10;
        else return 0;
    }

    @Override
    /**
     * Returns new Funiture object based on the copy constructor. It will generate a copy of a given object.
     * @return new Furniture Object
     */
    public Product copy() {
        return new Furniture(this);

    }
}
