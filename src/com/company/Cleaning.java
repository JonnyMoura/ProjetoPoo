package com.company;

/**
 * Subclass of Product Cleaning
 * It represents objects of the type Furniture(cleaning products) which has one different attributes from its superclass: int tox(toxicity of a given product on a scale from 0 to 10)
 * Methods: copy(),costExtra()
 */
public class Cleaning extends Product {
    private int tox;

    /**
     * Generates a new Furniture object.
     *
     * @param id
     * @param name
     * @param unitPrice
     * @param stock
     * @param prom
     * @param tox
     */
    public Cleaning(int id, String name, double unitPrice, int stock, Promotion prom, int tox) {
        super(id, name, unitPrice, stock, prom);
        this.tox = tox;
    }

    public Cleaning(int id, String name, double unitPrice, int stock, int tox) {
        super(id, name, unitPrice, stock);
        this.tox = tox;
    }

    /**
     * This copy constructor generates a new Cleaning object based on the attributes of another object. It will be used on buy(Client b, Data d)
     * on class Manager.
     *
     * @param another
     */
    public Cleaning(Cleaning another) {
        super(another);
        this.tox = another.tox;

    }

    /**
     * Returns attribute tox
     *
     * @return tox
     */
    public int getTox() {
        return tox;
    }

    /**
     * Sets attribute tox
     *
     * @param tox
     */
    public void setTox(int tox) {
        this.tox = tox;
    }

    @Override
    /**
     * Returns Cleaning attributes as a String.
     */
    public String toString() {
        return "Cleaning product---->" +
                super.toString() +
                ", tox=" + tox;
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
     * Returns new Cleaning object based on the copy constructor. It will generate a copy of a given object.
     * @return new Cleaning Object
     */
    public Product copy() {
        return new Cleaning(this);
    }
}
