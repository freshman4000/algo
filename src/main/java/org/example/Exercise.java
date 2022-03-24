package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Exercise {
    public static void main(String[] args) {
        int arr[] = new int[]{100, 2, 7, 11, 15};
        //missingNumber(arr);
        //System.out.println(Arrays.toString(twoSum(arr, 9)));
        System.out.print(maxProduct(arr));
    }
    public static void missingNumber(int[] intArray) {
     int sum1 = 10 * (10 + 1) / 2;
     int sum2 = 0;
     for (int i : intArray) {
         sum2 += i;
     }
        System.out.println("Missing number is " + (sum1 - sum2));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
       outer: for (int i = 0; i < nums.length; i++) {
           for (int j = i + 1; j < nums.length; j++) {
               if (nums[i] + nums[j] == target) {
                   result[0] = i;
                   result[1] = j;
                   break outer;
               }
           }
        }
        return result;
    }
    public static String maxProduct(int[] intArray) {
        int maxProd = Integer.MIN_VALUE;
        String maxPair = "";
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] * intArray[j] > maxProd) {
                    maxProd = intArray[i] * intArray[j];
                    maxPair =  intArray[i] + "," + intArray[j];
                }
            }
        }
        return maxPair;
    }
}