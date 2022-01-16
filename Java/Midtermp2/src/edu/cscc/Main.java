package edu.cscc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int counter, quantity;


        System.out.print("Enter quantity of the Smartphones:  ");
        quantity = input.nextInt();
        int[] Price = new int[quantity];
        System.out.print("Enter all smartphone price: ");

        for (counter = 0; counter < quantity; counter++) {

            Price[counter] = input.nextInt();

        }
        Arrays.sort(Price);

        System.out.print("Three most expensive phone: \n");
        for (int i = 0 ; i < price.length-3; --i) {
                System.out.println(Price[i]);
              }

             System.out.print("Three Cheapest phone: \n");
        for (int i = 0; i < 3; i++) {
                System.out.println(Price[i]);
        }
    }
}



