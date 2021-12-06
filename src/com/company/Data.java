package com.company;

import java.io.Serializable;

/**
 * Class Data
 * Stores a date on the format D/M/Y
 * Methods: validation()
 */
public class Data implements Serializable {
//Attributes

    private int day;
    private int month;
    private int year;

    //Constructor

    /**
     * Generates a new Data object.
     *
     * @param day   day DD
     * @param month month MM
     * @param year  year YY
     */
    public Data(int day, int month, int year) {
        if (validation(day, month, year) == 1) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
        }
    }

    //Methods

    /**
     * Returns attribute day
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets attribute day
     *
     * @param day day DD
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Returns attribute month
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets attribute month
     *
     * @param month MM
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Returns attribute year
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets attribute year
     *
     * @param year YY
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * tests if a given date is valid before initializing variables
     *
     * @param day-->   Day to test
     * @param month--> month to test
     * @param year-->  year to test
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
    /**
     * Returns Data attributes as a String.
     */
    public String toString() {
        return "Data{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
