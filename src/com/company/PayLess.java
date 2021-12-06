package com.company;

/**
 * Subclass PayLess of promotion.
 * Methods: calculateDiscount(double unitPrice, int count)
 */
public class PayLess extends Promotion {
    //Attributes
    public PayLess(Data startDate, Data finalDate) {
        super(startDate, finalDate);
    }

    @Override
    /**
     * Calculates the discount when this promotion is applied. For every product of the same type bought it reduces 10% of the cost until it reaches 50% of the product value
     * @param unitPrice
     * @param count
     * @return price after discount if count >=1;
     */
//Methods
    public double calculateDiscount(double unitPrice, int count) {
        double price = 0;
        int i = 1;///product counter
        if (count == 1) return unitPrice;//// if there is only on product of given type
        else {
            while (i <= count) {
                if (0.05 * (i - 1) <= 0.5) { //// until  reaches 50% discount
                    price += unitPrice - unitPrice * 0.05 * (i - 1);
                } else price += unitPrice - unitPrice * 0.50;
                i++;
            }
        }
        return price;
    }

    @Override
    /**
     * Returns PayLess attributes as a String.
     */
    public String toString() {
        return super.toString() + "PayLess";
    }
}
