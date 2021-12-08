package com.company;

/**
 * Subclass ThreeTakeFour of promotion.
 * Methods: calculateDiscount(double unitPrice, int count)
 */
public class ThreeTakeFour extends Promotion {
    //Attributes
    public ThreeTakeFour(Data startDate, Data finalDate) {
        super(startDate, finalDate);
    }

    @Override
    /**
     * Calculates the discount when this promotion is applied. For every 4 products of the same type bought the customer only pays 3 of them.
     * @param unitPrice
     * @param count
     * @return unitPrice*(double) (count-count/4);
     */

//Methods
    public double calculateDiscount(double unitPrice, int count) {
        return unitPrice * (double) (count - count / 4); /// it pays only three for every 4 products bought. integer count-counts units bought
    }

    @Override
    /**
     * Returns ThreeTakeFour attributes as a String.
     */
    public String toString() {
        return super.toString() +
                "ThreeTakeFour";
    }
}
