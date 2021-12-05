package com.company;

public class PayLess extends Promotion{
    public PayLess(Data startDate, Data finalDate) {
        super(startDate, finalDate);
    }

    @Override
    public double calculaDesconto(double unitprice , int count) {
        double price=0;
        int i=1;
        if(count==1) return unitprice;
        else {
            while ( i<=count){
                if(0.05*(i-1)<=0.5){
                    price +=unitprice-unitprice*0.05*(i-1);
                }
                else price +=unitprice-unitprice*0.50;
                i++;
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + "PayLess";
    }
}
