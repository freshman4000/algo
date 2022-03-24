package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input number of days");
        int days = scanner.nextInt();
        int[]daysArray = new int[days];
        int sumOfTemps = 0;
        for (int i = 0; i < days; i++) {
            System.out.println("Please input temperature of the day " + (i + 1));
            daysArray[i] = scanner.nextInt();
            sumOfTemps += daysArray[i];
        }
        scanner.close();
        double averageTemp = (double)sumOfTemps / days;
        System.out.println("Average temperature for " + days + " days is " + averageTemp);
        int daysTempAboveAverage = 0;
        for (int temp : daysArray) {
            if (temp > averageTemp) {
                daysTempAboveAverage++;
            }
        }
        System.out.println("There were " + daysTempAboveAverage + " days above average temperature");
    }


}
