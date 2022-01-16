package edu.cscc;

import java.text.NumberFormat;
import java.util.Scanner;

//Names: Randy Chu, Phil Miele, Katie Dotson

//Date: 4/19/18

//Calculate tuition and fees

public class Tuition {

    public static void main(String[] args) {
        int hours;
        double tuition, fees, rate;
        System.out.println("        Tuition calculator");
        System.out.println();
        hours = getHours();
        rate = getRate(hours);
        tuition = calcTuition(hours, rate);
        fees = calcFees(tuition);
        displayTotal(tuition, fees);
    }

    private static int getHours() {
        Scanner input = new Scanner(System.in);
        String hours;
        int temp;
        while (true) {
            System.out.print("Enter the number of credit hours: \n");
            hours = input.nextLine();
            try {
                temp = Integer.parseInt(hours);
                if (temp <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Error, enter an integer grater than 0 \n");
                continue;
            }
            break;
        }
        return temp;

    }

    private static double getRate(int hours) {
        double rate = 0;
        if (hours > 15) {
            rate = 45;
        } else {
            rate = 55;
        }
        return rate;
    }

    private static double calcTuition(int hours, double rate) {

        double tuition = hours * rate;
        return tuition;
    }

    private static double calcFees(double tuition) {
        double fees = tuition * 0.08;
        return fees;
    }

    private static void displayTotal(double tuition, double fees) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String tuitionString = formatter.format(tuition);
        String feesString = formatter.format(fees);
        String totalString = formatter.format(fees + tuition);
        System.out.printf("The tuition cost of " + tuitionString + " plus fees of " + feesString + " equals " + totalString);
    }

}




