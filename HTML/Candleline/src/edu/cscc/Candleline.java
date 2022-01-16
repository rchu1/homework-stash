package edu.cscc;


import java.util.Scanner;

public class Candleline {

    public static void main(String[] args) {
        double candleCost, shippingCost;
        int shippingType;
        candleCost = getCandleCost();
        shippingType = getShippingType();
        shippingCost = getShippingCost(candleCost, shippingType);
        output(candleCost, shippingCost);
    }

    private static double getCandleCost() {
        String cost;
        double temp = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the cost of the candle order:");
            cost = input.nextLine();
            try {
                temp = Double.parseDouble(cost);
            } catch (NumberFormatException e) {
                System.out.print("Error, enter a dollar amount grater then 0\n");
                continue;
            }
            if (temp <= 0) {
                System.out.print("Error, enter a dollar amount grater then 0\n");
                continue;
            }
            break;
        }
        return temp;
    }

    private static int getShippingType() {
        String type;
        int temp;
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the type of shipping: \n1) Priority (Overnight)\n2) Express (2 business days)\n3) Standard (3 to 7 business days)");
            type = input.nextLine();
            try {
                temp = Integer.parseInt(type);
            } catch (NumberFormatException e) {
                System.out.print("Error, enter a 1,2,or 3");
                continue;
            }
            if (temp > 4 || temp < 0) {
                System.out.print("Error, enter a 1,2,or 3");
                continue;
            }
            break;
        }
        return temp;
    }

    private static double getShippingCost(double CandleCost, int ShippingType) {
        double answer=0;

        switch (ShippingType) {
            case 1:
                answer= 16.95;

                break;
            case 2:
                answer =13.59;
                break;
            case 3:
                answer = 7.95;
                break;
        }
        if (CandleCost >= 100 || ShippingType == 3) {
            answer =0;
        }
        return answer;
    }

    public static void output(double candleCost, double shippingCost) {

        System.out.printf("The candle cost of $%,.2f plus shipping costs of $%,.2f equals $%,.2f", candleCost, shippingCost, candleCost+shippingCost);
    }
}