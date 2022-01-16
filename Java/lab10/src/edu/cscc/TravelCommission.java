package edu.cscc;

import java.text.DecimalFormat;
import java.util.Scanner;
// Name:Randy Chu
//Date:4/12/18
//Program: using try catch methods
public class TravelCommission {

    public static void main(String[] args) {
        int empCd;
        double dollar, answer;
        dollar = getSales();
        empCd = getCode();
        answer = getComm(dollar, empCd);
        output(dollar, answer);


    }

    private static double getSales() {
        String dollar;
        double temp = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the sales amount \n(do not use commas or dollar signs or enter any number lower then 0 to exit)\n");
            dollar = input.nextLine();
            try {
                temp = Double.parseDouble(dollar);
            } catch (NumberFormatException e) {
                System.out.print("Error enter a number greater then 0\n");
                continue;
            }
            if (temp < 0) {
                System.exit(0);
            }

            break;
        }
        return temp;
    }

    private static double getComm(double dollar, int empCd) {
        double answer = 0;
        switch (empCd) {
            case 1:
                answer = dollar * .10;
                break;
            case 2:
                answer = dollar * .14;
                break;
            case 3:
                answer = dollar * .18;
        }
        return answer;
    }

    private static int getCode() {
        Scanner input = new Scanner(System.in);
        String empCd = null;
        int temp = 0;
        while (true) {
            System.out.print("Enter the commission code: \n 1) Telephone Sales \n 2)In-Store Sales \n 3)Outside Sales \n");
            empCd = input.nextLine();
            try {
                temp = Integer.parseInt(empCd);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a 1,2,or 3");
                continue;
            }
            if (temp > 4 || temp < 0) {
                System.out.print("Please enter a 1,2,or 3");
                continue;
            }
            break;
        }
        return temp;
    }

    public static void output(double dollar, double answer) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.printf("Your commission on sales of " + df.format(dollar) + " is  " + df.format(answer));

    }
}


