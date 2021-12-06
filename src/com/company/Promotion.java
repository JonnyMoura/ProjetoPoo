package com.company;

import java.io.Serializable;

/**
 * Abstract Class Promotion. Represents every promotion every product can have. It interacts directly with class Data, since every promotion is limiteed to a certain time period
 * It has two subclasses:PayLess and ThreeTakeFour.
 * It has 2 attributes: Data startDate(beginning of the promotion) and Data finalDate(promotion ending)
 * Methods: calculateDiscount(double unitPrice, int count)
 */
public abstract class Promotion implements Serializable {
    //Attributes
    private Data startDate;
    private Data finalDate;

//Constructors

    /**
     * Generates a new Promotion object.
     *
     * @param startDate start of the promotion
     * @param finalDate end of promotion
     */
    public Promotion(Data startDate, Data finalDate) {
        this.startDate = startDate;
        this.finalDate = finalDate;
    }
//Methods

    /**
     * Returns attribute startDate
     *
     * @return startDate
     */
    public Data getStartDate() {
        return startDate;
    }

    /**
     * Sets attribute startDate
     *
     * @param startDate start of the promotion
     */
    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    /**
     * Returns attribute finalDate
     *
     * @return finalDate
     */
    public Data getFinalDate() {
        return finalDate;
    }

    /**
     * Sets attribute finalDate
     *
     * @param finalDate end of promotion
     */
    public void setFinalDate(Data finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * Abstract method calculateDiscount. Returns the value of the discount according to Promotion applied to given Product
     * It will be defined on subclasses: PayLess and ThreeTakeFour
     *
     * @param unitPrice price of each unit
     * @param count     number of units
     * @return double
     */
    public abstract double calculateDiscount(double unitPrice, int count);

    @Override
    /**
     * Returns Promotion attributes as a String.
     */
    public String toString() {
        return "Promotion--->";
    }
}
