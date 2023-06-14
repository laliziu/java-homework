package Homework.hw1;

import java.util.Scanner;

public class task3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 3) Реализовать простой калькулятор (+-/*)
        Scanner calculate = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        float a = calculate.nextFloat();
        System.out.print("Enter the second number: ");
        float b = calculate.nextFloat();
        System.out.print("Enter the operation(+,-,*,/): ");
        char operation = calculate.next().charAt(0);
        if (operation == '+') {
            float result = a + b;
            System.out.println(result);
        } else if (operation == '-') {
            float result1 = a - b;
            System.out.println(result1);
        } else if (operation == '*') {
            float result2 = a * b;
            System.out.println(result2);
        } else if (operation == '/') {
            float result3 = a / b;
            System.out.println(result3);

        }
    }
}
