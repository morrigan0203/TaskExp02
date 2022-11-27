package com.jexp2;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainHomeWork {
    public static void main(String[] args) throws Exception {
        // 1.
        float f = getNumber("Please input float number : ");
        System.out.println("Number is " + f);

        // 2.
        // a. need create variable array with at least 9 elements
        // b. divide on 0 always will be throw exception, if need fix it (int d = 5;)
        // c. if we want to get double result need to convert one of int number to double (intArray[8]*1d)
        task2();

        // 3.
        // a. method body doesn't throw FileNotFoundException,
        // b. need to remove throws FileNotFoundException from method declaration
        // Move catch(Throwable to the last catch, if no, catch Throwable will be catch all exception )
        // c. to fix IndexOutOfBoundsException, need to increase array abc, or set 9 to 0 or 1 element of array
        task3();

        // 4.
        try {
            String res = task4();
            System.out.println("Input string is : " + res);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public static String task4() throws Exception {
        System.out.println("Please input string, you should not input empty string");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.isEmpty()) {
            throw new Exception("Input String should not be empty.");
        }
        return str;
    }

    public static void task3() throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);

            // to fix IndexOutOfBoundsException, need to increase array abc, or set 9 to 0 or 1 element of array
            int[] abc = { 1, 2 , 3, 4};
            abc[3] = 9;
            // Move catch(Throwable to the last catch, if no, catch Throwable will be catch all exception )
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    // method body doesn't throw FileNotFoundException,
    // need to remove throws FileNotFoundException from method declaration
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    public static void task2() {
        // need create variable array with at least 9 elements
        int[] intArray = {1,2,3,4,5,6,7,8,9};
        try {
            // divide on 0 always will be throw exception, if need fix it
//            int d = 0;
            int d = 5;
            // if we want to get double result need to convert one of int number to double
            double catchedRes1 = (intArray[8]*1d) / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }

    public static float getNumber(String message) {
        System.out.println(message);
        boolean ok = false;
        while(!ok) {
            try {
                Scanner sc = new Scanner(System.in);
                float num = sc.nextFloat();
                return num;
            } catch (Exception e) {
                System.out.println("Wrong number, try again.");
            }
        }
        return -1;
    }
}
