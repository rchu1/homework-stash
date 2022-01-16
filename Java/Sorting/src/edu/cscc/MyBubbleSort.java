package edu.cscc;




/*
 * Name: Randy Chu
 * Date: 4/11/2018
 * to sort in bubbles
 */
public class MyBubbleSort {

    public static void sort(String[] list) {
        // TODO - your implementation of Bubble Sort goes here
        String tempStr;
        for (int j = 0; j < list.length - 1; j++) {
           for (int i = 0; i < list.length - j-1; i++) {
                if (list[i].compareTo(list[i+1]) > 0) {
                    tempStr = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = tempStr;
                }
            }


        }
    }
}
