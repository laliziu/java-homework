package Homework.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class task1 {
    // Пусть дан произвольный список целых чисел.

    // 1) Нужно удалить из него чётные числа

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 25, 4, 3, 17, 20));

        System.out.println(list1);

        list1.removeIf(a -> (a % 2 == 0));

        System.out.println(list1);
    }
}
