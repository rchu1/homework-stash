package edu.cscc;
import edu.cscc.car;

import java.util.Scanner;
// name: Randy Chu
// Date: 3/27/2018
// about: to use classes to make a car demo

public class CarDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String make;
        int year;

        System.out.print("Enter the make of the car: ");
        make = input.nextLine();
        while (make.equals(null)|| make.equals(""))
        {
            System.out.print("Input Error - enter the make of the car." + "\n" );
            System.out.print("Enter the make of the car: ");
            make = input.nextLine();
        }

        System.out.print("Enter the year of the car: ");
            year = input.nextInt();

        if (year < 1940 || year >2016) {
            System.out.println("Enter the year between the year 1940 to 2016: ");
            year = input.nextInt();
        }
        car Mycar = new car(make,year);

        System.out.println("Model Year: " + Mycar.getYearMake());
        System.out.println("Model:  \t" + Mycar.getMake());
        System.out.println("Speed: \t \t" + Mycar.getSpeed());

        System.out.println("Speed Up!");
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Demo car speed: "+ Mycar.accelerate());
        }
        System.out.println("Slow Down!");
        for (int i = 1; i <= 5; ++i) {
            System.out.println("Demo car speed: "+ Mycar.brake());
        }
        System.out.println("End of the road for the Car Class Demostration");
    }
}