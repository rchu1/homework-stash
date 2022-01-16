// ===================================
// Columbus State Community College
// CSCI 2469 - Spring Semester 2018
// Assignment: Final Exam
// Programmer: Craig Wright
// ===================================


package edu.cscc.csci2469.finalexam.util;


import java.util.Scanner;


/**
 * Provides simple input from the console
 */
public class ConsoleReader {
    /**
     * Holds instance of the scanner
     */
    private Scanner scanner;


    /**
     * Constructor.
     */
    public ConsoleReader() {
        super();
        scanner = new Scanner(System.in);
    }


    /**
     * Reads the port number from System.in and validate it.
     *
     * @param prompt prompt string to be used
     * @return the supplied port number (after conversion to binary)
     */
    public int getPortNumber(final String prompt) {
        while (true) {
            int portNumber = getInteger(prompt);
            if (portNumber < 0 || portNumber > 65535) {
                System.out.println("\n** Invalid port number - must be between 0 and 65535 **\n");
                System.out.flush();
            } else {
                return (portNumber);
            }
        }
    }


    /**
     * Reads an integer from System.in and validates it.
     * 
     * @param prompt prompt string to be used
     * @return the supplied integer (after conversion to binary)
     */
    public int getInteger(final String prompt) {
        while (true) {
            String input = getString(prompt);
            try {
                int number = Integer.parseInt(input);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("\n** Invalid integer **\n");
                System.out.flush();
            }
        }
    }


    /**
     * Reads a string from System.in and returns it to the caller.
     * 
     * @param prompt prompt string to be used
     * @return string read from System.in (leading/trailing spaces have been trimmed)
     */
    public String getString(final String prompt) {
        System.out.print(prompt);
        System.out.flush();
        String input = scanner.nextLine().trim();
        return input;
    }
}
