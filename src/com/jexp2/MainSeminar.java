package com.jexp2;

import java.util.Arrays;
import java.util.Scanner;

public class MainSeminar {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        String[][] arr = new String[][]{
//                {"1","2","3","4","5"},
//                {"1","2","3","4","5"},
//                {"1","2","3","4","5"},
//                {"1","2","3","4","5"},
//                {"1","2","3","4","5"}
//        };
//        try {
//            int res = sum2(arr);
//            System.out.println("Res : " + res);
//        } catch (Exception e) {
//            System.out.println("Error " + e.getMessage());
//        }
        fill();
    }
    public static int sum2(String[][] arr) {
        if (arr == null) {
            throw new RuntimeException("Array is null");
        }
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            try {
                for (int j = 0; j < 5; j++) {
                    try {
                        int val = Integer.parseInt(arr[i][j]);
                        sum +=val;
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Wrong number : " + arr[i][j]);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new RuntimeException("Second level of array less then 5");
            }
        }
        return sum;
    }

    public static void fill() {
        int arr1Length = getNumber("Input first array length");
        boolean ok2 = false;
        while (!ok2) {
            try {
                int arr2Length = getNumber("Input second array length");
                checkLengths(arr1Length, arr2Length);
                ok2 = true;
            } catch (Exception e) {
                System.out.println("Wrong size of second array, try again");
            }
        }
        int[] arr1 = new int[arr1Length];
        int[] arr2 = new int[arr1Length];
        for (int i = 0; i < arr1Length; i++) {
            int num = getNumber("Input " + i + " element of first array");
            arr1[i] = num;
        }
        for (int i = 0; i < arr1Length; i++) {
            int num = getNumber("Input " + i + " element of second array");
            arr2[i] = num;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private static void checkLengths(int arr1Length, int arr2Length) throws Exception {
        if (arr1Length != arr2Length) {
            throw new Exception("Length of both arrays should be equals, try again");
        }
    }

    public static int getNumber(String message) {
        System.out.println(message);
        boolean ok = false;
        while(!ok) {
            try {
                Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                return num;
            } catch (Exception e) {
                System.out.println("Wrong number, try again.");
            }
        }
        return -1;
    }
}