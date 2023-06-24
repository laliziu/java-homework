package Homework.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task2 {
    // 2) Найти минимальное значение

    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < 10; i++) {
            mylist.add(rnd.nextInt(100));

        }
        System.out.println(mylist);
        int min_position = 0;
        for (int i = 1; i < mylist.size(); i++) {
            if (mylist.get(i) < mylist.get(min_position)) {
                min_position = i;
            }
        }
        System.out.println(mylist.get(min_position));
    }
}
