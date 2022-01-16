package edu.cscc;/*
   Chapter 3       Debugging Assignment
   Programmer: Randy Chu, Phil Miele, Katie Dotson
   Date:2/1/2018
   Program Name:   Bert,java
   Purpose: debugging car loan program.
*/

import java.util.Scanner;

public class Bert {
    public static void main(String[] args) {
        //Declaring Variables
        int price, downPayment, tradeIn, months, loanAmt;
        double annualInterest, payment, interest;
        String custName;
        Scanner input = new Scanner(System.in);

        //Get Input from User
        System.out.print("What is your name?  ");
        custName = input.next();
        System.out.println();
        System.out.print("What is the price of the car?  ");
        price = input.nextInt();
        System.out.println();
        System.out.print("What is the downpayment?  ");
        downPayment = input.nextInt();
        System.out.println();
        System.out.print("What is the trade-in value?  ");
        tradeIn = input.nextInt();
        System.out.println();
        System.out.print("For how many months is the loan?  ");
        months = input.nextInt();
        System.out.println();
        System.out.print("What is the decimal interest rate?  ");
        annualInterest = input.nextDouble();
        System.out.println();


        //Calculations
        interest = annualInterest / 12;
        loanAmt = price - downPayment - tradeIn;


        payment = (loanAmt / ((1 / interest) - (1 / (interest * Math.pow(1 + interest, months)))));

        //Output
        System.out.print("The monthly payment for " + custName + " is $");
        System.out.println((int) payment);
    }
}