package com.company;
/**
 * Stores a date on the format D/M/Y
 *
 * @author joanm
 */
public class Data {
//Attributes

    private int day;
    private int month;
    private int year;

    //Constructor
    public Data(int day, int month, int year) {
        if (validation(day, month, year) == 1) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
        }
    }

    //Methods
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * tests if a given date is valid before initializing variables
     *
     * @param day--> Day to test
     * @param month--> month to test
     * @param year--> year to test
     * @return 0 if date is invalid, 1 if date is valid
     */
    private int validation(int day, int month, int year) {
        if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && month == 2 && (day > 28 || day <= 0)) {
            System.out.println("Error! Invalid date");
            return 0;

        } else if (month == 2 && (day > 29 || day <= 0)) {
            System.out.println("Error! Invalid date");
            return 0;

        } else if (day > 31 || day <= 0) {
            System.out.println("Error! Invalid date");
            return 0;
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 0 || day > 30)) {
            System.out.println("Error! Invalid date");
            return 0;
        }
        return 1;
    }


    @Override
    public String toString() {
        return "Data{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
