package edu.cscc;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import edu.cscc.MyBubbleSort;
/*
 * Test drvier for extra credit sorting assignment
 */
public class TestSort {
    private static final String CENSUSNAMESURL =
            "https://www2.census.gov/topics/genealogy/1990surnames/dist.all.last";

    public static String[] someNames = {"Liang", "Eckels", "Schildt", "Farrell"};

    public static void main(String[] args) {
        Date d1, d2;

        // Sort short list of names with Bubble sort
        System.out.println("*** First Sort ***");
        MyBubbleSort.sort(someNames);
        for (String n : someNames) {
            System.out.println(n);
        }

        // Get list of 25,000 unsorted last names from web & make a copy
        String[] censusLastNames = getUsLastNames(25000);
        System.out.println("Got "+censusLastNames.length+" last names");
        String[] censusLastNames2 = Arrays.copyOf(censusLastNames,censusLastNames.length);

        // Sort census names with Bubble sort
        System.out.println("*** Second Sort ***");
        report("Before Sort",censusLastNames);
        d1 = new Date();
        MyBubbleSort.sort(censusLastNames);
        d2 = new Date();
        System.out.println("Sort took "+(d2.getTime()-d1.getTime())+" milliseconds");
        report("After Sort",censusLastNames);

        // Sort second unsorted list of census names with Java's built-in sort
        System.out.println("\n*** Third Sort ***");
        report("Before Sort",censusLastNames2);
        d1 = new Date();
        Arrays.sort(censusLastNames2);
        d2 = new Date();
        System.out.println("Sort took "+(d2.getTime()-d1.getTime())+" milliseconds");
        report("After Sort",censusLastNames2);

        // Verify both sorts produced the same results
        if (Arrays.equals(censusLastNames, censusLastNames2))
            System.out.println("Both sorts produced same results");
        else
            System.out.println("Both sorts did not produced same results");
    }

    // Get array of names from Census bureau
    public static String[] getUsLastNames(int maxNames) {
        ArrayList nameList = new ArrayList<String>();

        try {
            URL url = new URL(CENSUSNAMESURL);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            Scanner input = new Scanner(con.getInputStream());

            for (int i=1; i<=maxNames && input.hasNext(); i++) {
                String name = input.next();
                String other = input.nextLine();
                nameList.add(name);
            }

            con.getInputStream().close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        return (String[])nameList.toArray(new String[nameList.size()]);
    }


    public static void report(String message,String[] list) {
        System.out.println("--- "+message+" ---\nThis list has "+list.length+" elements");
        System.out.println("First five sorted names");
        for (int i=0; i<5; ++i) {
            System.out.print(list[i]+"  ");
        }
        System.out.println("\nLast five sorted names");
        int sz = list.length;
        for (int i=sz-6; i<sz; ++i) {
            System.out.print(list[i]+"  ");
        }
        System.out.print("\n");
    }

}
