package Homework.hw1;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
//         1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
// 1 + 2 + 3 1*2*3
        Scanner iScanner = new Scanner(System.in);
        System.out.print(" Input the num: ");
        int num = iScanner.nextInt();
        int sum = 0;
        int fac = 1;
        for (int i = 1; i <= num; i++) {
            sum+=i;
            fac*=i;
        }
        System.out.printf("The sum  - %d, The factorial1 - %d", sum, fac);
        iScanner.close();
    }
}
