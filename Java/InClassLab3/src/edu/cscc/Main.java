package edu.cscc;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/*
 * Name: Katie Dotson, Phil Miele, Randy Chu
 * Purpose: Hash user passwords
 * Date: 3/29/18
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] users = { "admin", "alice", "bob" };
        // Passwords - ShinyDiamond5, LuckyNumber3, AngryEagle7 (Don't include comments like this in real programs)
        String[] hashedPasswords = { "41683D2CCB5E93A59ED410CDF30962322E0123CCD3E0D3E9BAF046FA14A470A9",
                "8A67B76015EDA80CD99E3B42B27301F4B1C6DFC36006D95B0C466DBEF2394DBC",
                "8592CA9CED9BF301455E5D34FC2AD7E5DCCE7BF0D53787C1988CEC74CC449DEC"
        };
        String[] roles = {"admin", "manager", "user"};
        String user, password, hashedPassword;
        String errorString = "User ID or password does not match";
        int userIndex;

        while(true) {
            System.out.println("Enter user ID: ");
            user = input.nextLine();
            if(user.equalsIgnoreCase("quit")) {
                break;
            }
            System.out.println("Enter password: ");
            password = input.nextLine();


            userIndex = lookupUser(user, users);
            hashedPassword = hashPassword(password);

            if(userIndex == -1) {
                System.out.println(errorString);
            }
            else{
                if(hashedPasswords[userIndex].equals(hashedPassword)) {
                    System.out.println("User "+user+" has role "+roles[userIndex]);
                }
                else {
                    System.out.println(errorString);
                }
            }


        }
    }

    // Convert password to hexadecimal encoded SHA-256 hash
    public static String hashPassword(String password) {
        byte[] hash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        } catch(NoSuchAlgorithmException e) {
            System.out.println("SHA-256 algorithm is not available!");
            e.printStackTrace();
            System.exit(-1);
        }

        return javax.xml.bind.DatatypeConverter.printHexBinary(hash);
    }

    // Return index of user in users array
    // Return -1 if user is not in the array;
    public static int lookupUser(String user, String[] users) {
        int userIndex = -1;
        for(int i = 0; i < users.length; i++) {
            if(users[i].equalsIgnoreCase(user)) {
                userIndex = i;
            }
        }
        return userIndex;
    }
}