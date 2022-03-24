package org.example;
//0 1 1 2 3 5 8 13 21 34 55 89
public class Recursion {

    public static void main(String[] args) {
       //t1 System.out.println(power(2, 3));
       //t2 System.out.println(factorial(5));
        int[] arr = {22};
        //System.out.println(productofArray(arr, arr.length));
        // System.out.println(recursiveRange(2));
        //System.out.println(fib(7));
       // System.out.println(reverse("-1"));
        // t7 System.out.println(isPalindrome("aa"));
        //t8 System.out.println(someRecursive(arr, new OddFunction()));
        //T9 System.out.println(first("sdfsdfsS"));
        System.out.println(capitalizeWord("love you so much babe"));
    }
    //T10 Capitalise each word
    public static String capitalizeWord(String str){
        String[] arr = str.trim().split(" ");
        if (arr.length == 0) {
            return "";
        }
        if (arr.length == 1) {
            return arr[0].substring(0, 1).toUpperCase() + arr[0].substring(1);
        }
        String newOne = str.replaceFirst("(\\w+ )", "");
        return arr[0].substring(0, 1).toUpperCase() + arr[0].substring(1) + " " + capitalizeWord(newOne);
    }

    //t9 first Uppercase
    static char first(String str) {
        if (str.isEmpty()) {
            return "-".charAt(0);
        }
        char current = str.charAt(str.length() - 1);
        if (str.length() == 1) {
            return Character.isUpperCase(current)? current : "-".charAt(0);
        }
        if (Character.isUpperCase(current)) {
            return current;
        }
        return first(str.substring(0, str.length() - 1));
    }


    //t8 someCallback
    public static boolean someRecursive(int[] arr, OddFunction odd) {
            if (arr.length == 0) return false;
            if (odd.OddFunction(arr[arr.length - 1])) return true;
            int[] arr2 = new int[arr.length - 1];
        System.arraycopy(arr, 0, arr2, 0, arr.length - 1);
        return someRecursive(arr2, odd);
    }
    static class OddFunction {
        public boolean OddFunction(int num) {
            return num % 2 == 1;
        }
    }

    //t7 is palindrome
    public static boolean isPalindrome(String s)
    {
        if (s.length() < 2) return true;
        if (s.length() <= 3) {
            return s.substring((s.length() - 1)).equals(s.substring(0, 1));
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }
    //t6 reverse string
    public static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
     return str.substring(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }

    //t5 fib
    public static int fib(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //t4 recursive range
    public static int recursiveRange(int num) {
        if (num <= 0) {
            return num;
        }
        return num + recursiveRange(num - 1);
    }
    //t3 prod of arrray
    public static int productofArray(int A[], int N)
    {
        if (N < 0) {
            return -1;
        }
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return A[0];
        }
        return A[N - 1] * productofArray(A, N - 1);
    }

    //t2 factorial
    public static int factorial(int num) {
        if (num ==0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    //t1 power
        public static int power(int base, int exponent) {
            if (exponent < 0) {
                return -1;
            }
            if (exponent == 0) {
                return 1;
            }
            return base * power(base, --exponent);
        }
}
