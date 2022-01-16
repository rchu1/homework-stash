package edu.cscc;
import java.util.Scanner;

import static edu.cscc.Main.average;
// Name Randy Chu
// Date 3/17/2018
//About; This program is the couclate the average and minmus while using arrays.
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter;
        int[] inArray = new int[10];
        double[] Darray = new double[10], Marray = new double[10];

        System.out.print("Enter 10 integer value: ");
        for (counter = 0; counter < 10; counter++) {
            inArray[counter] = input.nextInt();
        }
        int iN = average(inArray);
        System.out.printf("The average of the 10 integer is: " + iN + "\n");

        System.out.print("Enter 10 doubles value: ");
        for (counter = 0; counter < 10; counter++) {
            Darray[counter] = input.nextDouble();
        }
        double dN = average(Darray);
        System.out.printf("The average of the 10 doubles is: " + dN + "\n");


        System.out.print("Enter 10 doubles value: ");
        for (counter = 0; counter < 10; counter++) {
            Marray[counter] = input.nextDouble();
        }
        double mN = min(Marray);
        System.out.printf("The smallest element  is: " + mN);


    }


    public static int average(int[] inArray) {
        int temp = 0, temp2, sum = 0;
        for (int count = 0; count < 10; count++) {
            temp = sum += inArray[count];
        }

        temp2 = temp / 10;
        return temp2;
    }

    public static double average(double[] Darray) {
        double temp = 0, temp2, sum = 0;
        for (int count = 0; count < 10; count++) {
            temp = sum += Darray[count];

        }
        temp2 = temp / 10;

        return temp2;
    }

    public static double min(double[] Marray) {
        double low;
        low = Marray[0];
        for (int count = 1; count < 10; count++) {

            if (Marray[count] < low) {
                low = Marray[count];
            }

        }


        return low;
    }

}



