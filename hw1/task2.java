package Homework.hw1;

import java.util.Scanner;

public class task2 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // 2) Вывести все простые числа от 1 до 1000
        Scanner number = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = number.nextInt();
        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
            System.out.println(i);
            }
        }

    }
}
