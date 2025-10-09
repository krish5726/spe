package com.example.calc;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static void printMenu() {
        System.out.println("\nScientific Calculator - Menu");
        System.out.println("1) Square root (√x)");
        System.out.println("2) Factorial (!x)");
        System.out.println("3) Natural logarithm (ln(x))");
        System.out.println("4) Power (x^b)");
        System.out.println("0) Exit");
        System.out.print("Choose an option: ");
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                printMenu();
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Exiting. Goodbye!");
                        sc.close();
                        return;
                    case 1:
                        System.out.print("Enter x (>=0): ");
                        double x = sc.nextDouble();
                        System.out.println("√" + x + " = " + calc.sqrt(x));
                        break;
                    case 2:
                        System.out.print("Enter non-negative integer n: ");
                        int n = sc.nextInt();
                        BigInteger fact = calc.factorial(n);
                        System.out.println(n + "! = " + fact.toString());
                        break;
                    case 3:
                        System.out.print("Enter x (>0): ");
                        double lx = sc.nextDouble();
                        System.out.println("ln(" + lx + ") = " + calc.ln(lx));
                        break;
                    case 4:
                        System.out.print("Enter base x: ");
                        double base = sc.nextDouble();
                        System.out.print("Enter exponent b: ");
                        double exp = sc.nextDouble();
                        System.out.println(base + "^" + exp + " = " + calc.power(base, exp));
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter numbers only.");
                sc.nextLine(); // clear invalid input
            } catch (IllegalArgumentException iae) {
                System.out.println("Error: " + iae.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
