package org.example;

import java.util.Arrays;

public class BigOComplexityTasks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseIntArray(new int []{1})));
    }

    //Create function that calcs sum and product of all elements of given array
    public static int getSandP(int [] array) {
        int sum = 0;
        int prod = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            sum += array[i];
            prod *= array[i];
        }
        return sum + prod;
    }

    //print all pairs from the array
    public static void printPairs(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i] + "" + arr[j] + " ");
            }
            System.out.println();
        }
    }

    //reverse array
    public static int[] reverseIntArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < arr.length/2; i++) {
            int buffer = arr[start];
            arr[i] = arr[end];
            arr[end] = buffer;
            start++;
            end--;
        }
        return arr;
    }
}
