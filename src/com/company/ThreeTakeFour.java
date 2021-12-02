package com.company;


public class ThreeTakeFour extends Promotion {
    public ThreeTakeFour(Data startDate, Data finalDate) {
        super(startDate, finalDate);
    }

    @Override
    public double calculaDesconto(double unitprice , int count) {
        return unitprice*(count-count/4);
    }



}
