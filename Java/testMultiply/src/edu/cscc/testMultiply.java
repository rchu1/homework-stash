package edu.cscc;

/*
   CSCI2467        Final
   Programmer:	   Keyser Soze
   Date:           4/26/18
   Program Name:   TestMultiply.java
*/

import java.util.Scanner;

public class testMultiply {

    public static void main(String[] args) {
        //Declaring variables
        int multiplier;
        double correct;


        //Opening messages
        System.out.println("\t\tWelcome to the Multiplication Quiz");
        System.out.println("");

        //Calling the user-defined methods
        multiplier = getNumber();
        correct = takeQuiz(multiplier);
        System.out.println("\t\tYou got " + correct + " correct!");

    }

    public static int getNumber() {
        //Declaring variables

        Scanner input = new Scanner(System.in);
        String multiplier;
        int temp;


        //Get a value from user
        while (true) {
            System.out.print("Enter the multiplication table you wish to practice:  ");
            multiplier = input.nextLine();
            System.out.println();
            try {
                temp = Integer.parseInt(multiplier);
            } catch (NumberFormatException e) {
                System.out.print("Error - Enter an integer\n");
                continue;
            }
            break;
        }


        //Return a value to main
        return temp;

    }

    public static int takeQuiz(int multiplier) {
        //Delcaring variablaes

        String answer;
        int temp;
        int count = 0;
        int correct = 0;

        Scanner input = new Scanner(System.in);


        while (count <= 12) {


            //Display question and get answer
            while (true) {
                System.out.println("What is " + count + " times " + multiplier + "?");

                answer = input.nextLine();
                try {
                    temp = Integer.parseInt(answer);
                } catch (NumberFormatException e) {
                    System.out.print("Error, enter in an integer\n");
                    continue;
                }
                break;
            }

            if (temp == count * multiplier) {
                System.out.println("\tCorrect!");
                correct = correct + 1;
            } else {
                System.out.println("\tIncorrect");
            }

            count = count + 1;


        }

        return correct;
    }
}


